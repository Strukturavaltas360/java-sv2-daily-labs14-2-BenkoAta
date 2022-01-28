package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetService {
    public Map<String, List<Integer>> readFromFile(Path path) {
        Map<String, List<Integer>> result = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(path);
            lines.stream()
                    .forEach(s -> addToMap(result, s));
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file!", e);
        }
        return result;
    }

    private void addToMap(Map<String, List<Integer>> result, String s) {
        String[] parts = s.split(" ");
        String street = parts[0];
        int number = Integer.parseInt(parts[1]);
        List<Integer> numberList = result.get(street);
        if (numberList == null) {
            numberList = new ArrayList<>();
            result.put(street, numberList);
        }
        int max = numberList.stream()
                .filter(i -> i % 2 == number)
                .sorted(Comparator.reverseOrder())
                .findFirst().orElse(number == 0 ? 0 : -1);
        numberList.add(max + 2);
    }
}
