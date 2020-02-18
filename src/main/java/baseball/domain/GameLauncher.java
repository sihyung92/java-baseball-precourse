package baseball.domain;

public class GameLauncher {
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
            game.setInput(InputView.getPlayerInput());
            Result result = game.createResult();
            System.out.println(result.getResultMessage());

            if (result.isCorrect())
                break;
        }
    }

    private static boolean isContinue(String input) {
        return input.equals(String.valueOf(Baseball.CONTINUE_VALUE));
    }

    private static boolean isExit(String input) {
        return input.equals(String.valueOf(Baseball.EXIT_VALUE));
    }
}
