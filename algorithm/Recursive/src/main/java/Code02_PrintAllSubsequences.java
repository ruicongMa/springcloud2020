import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mark
 * @date 2021/8/26 11:46
 */
public class Code02_PrintAllSubsequences {

    /**
     * 打印一个字符串的全部子序列
     */
    public static List<String> subs(String str) {
        char[] chars = str.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(chars, 0, ans, path);
        return ans;
    }

    public static void process1(char[] chars, int index, List<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        process1(chars, index + 1, ans, path);
        process1(chars, index + 1, ans, path + chars[index]);
    }

    public static void main(String[] args) {
        List<String> ans = subs("abc");
        System.out.println(ans);
        ans = ans.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(ans);
    }
}
