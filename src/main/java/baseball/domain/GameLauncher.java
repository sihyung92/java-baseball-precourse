package baseball.domain;

public class GameLauncher {
    static final int CONTINUE_VALUE = 1;
    static final int EXIT_VALUE = 2;

    public static void main(String[] args) {
        while (true) {
            startGame();
            String input = InputView.getSelectedMenu();
            if (isContinue(input))
                continue;
            if (isExit(input))
                break;
        }
        InputView.close();
    }

    public static void startGame() {
        Baseball game = new Baseball();

        while (true) {
            Result result = game.createResult(InputView.getPlayerInput());
            System.out.println(result.getResultMessage());

            if (result.isCorrect())
                break;
        }
    }

    private static boolean isContinue(String input) {
        return input.equals(String.valueOf(CONTINUE_VALUE));
    }

    private static boolean isExit(String input) {
        return input.equals(String.valueOf(EXIT_VALUE));
    }
}
