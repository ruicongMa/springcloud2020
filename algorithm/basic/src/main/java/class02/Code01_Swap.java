package class02;

/**
 * @author Mark
 * @date 2022/2/13 17:56
 */
public class Code01_Swap {

    // 如何不用额外变量交换两个数

    // 异或运算交换律和结合律
    public static void main(String[] args) {


        int a = 16;
        int b = 603;

        System.out.println(a);
        System.out.println(b);


        a = a ^ b;
        b = a ^ b;
        a = a ^ b;


        System.out.println(a);
        System.out.println(b);


        int[] arr = {3, 1, 100};

        int i = 0;
        int j = 0;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

        System.out.println(arr[i] + " , " + arr[j]);


        System.out.println(arr[0]);
        System.out.println(arr[2]);

        swap(arr, 0, 0);

        System.out.println(arr[0]);
        System.out.println(arr[2]);


    }

    public static void swap(int[] arr, int i, int j) {
        // arr[0] = arr[0] ^ arr[0];
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
