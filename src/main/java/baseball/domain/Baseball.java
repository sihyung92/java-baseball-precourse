package baseball.domain;

public class Baseball {
    static final int DIGIT = 3;
    static final int MENU_DIGIT = 1;
    static final int INITIAL_VALUE = 0;

    private BaseballNumber playerInput;
    private BaseballNumber answer;
    private int strike;
    private int ball;

    private void makeAnswerIfNotNull() {
        if (answer == null)
            this.answer = RandomBaseballNumberGenerator.makeRandomBaseballNumber(DIGIT);
    }

    public Result createResult(String input) {
        clean();
        makeAnswerIfNotNull();
        playerInput = new BaseballNumber(input);
        strike = calculateStrike(strike);
        ball = calculateBall(ball);
        return new Result(strike, ball, DIGIT);
    }

    public Result createResult(String input, BaseballNumber answer) {
        this.answer = answer;
        return createResult(input);
    }

    private void clean() {
        strike = INITIAL_VALUE;
        ball = INITIAL_VALUE;
    }

    private int calculateStrike(int strike) {
        for (int i = 0; i < DIGIT; i++) {
            if (playerInput.get(i) == answer.get(i))
                strike++;
        }
        return strike;
    }

    private int calculateBall(int ball) {
        for (int i = 0; i < DIGIT; i++) {
            if (playerInput.get(i) == answer.get(i)) continue;
            if (answer.contains(playerInput.get(i)))
                ball++;
        }
        return ball;
    }
}
