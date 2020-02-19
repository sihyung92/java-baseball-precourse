package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
    static final int DIGIT = 3;
    static final int MENU_DIGIT = 1;
    static final int CONTINUE_VALUE = 1;
    static final int EXIT_VALUE = 2;
    static final int INITIAL_VALUE = 0;

    private BaseballNumber playerInput;
    private BaseballNumber answer;

    Baseball() {
        makeRandomDigit();
    }

    private void makeRandomDigit() {
        List<Integer> answer = new ArrayList<>();
        Random random = new Random();
        while (answer.size() != DIGIT) {
            int x = random.nextInt(8) + 1;
            if (answer.contains(x)) {
                continue;
            }
            answer.add(x);
        }

        this.answer = new BaseballNumber(answer);
    }

    public Result createResult(String input) {
        playerInput = new BaseballNumber(input);
        int strike = INITIAL_VALUE;
        int ball = INITIAL_VALUE;
        for (int i = 0; i < DIGIT; i++) {
            if (playerInput.get(i) == answer.get(i)) {
                strike++;
                continue;
            }
            if (answer.contains(playerInput.get(i)))
                ball++;
        }
        return new Result(strike, ball, DIGIT);
    }

    public String getAnswer() {
        return answer.toString();
    }
}
