package ctci.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
 * other.
 * <p>
 * date: 2024/5/31 14:29
 *
 * @author wushuang
 * @since JDK 1.8
 */
public class Question2CheckPermutation {

    public static boolean isPermutation(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c1 : chars1) {
            Integer count = charCount.getOrDefault(c1, 0);
            count += 1;
            charCount.put(c1, count);
        }

        for (char c2 : chars2) {
            if (charCount.containsKey(c2)) {
                Integer count = charCount.get(c2);
                if (count == 0) {
                    return false;
                }
                count -= 1;
                charCount.put(c2, count);
            } else {
                return false;
            }
        }
        return charCount.values().stream().collect(Collectors.summarizingInt(c -> c)).getSum() == 0;
    }

    public static boolean isPermutation2(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "111";
        String str2 = "111";
        System.out.printf("Is %s and %s permutation: %s\n", str1, str2, isPermutation(str1, str2));
        System.out.printf("Is %s and %s permutation: %s\n", str1, str2, isPermutation2(str1, str2));
    }
}
