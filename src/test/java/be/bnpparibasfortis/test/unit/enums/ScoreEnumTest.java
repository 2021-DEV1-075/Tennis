package be.bnpparibasfortis.test.unit.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import be.bnpparibasfortis.config.MessageSource;
import be.bnpparibasfortis.enums.ScoreEnum;

@SpringBootTest
@DisplayName("A unit test for ScoreEnum")
public class ScoreEnumTest {

	@InjectMocks
	private MessageSource messageSource;

    @DisplayName("Tests if all of messages exists.")
	@ParameterizedTest
	@EnumSource(ScoreEnum.class)
	public void displayByScore(ScoreEnum msg) {
		
	}

	@Test
    @DisplayName("Tests if a wrong score throws exception.")
	public void displayForWrongScore() {
		
	}
}
