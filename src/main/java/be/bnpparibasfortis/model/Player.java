package be.bnpparibasfortis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "player")
@ApiModel(value = "Player", description = "An object for safe transferring players data, to be used from the response.")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = "The Player Identifier", required = true)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	@ApiModelProperty(value = "The Player name", required = true)
	private String name;

	public Player() {
		super();
	}

	public Player(String playerName) {
		super();
		this.name = playerName;
	}

	public Player(Long playerId, String playerName) {
		super();
		this.id = playerId;
		this.name = playerName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
