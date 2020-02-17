package baseball.domain;

public class Game {
    public static void main(String[] args) {
        String userInput = InputView.getInput();
        Baseball game = new Baseball();
        game.setInput(userInput);
        while (game.start()) {
            game.setInput(InputView.getInput());
        }
        System.out.println("게임이 종료되었습니다.");
    }
}
