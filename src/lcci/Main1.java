package lcci;

/**
 * Description:
 * <p>
 * date: 2024/3/7 09:32
 *
 * @author wushuang
 * @since JDK 1.8
 */
public class Main1 {
    public static boolean isUnique(String str) {
        boolean[] existArray = new boolean[26];
        char[] charArray = str.toLowerCase().toCharArray();
        for (char c : charArray) {
            if (c - 'a' > 26 || c - 'a' < 0) {
                return false;
            }

            if (existArray[c - 'a']) {
                return false;
            }
            existArray[c - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcde3333";
        boolean unique = Main1.isUnique(str);
        System.out.printf("String [%s] is " + (unique ? "unique" : "not unique"), str);
    }
}