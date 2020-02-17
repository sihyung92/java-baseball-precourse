package baseball.domain;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getPlayerInput() {
        Validator validator = new Validator();

        String message = "서로 다른 수로 이루어진 3자리의 수를 입력해주세요.";
        System.out.println(message);
        String input = scanner.nextLine();

        while (!validator.baseBallPlayerInputValidate(input)){
            validator.printWrongMessage();
            System.out.println(message);
            input = scanner.nextLine();
        }

        return input;
    }

    public static String getSelectedMenu() {
        Validator validator = new Validator();

        String message = "게임을 새로 시작하려면 " + Baseball.CONTINUE_VALUE + ", 종료하려면 " + Baseball.EXIT_VALUE + "를 입력하세요.";
        System.out.println(message);
        String input = scanner.nextLine();

        while (!validator.baseBallSelectedMenuValidate(input)){
            validator.printWrongMessage();
            System.out.println(message);
            input = scanner.nextLine();
        }

        return input;
    }
}
