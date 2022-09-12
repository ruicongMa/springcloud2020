package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/26 20:28
 */
public class Problem_0168_ExcelSheetColumnTitle {

    // Excel表列名称：https://leetcode.com/problems/excel-sheet-column-title/
    public static String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }
}
