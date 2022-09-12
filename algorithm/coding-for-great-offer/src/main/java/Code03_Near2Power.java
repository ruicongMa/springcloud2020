/**
 * @author Mark
 * @date 2021/9/15 18:08
 */
public class Code03_Near2Power {

    /**
     * 给定一个非负整数num，
     * 如何不用循环语句，
     * 返回>=num，并且离num最近的，2的某次方
     */

    // 11
    // 1011
    // 0101
    // 1111
    public static final int tableSizeFor(int n) {
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void main(String[] args) {
        int cap = 120;
        System.out.println(tableSizeFor(cap));
    }
}
