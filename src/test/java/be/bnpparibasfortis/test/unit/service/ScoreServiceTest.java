package be.bnpparibasfortis.test.unit.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Score;
import be.bnpparibasfortis.repository.ScoreRepository;
import be.bnpparibasfortis.service.ScoreService;

@SpringBootTest
@DisplayName("A unit test for Score Service")
public class ScoreServiceTest {

	private static final Integer DEFAULT_POINTS = 0;
	private static final Integer INCREASE = 1;
	private static final Long SCORE_ID = 1L;

	@Mock
	private ScoreRepository scoreRepository;

	@InjectMocks
	private ScoreService scoreService;

	@Test
	@Order(1)
	@DisplayName("Tests the retrieving of a score.")
	public void getById() throws BusinessException {
		Assertions.assertDoesNotThrow(() -> {
			Mockito.when(scoreRepository.findById(SCORE_ID))
					.thenReturn(Optional.ofNullable(new Score(SCORE_ID, DEFAULT_POINTS)));
			Score score = scoreService.getById(SCORE_ID);
			Assertions.assertAll("score check",
					() -> Assertions.assertTrue(score.equals(new Score(SCORE_ID, DEFAULT_POINTS))));
		});
	}

	@Test
	@Order(2)
	@DisplayName("Tests the update of a score.")
	public void update() throws BusinessException {
		Assertions.assertDoesNotThrow(() -> {
			Mockito.when(scoreRepository.findById(SCORE_ID))
					.thenReturn(Optional.ofNullable(new Score(SCORE_ID, DEFAULT_POINTS)));

			Integer newPoints = DEFAULT_POINTS + INCREASE;
			Mockito.when(scoreRepository.save(Mockito.any(Score.class))).thenReturn(new Score(SCORE_ID, newPoints));

			Score score = scoreService.update(SCORE_ID, newPoints);

			Assertions.assertAll("updated score check",
					() -> Assertions.assertTrue(score.equals(new Score(SCORE_ID, newPoints))));
		});
	}
}
