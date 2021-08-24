package be.bnpparibasfortis.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardRequest", description = "An object for safe transferring board data, to be used from the request.")
public class BoardRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(required = true, value = "The Player One identifier.")
	private Long playerOneId;

	@ApiModelProperty(required = true, value = "The Player Two identifier.")
	private Long playerTwoId;

	public Long getPlayerOneId() {
		return this.playerOneId;
	}

	public void setPlayerOneId(Long playerOneId) {
		this.playerOneId = playerOneId;
	}

	public Long getPlayerTwoId() {
		return this.playerTwoId;
	}

	public void setPlayerTwoId(Long playerTwoId) {
		this.playerTwoId = playerTwoId;
	}
}
