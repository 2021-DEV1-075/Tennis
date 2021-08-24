package be.bnpparibasfortis.test.unit.enums;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import be.bnpparibasfortis.config.MessageSource;
import be.bnpparibasfortis.enums.ScoreEnum;
import be.bnpparibasfortis.exception.BusinessException;

@SpringBootTest
@DisplayName("A unit test for ScoreEnum")
public class ScoreEnumTest {

	private static final Integer WRONG_SCORE = -1;

	@InjectMocks
	private MessageSource messageSource;

	@DisplayName("Tests if all of messages exists.")
	@ParameterizedTest
	@EnumSource(ScoreEnum.class)
	public void displayByScore(ScoreEnum msg) {
		Assertions.assertAll("display all check", () -> {
			Assertions.assertDoesNotThrow(() -> {
				assertNotNull(ScoreEnum.getDisplay(msg.getScore()));
			});
		});
	}

	@Test
	@DisplayName("Tests if a wrong score throws exception.")
	public void displayForWrongScore() {
		Assertions.assertAll("display wrong score check", () -> {
			Assertions.assertThrows(BusinessException.class, () -> {
				assertNull(ScoreEnum.getDisplay(WRONG_SCORE));
			});
		});
	}
}
