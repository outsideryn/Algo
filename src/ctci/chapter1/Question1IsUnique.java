package ctci.chapter1;

/**
 * Description:
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * <p>
 * date: 2024/5/31 13:33
 *
 * @author wushuang
 * @since JDK 1.8
 */
public class Question1IsUnique {

    public static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUniqueWithAssumption(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] existChars = new boolean[128];
        for (char aChar : str.toCharArray()) {
            if (existChars[aChar]) {
                return false;
            }
            existChars[aChar] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String uniqueStr = "abcdefj1234,";
        String str = "aabcdefj2223";
        System.out.printf("Is '%s' unique: %s\n", uniqueStr, Question1IsUnique.isUnique(uniqueStr));
        System.out.printf("Is '%s' unique: %s\n", str, Question1IsUnique.isUnique(str));

        String uniqueStrWithAssumption = "abcdefj1234";
        String strWithAssumption = "aabcdefj2223";
        System.out.printf("Is '%s' unique: %s\n", uniqueStrWithAssumption, Question1IsUnique.isUniqueWithAssumption(uniqueStrWithAssumption));
        System.out.printf("Is '%s' unique: %s\n", strWithAssumption, Question1IsUnique.isUniqueWithAssumption(strWithAssumption));
    }
}
