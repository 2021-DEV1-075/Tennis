package be.bnpparibasfortis.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "score")
@ApiModel(value = "Score", description = "An object for safe transferring score data, to be used from the response.")
public class Score implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(value = "The Score identifier.", hidden = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "POINTS")
	@ApiModelProperty(value = "The Score points by player.", required = true)
	private Integer points;

	public Score() {
		super();
	}

	public Score(Integer points) {
		super();
		this.points = points;
	}

	public Score(Long id, Integer points) {
		super();
		this.id = id;
		this.points = points;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, points);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(this.id, other.id) && Objects.equals(this.points, other.points);
	}

}
