package class02;

/**
 * @author Mark
 * @date 2022/4/8 9:29
 */
public class Code06_PrintUniquePairAndTriad {

    // 二元组和三元组问题

    /**
     * 给定一个有序数组arr，给定一个正数aim
     * 1）返回累加和为aim的所有不同二元组
     * 2）返回累加和为aim的所有不同三元组
     */
    // 二元组
    public static void printUniquePair(int[] arr, int aim) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L < R) {
            if (arr[L] + arr[R] < aim) {
                L++;
            } else if (arr[L] + arr[R] > aim) {
                R--;
            } else { // L + R = aim
                if (L == 0 || arr[L - 1] != arr[L]) {
                    System.out.println(arr[L] + "," + arr[R]);
                }
                L++;
                R--;
            }
        }
    }

    // 三元组
    public static void printUniqueTriad(int[] arr, int aim) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                printRest(arr, i, i + 1, arr.length - 1, aim - arr[i]);
            }
        }
    }

    public static void printRest(int[] arr, int f, int L, int R, int aim) {
        while (L < R) {
            if (arr[L] + arr[R] < aim) {
                L++;
            } else if (arr[L] + arr[R] > aim) {
                R--;
            } else {
                if (L == f + 1 || arr[L - 1] != arr[L]) {
                    System.out.println(arr[f] + "," + arr[L] + "," + arr[R]);
                }
                L++;
                R--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int sum = 10;
        int[] arr1 = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        printArray(arr1);
        System.out.println("====");
        printUniquePair(arr1, sum);
        System.out.println("====");
        printUniqueTriad(arr1, sum);

    }
}
