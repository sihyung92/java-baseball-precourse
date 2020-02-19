package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> baseballNumber;

    BaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    BaseballNumber(String baseballNumberString) {
        this(makeList(baseballNumberString));
    }

    private static List<Integer> makeList(String input) {
        char[] chars = input.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char i : chars) {
            list.add(i - '0'); // 숫자 character를 int 값으로 변환
        }
        return list;
    }

    public int get(int index) {
        return baseballNumber.get(index);
    }

    public boolean contains(Object o) {
        return baseballNumber.contains(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : baseballNumber) {
            sb.append(i);
        }
        return sb.toString();
    }
}
