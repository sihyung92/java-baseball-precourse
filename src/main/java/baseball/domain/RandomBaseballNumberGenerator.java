package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBaseballNumberGenerator {
    
    public static BaseballNumber makeRandomBaseballNumber(int digit) {
        List<Integer> answer = new ArrayList<>();
        Random random = new Random();
        while (answer.size() != digit) {
            int x = random.nextInt(8) + 1;
            if (answer.contains(x)) {
                continue;
            }
            answer.add(x);
        }
        return new BaseballNumber(answer);
    }
}
