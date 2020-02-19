package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private StringBuilder wrongMessage = new StringBuilder();

    public boolean playerInputValidate(String input) {
        if (input != null && validStringLength(input, Baseball.DIGIT) && isDigit(input) && validOverlapAtOtherDigit(input)) {
            return true;
        }
        return false;
    }

    public boolean selectedMenuValidate(String input) {
        if (input != null && validStringLength(input, Baseball.MENU_DIGIT) && isDigit(input) && validMenuNumber(input)) {
            return true;
        }
        return false;
    }

    public boolean validStringLength(String input, int length) {
        if (input.length() != length) {
            wrongMessage.append("문자 길이가 올바르지 않습니다. 문자 길이는 " + length + "글자입니다.");
            return false;
        }
        return true;

    }

    public boolean isDigit(String input) {
        for (char c : input.toCharArray())
            if (!Character.isDigit(c)) {
                wrongMessage.append("숫자만 입력해주세요.");
                return false;
            }
        return true;
    }

    public boolean validOverlapAtOtherDigit(String input) {
        Set<Character> forCheckOverlap = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!forCheckOverlap.add(c)) {
                wrongMessage.append("서로 다른 수를 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    public boolean validMenuNumber(String input) {
        int selectedNum = Integer.valueOf(input);
        if (GameLauncher.CONTINUE_VALUE == selectedNum || GameLauncher.EXIT_VALUE == selectedNum) {
            return true;
        }
        wrongMessage.append("올바른 메뉴 번호를 입력해주세요. 계속 -> " + GameLauncher.CONTINUE_VALUE + " 중단 ->" + GameLauncher.EXIT_VALUE);
        return false;
    }

    public String getWrongMessage() {
        return wrongMessage.toString();
    }

}
