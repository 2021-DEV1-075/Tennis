package be.bnpparibasfortis.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "BOARD")
@ApiModel(value = "Board", description = "An object for safe transferring board data, to be used from the response.")
public class Board implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(value = "The Board identifier", required = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PLAYER_ONE_ID", referencedColumnName = "ID")
	@ApiModelProperty(value = "The Player One", required = true)
	private Player playerOne;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PLAYER_TWO_ID", referencedColumnName = "ID")
	@ApiModelProperty(value = "The Player Two", required = true)
	private Player playerTwo;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "SCORE_ONE_ID", referencedColumnName = "ID")
	@ApiModelProperty(value = "The Sore for Player One", required = true)
	private Score scoreOne;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "SCORE_TWO_ID", referencedColumnName = "ID")
	@ApiModelProperty(value = "The Score for Player Two", required = true)
	private Score scoreTwo;

	public Board() {
		super();
	}

	public Board(Player playerOne, Player playerTwo, Score scoreOne, Score scoreTwo) {
		super();
		this.setPlayerOne(playerOne);
		this.setPlayerTwo(playerTwo);
		this.setScoreOne(scoreOne);
		this.setScoreTwo(scoreTwo);
	}

	public Board(Long id, Player playerOne, Player playerTwo, Score scoreOne, Score scoreTwo) {
		super();
		this.id = id;
		this.setPlayerOne(playerOne);
		this.setPlayerTwo(playerTwo);
		this.setScoreOne(scoreOne);
		this.setScoreTwo(scoreTwo);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Score getScoreOne() {
		return this.scoreOne;
	}

	public void setScoreOne(Score scoreOne) {
		this.scoreOne = scoreOne;
	}

	public Score getScoreTwo() {
		return this.scoreTwo;
	}

	public void setScoreTwo(Score scoreTwo) {
		this.scoreTwo = scoreTwo;
	}

	public Player getPlayerOne() {
		return this.playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return this.playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, playerOne, playerTwo, scoreOne, scoreTwo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return Objects.equals(this.id, other.id) && Objects.equals(this.playerOne, other.playerOne)
				&& Objects.equals(this.playerTwo, other.playerTwo) && Objects.equals(this.scoreOne, other.scoreOne)
				&& Objects.equals(this.scoreTwo, other.scoreTwo);
	}

}
