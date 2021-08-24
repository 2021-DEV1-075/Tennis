package be.bnpparibasfortis.test.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import be.bnpparibasfortis.config.MessageEnum;
import be.bnpparibasfortis.config.MessageSource;
import be.bnpparibasfortis.enums.ScoreEnum;
import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Board;
import be.bnpparibasfortis.model.Player;
import be.bnpparibasfortis.model.Score;
import be.bnpparibasfortis.repository.BoardRepository;
import be.bnpparibasfortis.service.BoardService;
import be.bnpparibasfortis.service.PlayerService;
import be.bnpparibasfortis.service.ScoreService;

@SpringBootTest
@DisplayName("A unit test for BoardService")
public class BoardServiceTest {

	private static final Integer DEFAULT_POINTS = 0;
	private static final Long BOARD_ID = 1L;
	private static final Long PLAYER_ONE_ID = 1L;
	private static final Long PLAYER_TWO_ID = 2L;
	private static final Long SCORE_ONE_ID = 1L;
	private static final Long SCORE_TWO_ID = 2L;
	private static final String PLAYER_ONE_NAME = "Player One";
	private static final String PLAYER_TWO_NAME = "Player Two";

	@Mock
	private PlayerService playerService;

	@Mock
	private ScoreService scoreService;

	@Mock
	private BoardRepository boardRepository;

	@InjectMocks
	private BoardService boardService;
	
	@Test
	@Order(1)
	@DisplayName("Tests the creation of a board for 2 players.")
	public void save() {
		Assertions.assertAll("main save check", () -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			Assertions.assertDoesNotThrow(() -> {

				mockSaveBoard(playerOne, playerTwo);
				mockGetPlayerById(PLAYER_ONE_ID, playerOne);
				mockGetPlayerById(PLAYER_TWO_ID, playerTwo);

				Board board = boardService.save(playerOne.getId(), playerTwo.getId());

				Assertions.assertAll("board with players check",
						() -> Assertions.assertEquals(PLAYER_ONE_NAME, board.getPlayerOne().getName()),
						() -> Assertions.assertEquals(DEFAULT_POINTS, board.getScoreOne().getPoints()),
						() -> Assertions.assertEquals(PLAYER_TWO_NAME, board.getPlayerTwo().getName()),
						() -> Assertions.assertEquals(DEFAULT_POINTS, board.getScoreTwo().getPoints()));
			});
		});
	}

	@Test
	@Order(2)
	@DisplayName("Tests revieving a board for 2 players.")
	public void getById() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			mockSaveBoard(playerOne, playerTwo);
			mockGetPlayerById(PLAYER_ONE_ID, playerOne);
			mockGetPlayerById(PLAYER_TWO_ID, playerTwo);

			mockSaveBoard(playerOne, playerTwo);
			mockGetPlayerById(PLAYER_ONE_ID, playerOne);
			mockGetPlayerById(PLAYER_TWO_ID, playerTwo);
			Board board = boardService.save(playerOne.getId(), playerTwo.getId());

			mockFindBoardById(BOARD_ID, board);
			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));
		});
	}

	@Test
	@Order(3)
	@DisplayName("Tests revieving a board for 2 players.")
	public void playerOneScores() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			mockSaveBoard(playerOne, playerTwo);
			mockGetPlayerById(PLAYER_ONE_ID, playerOne);
			mockGetPlayerById(PLAYER_TWO_ID, playerTwo);

			mockSaveBoard(playerOne, playerTwo);
			mockGetPlayerById(PLAYER_ONE_ID, playerOne);
			mockGetPlayerById(PLAYER_TWO_ID, playerTwo);
			Board board = boardService.save(playerOne.getId(), playerTwo.getId());

			mockFindBoardById(BOARD_ID, board);
			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));

			Integer newPoints = DEFAULT_POINTS + BoardService.INCREASE_AMOUNT;
			mockUpdateScore(SCORE_ONE_ID, newPoints);
			boardService.playerOneScores(BOARD_ID);
		});
	}

	@Test
	@Order(4)
	@DisplayName("Tests revieving a board for 2 players.")
	public void playerTwoScores() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			mockSaveBoard(playerOne, playerTwo);
			mockGetPlayerById(PLAYER_ONE_ID, playerOne);
			mockGetPlayerById(PLAYER_TWO_ID, playerTwo);

			mockSaveBoard(playerOne, playerTwo);
			mockGetPlayerById(PLAYER_ONE_ID, playerOne);
			mockGetPlayerById(PLAYER_TWO_ID, playerTwo);
			Board board = boardService.save(playerOne.getId(), playerTwo.getId());

			mockFindBoardById(BOARD_ID, board);
			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));

			Integer newPoints = DEFAULT_POINTS + BoardService.INCREASE_AMOUNT;
			mockUpdateScore(SCORE_TWO_ID, newPoints);
			boardService.playerTwoScores(BOARD_ID);
		});
	}

	/**
	 * Winner = (pointsA >= 4 && pointsA >= pointsB + 2)
	 */
	@Test
	@Order(5)
	@DisplayName("Tests revieving a board status for an winner.")
	public void getStatusForWinner() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			Board board = new Board(BOARD_ID, playerOne, playerTwo, new Score(4), new Score(1));
			mockFindBoardById(BOARD_ID, board);

			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));
			String status = boardService.getStatusByBoardId(BOARD_ID);

			String expected = MessageSource.get().message(MessageEnum.MSG01.getKey(), playerOne.getName());
			assertEquals(status, expected);
		});
	}

	/**
	 * Advantage = (pointsOfPlayerTwo >= 4 && pointsOfPlayerTwo == pointsOfPlayerOne
	 * + 1)
	 */
	@Test
	@Order(6)
	@DisplayName("Tests revieving a board status for advantage.")
	public void getStatusForAdvantage() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			Board board = new Board(BOARD_ID, playerOne, playerTwo, new Score(4), new Score(3));
			mockFindBoardById(BOARD_ID, board);

			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));
			String status = boardService.getStatusByBoardId(BOARD_ID);

			String expected = MessageSource.get().message(MessageEnum.MSG02.getKey(), playerOne.getName());
			assertEquals(status, expected);
		});
	}

	/**
	 * Deuce = (pointsOfPlayerOne >= 3 && pointsOfPlayerTwo == pointsOfPlayerOne)
	 */
	@Test
	@Order(7)
	@DisplayName("Tests revieving a board status for deuce.")
	public void getStatusForDeuce() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			Board board = new Board(BOARD_ID, playerOne, playerTwo, new Score(3), new Score(3));
			mockFindBoardById(BOARD_ID, board);

			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));
			String status = boardService.getStatusByBoardId(BOARD_ID);

			String expected = MessageSource.get().message(MessageEnum.MSG03.getKey(), playerOne.getName());
			assertEquals(status, expected);
		});
	}

	/**
	 * All = (pointsOfPlayerOne == pointsOfPlayerTwo)
	 */
	@Test
	@Order(8)
	@DisplayName("Tests revieving a board status for all.")
	public void getStatusForAll() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			Board board = new Board(BOARD_ID, playerOne, playerTwo, new Score(2), new Score(2));
			mockFindBoardById(BOARD_ID, board);

			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));
			String status = boardService.getStatusByBoardId(BOARD_ID);

			String expected = MessageSource.get().message(MessageEnum.MSG04.getKey(),
					ScoreEnum.getDisplay(board.getScoreOne().getPoints()));
			assertEquals(status, expected);
		});
	}

	/**
	 * Default 
	 */
	@Test
	@Order(9)
	@DisplayName("Tests revieving a board status for default.")
	public void getStatusForDefault() {
		Assertions.assertDoesNotThrow(() -> {

			Player playerOne = savePlayer(PLAYER_ONE_ID, PLAYER_ONE_NAME);
			Player playerTwo = savePlayer(PLAYER_TWO_ID, PLAYER_TWO_NAME);

			Board board = new Board(BOARD_ID, playerOne, playerTwo, new Score(0), new Score(1));
			mockFindBoardById(BOARD_ID, board);

			Assertions.assertTrue(boardService.getById(BOARD_ID).equals(board));
			String status = boardService.getStatusByBoardId(BOARD_ID);

			String expected = MessageSource.get().message(MessageEnum.MSG05.getKey(),
					ScoreEnum.getDisplay(board.getScoreOne().getPoints()),
					ScoreEnum.getDisplay(board.getScoreTwo().getPoints()));
			assertEquals(status, expected);
		});
	}

	private Player savePlayer(Long id, String name) throws BusinessException {
		mockSavePlayer(id, name);
		return playerService.save(name);
	}
	
	private void mockGetPlayerById(Long playerId, Player player) throws BusinessException {
		Mockito.when(playerService.getById(playerId)).thenReturn(player);
	}

	private void mockFindBoardById(Long boardId, Board board) {
		Mockito.when(boardRepository.findById(boardId)).thenReturn(Optional.ofNullable(board));
	}

	private void mockSaveBoard(Player playerOne, Player playerTwo) {
		Mockito.when(boardRepository.save(Mockito.any(Board.class))).thenReturn(new Board(BOARD_ID, playerOne,
				playerTwo, new Score(SCORE_ONE_ID, DEFAULT_POINTS), new Score(SCORE_ONE_ID, DEFAULT_POINTS)));
	}

	private void mockSavePlayer(Long playerId, String playerName) throws BusinessException {
		Mockito.when(playerService.save(playerName)).thenReturn(new Player(playerId, playerName));
	}

	private void mockUpdateScore(Long scoreId, Integer points) throws BusinessException {
		Mockito.when(scoreService.update(scoreId, points)).thenReturn(new Score(scoreId, points));
	}
}