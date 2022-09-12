import java.math.BigInteger;

/**
 * @author Mark
 * @date 2022/2/17 19:27
 */
public class MyTest {

    public static void main(String[] args) {
        int[] arr = new int[1];
        BigInteger num = new BigInteger("4294967295");
        System.out.println(num);
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.parseUnsignedInt("4294967295"));
    }

}
