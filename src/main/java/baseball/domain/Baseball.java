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
    static final String INITIAL_MESSAGE = "";

    private List<Integer> playerInput;
    private List<Integer> answer;
    private int strike;
    private int ball;
    private String resultMessage;

    Baseball() {
        makeRandomDigit();
        strike = 0;
        ball = 0;
        resultMessage = "";
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

    public void createResult() {
        clean();
        for (int i = 0; i < DIGIT; i++) {
            if (playerInput.get(i) == answer.get(i)) {
                strike++;
                continue;
            }
            if (answer.contains(playerInput.get(i)))
                ball++;
        }
        setResultMessage();
    }

    public void clean() {
        strike = INITIAL_VALUE;
        ball = INITIAL_VALUE;
        resultMessage = INITIAL_MESSAGE;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    private void setResultMessage() {
        StringBuilder resultMessage = new StringBuilder();

        if (strike == 0 && ball == 0)
            resultMessage.append("낫씽");
        if (strike > 0)
            resultMessage.append(strike + "스트라이크 ");
        if (ball > 0)
            resultMessage.append(ball + "볼 ");

        this.resultMessage = resultMessage.toString();
    }

    public int getStrike() {
        return this.strike;
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
