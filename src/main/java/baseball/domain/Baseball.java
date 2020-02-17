package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
    /*
     * 각 자리별로 쪼개서 list에 담음
     * 각자리 별로 비교해서 같으면 strike를 ++하고 해당 자리를 0으로 바꿈
     * strike가 3이면 isCollect 를 true로 바꾸고 return
     * 다른 자리에서 같은게 있으면 ball을 ++ 하고
     * strike=0, ball=0이면 isNothing을 true로 바꾸고 return
     * */

    // 자릿수
    static final int DIGIT_NUMBER = 3;

    List<Integer> listedInput;
    List<Integer> answer;
    boolean isCollect;
    boolean isNothing;
    int strike;
    int ball;

    Baseball() {
        makeRandomDigit();
        strike = 0;
        ball = 0;
        isCollect = false;
        isNothing = false;
    }

    private void makeRandomDigit() {
        answer = new ArrayList<>();
        Random random = new Random();
        while (answer.size() != DIGIT_NUMBER) {
            int x = random.nextInt(8) + 1;
            if (answer.contains(x)) {
                continue;
            }
            answer.add(x);
        }
    }

    public boolean start() {
        for (int i = 0; i < answer.size(); i++) {
            if (listedInput.get(i) == answer.get(i)) {
                strike++;
            }
            if (strike == DIGIT_NUMBER) {
                resultPrint();
                return false;
            }
        }

        for (int i = 0 ; i < answer.size(); i++) {
            for (int j = 0; j < answer.size(); j++) {
                if (i == j)
                    continue;
                if (listedInput.get(i) == answer.get(j))
                    ball++;
            }
        }

        resultPrint();
        clean();
        return true;
    }

    private void resultPrint() {
        if (strike == 0 && ball == 0)
            System.out.println("낫씽");
        if (strike > 0)
            System.out.print(strike + "스트라이크 ");
        if (ball > 0)
            System.out.print(ball + "볼 ");
        System.out.println();

        if (strike == DIGIT_NUMBER) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private void clean() {
        strike = 0;
        ball = 0;
        isCollect = false;
        isNothing = false;
    }

    public void setInput(String input) {
        listedInput = stringToList(input);
    }

    private List<Integer> stringToList(String input) {
        char[] chars = input.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char i : chars) {
            list.add(i - '0'); // 숫자 character를 int 값으로 변환
        }
        return list;
    }
}
