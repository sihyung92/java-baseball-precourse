package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    Validator validator = new Validator();

    @DisplayName("유저가 입력한 세자리 숫자 validate")
    @ParameterizedTest
    @CsvSource(value = {"123,true", "111,false", "9999,false","문자열,false"})
    void inputValidTest(String input, boolean expectedResult) {
        assertThat(validator.playerInputValidate(input)).isEqualTo(expectedResult);
    }

    @DisplayName("유저가 null 혹은 empty값을 입력한 경우 validate")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullOrEmptyTest(String input) {
        assertThat(validator.playerInputValidate(input)).isFalse();
    }

    @DisplayName("메뉴 선택값 validate")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,false", "9999,false","문자열,false"})
    void menuValidTest(String input, boolean expectedResult) {
        assertThat(validator.selectedMenuValidate(input)).isEqualTo(expectedResult);
    }
}
