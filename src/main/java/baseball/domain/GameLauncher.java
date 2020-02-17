package baseball.domain;

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {

        while (true) {
            startGame();
            String input = InputView.getInput("게임을 새로 시작하려면 " + Baseball.CONTINUE_VALUE + ", 종료하려면 " + Baseball.EXIT_VALUE + "를 입력하세요.");
            if (input.equals(String.valueOf(Baseball.CONTINUE_VALUE)))
                continue;
            if (input.equals(String.valueOf(Baseball.EXIT_VALUE)))
                break;
        }
        System.out.println("게임이 종료되었습니다.");
    }

    public static void startGame(){
        Baseball game = new Baseball();

        while (true) {
            game.setInput(InputView.getInput("서로 다른 수로 이루어진 3자리의 수를 입력해주세요."));
            game.createResult();
            System.out.println(game.getResultMessage());

            if(game.getStrike() == game.DIGIT_NUMBER) {
                System.out.println(game.DIGIT_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
