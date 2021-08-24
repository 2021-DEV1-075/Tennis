package be.bnpparibasfortis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.bnpparibasfortis.config.MessageEnum;
import be.bnpparibasfortis.config.MessageSource;
import be.bnpparibasfortis.enums.ScoreEnum;
import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Board;
import be.bnpparibasfortis.model.Player;
import be.bnpparibasfortis.model.Score;
import be.bnpparibasfortis.repository.BoardRepository;

@Service
public class BoardService {

	public static final int INCREASE_AMOUNT = 1;

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private ScoreService scoreService;

	public Board save(Long playerOneId, Long playerTwoId) throws BusinessException {
		Player playerOne = playerService.getById(playerOneId);
		Player playerTwo = playerService.getById(playerTwoId);
		Board board = new Board(playerOne, playerTwo, new Score(0), new Score(0));
		return boardRepository.save(board);
	}

	public Board getById(Long id) throws BusinessException {
		return boardRepository.findById(id)
				.orElseThrow(() -> new BusinessException(MessageSource.get().message(MessageEnum.ERR02, id)));
	}

	public void playerOneScores(Long boardId) throws BusinessException {
		Board board = getById(boardId);
		playerScores(board.getScoreOne());
	}

	public void playerTwoScores(Long boardId) throws BusinessException {
		Board board = getById(boardId);
		playerScores(board.getScoreTwo());
	}

	public String getStatusByBoardId(Long boardId) throws BusinessException {
		Board board = getById(boardId);
		Integer pointsOfPlayerOne = board.getScoreOne().getPoints();
		Integer pointsOfPlayerTwo = board.getScoreTwo().getPoints();

		Player player = playerWithHighestScore(board);
		if (isWinner(pointsOfPlayerOne, pointsOfPlayerTwo) || isWinner(pointsOfPlayerTwo, pointsOfPlayerOne)) {
			return MessageSource.get().message(MessageEnum.MSG01.getKey(), player.getName());
		}

		if (hasAdvantage(pointsOfPlayerOne, pointsOfPlayerTwo) || hasAdvantage(pointsOfPlayerTwo, pointsOfPlayerOne)) {
			return MessageSource.get().message(MessageEnum.MSG02.getKey(), player.getName());
		}

		if (pointsOfPlayerOne >= 3 && pointsOfPlayerTwo == pointsOfPlayerOne)
			return MessageSource.get().message(MessageEnum.MSG03.getKey());

		if (pointsOfPlayerOne == pointsOfPlayerTwo) {
			return MessageSource.get().message(MessageEnum.MSG04.getKey(), ScoreEnum.getDisplay(pointsOfPlayerOne));
		}

		return MessageSource.get().message(MessageEnum.MSG05.getKey(), ScoreEnum.getDisplay(pointsOfPlayerOne),
				ScoreEnum.getDisplay(pointsOfPlayerTwo));
	}

	private Player playerWithHighestScore(Board board) throws BusinessException {
		if (board.getScoreOne().getPoints() > board.getScoreTwo().getPoints()) {
			return board.getPlayerOne();
		}
		return board.getPlayerTwo();
	}

	private Boolean isWinner(Integer pointsA, Integer pointsB) {
		if (pointsA >= 4 && pointsA >= pointsB + 2) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private Boolean hasAdvantage(Integer pointsA, Integer pointsB) {
		if (pointsB >= 4 && pointsB == pointsA + 1) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private void playerScores(Score score) throws BusinessException {
		Integer currentPoints = score.getPoints();
		scoreService.update(score.getId(), currentPoints + INCREASE_AMOUNT);
	}
}
