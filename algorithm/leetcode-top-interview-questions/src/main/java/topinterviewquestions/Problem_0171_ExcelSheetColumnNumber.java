package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/26 20:28
 */
public class Problem_0171_ExcelSheetColumnNumber {

    // 这道题反过来也要会写 Problem_0168_ExcelSheetColumnTitle
    // Excel 表列序号：https://leetcode.com/problems/excel-sheet-column-number/
    public static int titleToNumber(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            ans = ans * 26 + (str[i] - 'A') + 1;
        }
        return ans;
    }

}
