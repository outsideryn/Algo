package lcci;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 * <p>
 * date: 2024/3/7 09:32
 *
 * @author wushuang
 * @since JDK 1.8
 */
public class Main2 {
    public static boolean isPermutation(String str1, String str2) {
        Map<Character, Integer> counterMap = new HashMap<>();
        for (char c : str1.toLowerCase().toCharArray()) {
            Integer counter = counterMap.getOrDefault(c, 0);
            counter++;
            counterMap.put(c, counter);
        }

        for (char c : str2.toLowerCase().toCharArray()) {
            if (!counterMap.containsKey(c)) {
                return false;
            }
            Integer counter = counterMap.get(c);
            counter--;
            if (counter < 0) {
                return false;
            }
            counterMap.put(c, counter);
        }
        IntSummaryStatistics collect = counterMap.values().stream().collect(Collectors.summarizingInt(i -> i));
        return collect.getSum() == 0;
    }

    public static void main(String[] args) {
        String str1 = "abc33333de33331";
        String str2 = "33abc333de33331";
        boolean permutation = Main2.isPermutation(str1, str2);
        System.out.printf("String [%s] and [%s] is " + (permutation ? "permutation" : "not permutation"), str1, str2);
    }
}