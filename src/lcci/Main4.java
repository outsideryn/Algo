package lcci;

import java.util.HashMap;
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
public class Main4 {

    public static boolean isPalindrome(String str) {
        Map<Character, Integer> counterMap = new HashMap<>();
        for (char c : str.toLowerCase().toCharArray()) {
            Integer counter = counterMap.getOrDefault(c, 0);
            counter++;
            counterMap.put(c, counter);
        }

        if (str.length() % 2 == 0) {
            Integer integer = counterMap.values().stream().filter(i -> i != 2).findAny().orElse(0);
            return integer == 0;
        } else {
            int integer = counterMap.values().stream().filter(i -> i != 2).filter(integer1 -> integer1 == 1).collect(Collectors.toSet()).size();
            return integer == 1;
        }
    }

    public static void main(String[] args) {
//        String str1 = "tactcoa";
        String str1 = "tactc34a";
        boolean palindrome = Main4.isPalindrome(str1);
        System.out.printf("String [%s] is " + (palindrome ? "palindrome" : "not palindrome"), str1);
    }
}