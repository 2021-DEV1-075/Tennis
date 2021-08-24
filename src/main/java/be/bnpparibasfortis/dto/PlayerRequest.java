package be.bnpparibasfortis.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlayerRequest", description = "An object for safe transferring player data, to be used from the request.")
public class PlayerRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(required = true, value = "The Player name.")
	private String playerName;

	public PlayerRequest() {
		super();
	}

	public PlayerRequest(String playerName) {
		super();
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
