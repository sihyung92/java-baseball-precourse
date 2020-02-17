package baseball.domain;

public class GameLauncher {
    public static void main(String[] args) {

        while (true) {
            startGame();
            break;
        }
        System.out.println("게임이 종료되었습니다.");
    }

    public static void startGame(){
        Baseball game = new Baseball();

        while (true) {
            game.setInput(InputView.getInput());
            game.createResult();
            System.out.println(game.getResultMessage());

            if(game.getStrike() == game.DIGIT_NUMBER) {
                System.out.println(game.DIGIT_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
