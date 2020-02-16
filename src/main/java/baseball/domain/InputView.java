package baseball.domain;

import java.util.Scanner;

public class InputView {
    public static int getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("서로 다른 수로 이루어진 3자리의 수를 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
