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
import be.bnpparibasfortis.model.Player;
import be.bnpparibasfortis.repository.PlayerRepository;
import be.bnpparibasfortis.service.PlayerService;

@SpringBootTest
@DisplayName("A unit test for PlayerService")
public class PlayerServiceTest {

	private static final Long PLAYER_ID = 1L;
	private static final String PLAYER_NAME = "Mansin, Tue";

	@Mock
	private PlayerRepository playerRepository;
	
	@InjectMocks
	private PlayerService playerService;

	@Test
    @Order(1)
    @DisplayName("Tests the creation of a players.")
	public void save() throws BusinessException {
		Player player = playerService.save(PLAYER_NAME);
		Assertions.assertEquals(PLAYER_NAME, player.getName());
		Assertions.assertEquals(PLAYER_ID, player.getId());
	}
	
	@Test
    @Order(2)
    @DisplayName("Tests the creation of a players.")
	public void getById() throws BusinessException {
		Player player = new Player(PLAYER_ID, PLAYER_NAME);
		Assertions.assertEquals(PLAYER_NAME, player.getName());
		Assertions.assertEquals(PLAYER_ID, player.getId());
	}
}
