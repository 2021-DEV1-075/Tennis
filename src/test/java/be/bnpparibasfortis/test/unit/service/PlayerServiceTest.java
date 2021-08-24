package be.bnpparibasfortis.test.unit.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.repository.PlayerRepository;
import be.bnpparibasfortis.service.PlayerService;

@SpringBootTest
@DisplayName("A unit test for PlayerService")
public class PlayerServiceTest {

	@Mock
	private PlayerRepository playerRepository;
	
	@InjectMocks
	private PlayerService playerService;

	@Test
    @Order(1)
    @DisplayName("Tests the creation of a players.")
	public void save() throws BusinessException {
	}
	
	@Test
    @Order(2)
    @DisplayName("Tests the creation of a players.")
	public void getById() throws BusinessException {
	}
}

