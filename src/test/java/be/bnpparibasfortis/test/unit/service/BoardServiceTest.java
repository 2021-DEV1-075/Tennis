package be.bnpparibasfortis.test.unit.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import be.bnpparibasfortis.repository.BoardRepository;
import be.bnpparibasfortis.service.BoardService;
import be.bnpparibasfortis.service.PlayerService;
import be.bnpparibasfortis.service.ScoreService;

@SpringBootTest
@DisplayName("A unit test for BoardService")
public class BoardServiceTest {

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
	}

	@Test
	@Order(2)
	@DisplayName("Tests revieving a board for 2 players.")
	public void getById() {
	}

	@Test
	@Order(3)
	@DisplayName("Tests revieving a board for 2 players.")
	public void playerOneScores() {
	}

	@Test
	@Order(4)
	@DisplayName("Tests revieving a board for 2 players.")
	public void playerTwoScores() {
	}

	/**
	 * Winner = (pointsA >= 4 && pointsA >= pointsB + 2)
	 */
	@Test
	@Order(5)
	@DisplayName("Tests revieving a board status for an winner.")
	public void getStatusForWinner() {
	}

	/**
	 * Advantage = (pointsOfPlayerTwo >= 4 && pointsOfPlayerTwo == pointsOfPlayerOne
	 * + 1)
	 */
	@Test
	@Order(6)
	@DisplayName("Tests revieving a board status for advantage.")
	public void getStatusForAdvantage() {
	}

	/**
	 * Deuce = (pointsOfPlayerOne >= 3 && pointsOfPlayerTwo == pointsOfPlayerOne)
	 */
	@Test
	@Order(7)
	@DisplayName("Tests revieving a board status for deuce.")
	public void getStatusForDeuce() {
	}

	/**
	 * All = (pointsOfPlayerOne == pointsOfPlayerTwo)
	 */
	@Test
	@Order(8)
	@DisplayName("Tests revieving a board status for all.")
	public void getStatusForAll() {
	}

	/**
	 * Default 
	 */
	@Test
	@Order(9)
	@DisplayName("Tests revieving a board status for default.")
	public void getStatusForDefault() {
	}

}
