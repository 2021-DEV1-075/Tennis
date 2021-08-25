package be.bnpparibasfortis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import be.bnpparibasfortis.dto.BoardRequest;
import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Board;
import be.bnpparibasfortis.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/tennis-api/boards")
@Api(tags = { "Board" }, description = "Service for boards"
		+ "<p style='color:black; font-size: 0.9em; font-weight: normal;'>"
		+ "Don't forget to create the players and board before searching for a game's status or to increase the players' points."
		+ "</p>")

public class BoardController {

	@Autowired
	BoardService boardService;

	@ApiOperation(value = "Retrieves the status of the game against the board.", notes = "<p style='color:#999999; font-weight: normal;'>The scoring system is rather simple:</p>"
			+ "<div style='color:#999999; font-weight: normal;'>" + "  <ol>"
			+ "    <li>Each player can have either of these points in one game “love” “15” “30” “40”</li>"
			+ "    <li>If you have 40 and you win the point you win the game, however there are special rules.</li>"
			+ "    <li>If both have 40 the players are “deuce”.</li>"
			+ "    <li>If the game is in deuce, the winner of a point will have advantage</li>"
			+ "    <li>If the player with advantage wins the ball he wins the game</li>"
			+ "    <li>If the player without advantage wins they are back at deuce.</li>" + "  </ol>" + "</div>")
	@GetMapping(path = "/${boardId}/status", produces = "application/json")
	public ResponseEntity<String> getStatus(
			@ApiParam(value = "Board Id", required = true) @PathVariable(name = "boardId") Long boardId)
			throws BusinessException {
		return ResponseEntity.ok(boardService.getStatusByBoardId(boardId));
	}

	@ApiOperation(value = "Increases the player's 1 score against the board.")
	@PutMapping(path = "/${boardId}/playeronescores", produces = "application/json")
	public ResponseEntity<Integer> playerOneScores(
			@ApiParam(value = "Board Id", required = true) @PathVariable(name = "boardId") Long boardId)
			throws BusinessException {
		return ResponseEntity.ok(boardService.playerOneScores(boardId));
	}

	@ApiOperation(value = "Increases the player's 2 score against the board.")
	@PutMapping(path = "/${boardId}/playertwoscores", produces = "application/json")
	public ResponseEntity<Integer> playerTwoScores(
			@ApiParam(value = "Board Id", required = true) @PathVariable(name = "boardId") Long boardId)
			throws BusinessException {
		return ResponseEntity.ok(boardService.playerTwoScores(boardId));
	}

	@ApiOperation(value = "Creates the board for a new game set.", response = Board.class)
	@PostMapping(path = "/", produces = "application/json")
	public ResponseEntity<Board> save(
			@RequestBody @ApiParam(value = "The players for a new board game.", required = true) BoardRequest body)
			throws BusinessException {
		return ResponseEntity.ok(boardService.save(body.getPlayerOneId(), body.getPlayerTwoId()));
	}
}