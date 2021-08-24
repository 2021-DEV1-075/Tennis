package be.bnpparibasfortis.test.unit.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.repository.ScoreRepository;
import be.bnpparibasfortis.service.ScoreService;

@SpringBootTest
@DisplayName("A unit test for ScoreService")
public class ScoreServiceTest {

	@Mock
	private ScoreRepository scoreRepository;

	@InjectMocks
	private ScoreService scoreService;

	@Test
	@Order(1)
	@DisplayName("Tests the retrieving of a score.")
	public void getById() throws BusinessException {
	}

	@Test
	@Order(2)
	@DisplayName("Tests the update of a score.")
	public void update() throws BusinessException {
	}
}
