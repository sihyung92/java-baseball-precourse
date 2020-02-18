package baseball.domain;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getPlayerInput() {
        Validator validator = new Validator();

        String message = "서로 다른 수로 이루어진 3자리의 수를 입력해주세요.";
        String input = printMessageAndGetInput(message);

        while (!validator.playerInputValidate(input)) {
            System.out.println(validator.getWrongMessage());
            input = printMessageAndGetInput(message);
        }

        return input;
    }

    public static String getSelectedMenu() {
        Validator validator = new Validator();

        String message = "게임을 새로 시작하려면 " + Baseball.CONTINUE_VALUE + ", 종료하려면 " + Baseball.EXIT_VALUE + "를 입력하세요.";
        String input = printMessageAndGetInput(message);

        while (!validator.selectedMenuValidate(input)) {
            System.out.println(validator.getWrongMessage());
            input = printMessageAndGetInput(message);
        }

        return input;
    }

    private static String printMessageAndGetInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void close() {
        scanner.close();
    }
}
