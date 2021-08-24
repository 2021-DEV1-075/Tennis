package be.bnpparibasfortis.enums;

import be.bnpparibasfortis.exception.BusinessException;

public enum ScoreEnum {

	FORTY(3, "Forty"), THIRTY(2, "Thirty"), FIFTEEN(1, "Fifteen"), LOVE(0, "Love");

	private Integer score;
	private String display;

	ScoreEnum(Integer score, String display) {
		this.score = score;
		this.display = display;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDisplay() {
		return this.display;
	}

	public static String getDisplay(Integer score) throws BusinessException {
		return null;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
