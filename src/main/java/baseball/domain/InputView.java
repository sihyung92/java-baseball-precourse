package baseball.domain;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String wrongMessage = "";

    public static String getPlayerInput() {
        String message = "서로 다른 수로 이루어진 3자리의 수를 입력해주세요.";
        System.out.println(message);
        String input = scanner.nextLine();

        while (!baseBallPlayerInputValidate(input)){
            printWrongMessage();
            System.out.println(message);
            input = scanner.nextLine();
        }

        return input;
    }

    public static String getSelectedMenu() {
        String message = "게임을 새로 시작하려면 " + Baseball.CONTINUE_VALUE + ", 종료하려면 " + Baseball.EXIT_VALUE + "를 입력하세요.";
        System.out.println(message);
        String input = scanner.nextLine();

        while (!baseBallSelectedMenuValidate(input)){
            printWrongMessage();
            System.out.println(message);
            input = scanner.nextLine();
        }

        return input;
    }

    private static boolean baseBallPlayerInputValidate(String input) {
        if (isDigit(input) && validStringLength(input, Baseball.DIGIT) && validOverlapAtOtherDigit(input)) {
            return true;
        }
        return false;
    }

    private static boolean baseBallSelectedMenuValidate(String input) {
        if (isDigit(input) && validStringLength(input, Baseball.MENU_DIGIT) && validMenuNumber(input)) {
            return true;
        }
        return false;
    }

    private static boolean validStringLength(String input, int length) {
        if (input.length() != length) {
            wrongMessage = "문자 길이가 올바르지 않습니다. 문자 길이는 " + length + "글자입니다.";
            return false;
        }
        return true;

    }

    private static boolean isDigit(String input) {
        for(char c : input.toCharArray())
            if(!Character.isDigit(c)){
                wrongMessage = "숫자만 입력해주세요.";
                return false;
            }
        return true;
    }

    private static boolean validOverlapAtOtherDigit(String input) {
        Set<Character> forCheckOverlap = new HashSet<>();
        for (char c : input.toCharArray()){
            if (!forCheckOverlap.add(c)) {
                wrongMessage = "서로 다른 수를 입력해주세요.";
                return false;
            }
        }
        return true;
    }

    private static boolean validMenuNumber(String input) {
        int selectedNum = Integer.valueOf(input);
        if (Baseball.CONTINUE_VALUE == selectedNum || Baseball.EXIT_VALUE == selectedNum) {
            return true;
        }
        wrongMessage = "올바른 메뉴 번호를 입력해주세요. 계속 -> " + Baseball.CONTINUE_VALUE + " 중단 ->" + Baseball.EXIT_VALUE;
        return false;
    }

    private static void printWrongMessage() {
        System.out.println(wrongMessage.toString());
    }
}
