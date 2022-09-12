import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2021/10/26 20:43
 */
public class TestSubsequence {

    public static List<String> getSubsequence(String str) {
        List<String> subs = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return subs;
        }
        process(str.toCharArray(), 0, "", subs);
        return subs;
    }

    private static void process(char[] str, int index, String path, List<String> subs) {
        if (index == str.length) {
            subs.add(path);
            return;
        }
        process(str, index + 1, path, subs);
        process(str, index + 1, path + str[index], subs);
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> subsequence = getSubsequence(str);
        for (String sub : subsequence) {
            System.out.println(sub);
        }
    }
}
