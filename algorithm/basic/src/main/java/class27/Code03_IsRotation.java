package class27;

/**
 * @author Mark
 * @date 2022/3/1 18:54
 */
public class Code03_IsRotation {

    // 是否是旋转串
    // 123456，以1开始，它的旋转串是234561
    // 123456，以12开始，它的旋转串是345612
    // 123456，以123开始，它的旋转串是456123
    // ...
    // 123456，以123456开始，它的旋转串是它自己

    // 两个串先拼接在一起，然后看另外一个串是否是这个串的子串
    public static boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        String b2 = b + b;
        return getIndexOf(b2, a) != -1;
    }

    // KMP Algorithm
    public static int getIndexOf(String s, String m) {
        if (s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "yunzuocheng";
        String str2 = "zuochengyun";
        System.out.println(isRotation(str1, str2));
    }
}
