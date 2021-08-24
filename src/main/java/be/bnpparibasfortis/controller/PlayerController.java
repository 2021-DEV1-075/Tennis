package be.bnpparibasfortis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bnpparibasfortis.dto.PlayerRequest;
import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Player;
import be.bnpparibasfortis.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/tennis-api/players")
@Api(tags = { "Player" }, description = "Service for players.")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	public PlayerController() {
    }
	
	public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
	
	@ApiOperation(value = "Retrieves the player.")
	@GetMapping("/${playerId}")
	public Player get(@ApiParam(value = "Player Id", required = true) 
	                  @PathVariable(name = "playerId") 
	                  Long playerId) throws BusinessException {
		return playerService.getById(playerId);
	}

	@ApiOperation(value = "Creates a new player.", response = Player.class)
	@PostMapping("/")
	public Player save(@RequestBody 
			           @ApiParam(value = "The new player.", required = true) 
			           PlayerRequest body) throws BusinessException {
		return playerService.save(body.getPlayerName());
	}
}
