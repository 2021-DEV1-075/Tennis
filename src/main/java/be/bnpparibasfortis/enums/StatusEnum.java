package be.bnpparibasfortis.enums;

public enum StatusEnum {

	WINS(3, 0, "wins"), ADVANTAGE(2, 0, "advantage"), DEUCE(1, 0, "deuce"), ALL(0, 0, "all");

	private Integer pointsOfPlayerOne;
	private Integer pointsOfPlayerTwo;
	private String status;

	StatusEnum(Integer pointsOfPlayerOne, Integer pointsOfPlayerTwo, String status) {
		this.pointsOfPlayerOne = pointsOfPlayerOne;
		this.pointsOfPlayerTwo = pointsOfPlayerTwo;
		this.status = status;
	}

	public Integer getPointsOfPlayerOne() {
		return this.pointsOfPlayerOne;
	}

	public void setPointsOfPlayerOne(Integer pointsOfPlayerOne) {
		this.pointsOfPlayerOne = pointsOfPlayerOne;
	}

	public Integer getPointsOfPlayerTwo() {
		return this.pointsOfPlayerTwo;
	}

	public void setPointsOfPlayerTwo(Integer pointsOfPlayerTwo) {
		this.pointsOfPlayerTwo = pointsOfPlayerTwo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
