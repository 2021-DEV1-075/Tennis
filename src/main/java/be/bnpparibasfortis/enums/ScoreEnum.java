package be.bnpparibasfortis.enums;

import java.util.Optional;
import java.util.stream.Stream;

import be.bnpparibasfortis.config.MessageEnum;
import be.bnpparibasfortis.config.MessageSource;
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
		Stream<ScoreEnum> stream = Stream.of(ScoreEnum.values());
		Optional<ScoreEnum> result = stream.filter(s -> s.getScore() == score).findFirst();
		return result.orElseThrow(() -> new BusinessException(MessageSource.get().message(MessageEnum.ERR03, score)))
				.getDisplay();
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
