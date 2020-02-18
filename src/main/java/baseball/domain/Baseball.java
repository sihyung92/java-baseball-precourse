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

    private List<Integer> playerInput;
    private List<Integer> answer;
    private int strike;
    private int ball;

    Baseball() {
        makeRandomDigit();
        strike = 0;
        ball = 0;
    }

    private void makeRandomDigit() {
        answer = new ArrayList<>();
        Random random = new Random();
        while (answer.size() != DIGIT) {
            int x = random.nextInt(8) + 1;
            if (answer.contains(x)) {
                continue;
            }
            answer.add(x);
        }
    }

    public Result createResult() {
        clean();
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

    private void clean() {
        strike = INITIAL_VALUE;
        ball = INITIAL_VALUE;
    }

    public void setInput(String input) {
        this.playerInput = stringToList(input);
    }

    private List<Integer> stringToList(String input) {
        char[] chars = input.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char i : chars) {
            list.add(i - '0'); // 숫자 character를 int 값으로 변환
        }
        return list;
    }
}
