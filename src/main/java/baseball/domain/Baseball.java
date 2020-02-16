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
    List<Integer> answer = new ArrayList<>();
    boolean isCollect;
    boolean isNothing;
    int strike;
    int ball;

    Baseball(){
        strike = 0;
        ball = 0;
        isCollect = false;
        isNothing = false;
    }

    public void init(){
        Random random = new Random();
        while(answer.size()!=3){
            int x = random.nextInt(8)+1;
            if(answer.contains(x)){
                continue;
            }
            answer.add(x);
        }
    }

}
