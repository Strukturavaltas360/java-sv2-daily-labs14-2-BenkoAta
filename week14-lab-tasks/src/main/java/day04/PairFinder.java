package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {

    int findPairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer count = map.get(i);
            map.put(i, count != null ? count + 1 : 1);
        }
        return map.values().stream()
                .mapToInt(value -> value / 2)
                .sum();
    }
}
