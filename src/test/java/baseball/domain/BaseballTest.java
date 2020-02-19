package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {

    @DisplayName("세자릿수 랜덤숫자 생성 테스트")
    @Test
    void randomThreeDigitTest() {
        BaseballNumber bn = RandomBaseballNumberGenerator.makeRandomBaseballNumber(3);

        String target = bn.toString();

        Validator validator = new Validator();
        assertThat(validator.isDigit(target)
                && validator.validStringLength(target, Baseball.DIGIT)
                && validator.validOverlapAtOtherDigit(target))
                .isTrue();
    }

    @DisplayName("게임 로직 테스트")
    @ParameterizedTest
    @CsvSource(value = {"456:낫씽", "451:1볼", "321:1스트라이크 2볼", "124:2스트라이크 ",
            "123:3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료"}, delimiter = ':')
    void gameLogicTest(String input, String expectedMessage) {
        int[] answerArray = {1, 2, 3};
        Integer[] boxedArray = Arrays.stream(answerArray).boxed().toArray(Integer[]::new);
        List<Integer> answerList = new ArrayList();
        Collections.addAll(answerList, boxedArray); //answerList -> [1,2,3]

        String resultMessage = new Baseball().createResult(input, new BaseballNumber(answerList)).getResultMessage().trim();

        assertThat(resultMessage).isEqualTo(expectedMessage);
    }
}
