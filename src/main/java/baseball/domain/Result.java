package baseball.domain;

public class Result {
    private String resultMessage;
    private int strike;
    private int ball;
    private boolean isCorrect;
    private final int DIGIT;

    Result(int strike, int ball, int digit) {
        this.strike = strike;
        this.ball = ball;
        this.DIGIT = digit;
        createMessage();
    }

    private void createMessage() {
        StringBuilder result = new StringBuilder();

        if (strike == 0 && ball == 0)
            result.append("낫씽");
        if (strike > 0)
            result.append(strike + "스트라이크 ");
        if (ball > 0)
            result.append(ball + "볼 ");
        if (strike == DIGIT) {
            result.append(DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isCorrect = true;
        }

        this.resultMessage = result.toString();
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }
}
