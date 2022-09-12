package topinterviewquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/3/26 17:14
 */
public class Problem_0166_FractionToRecurringDecimal {

    // 分数到小数：https://leetcode.com/problems/fraction-to-recurring-decimal/
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-" 异或：true^true=false，true^false=true
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length()); // 记录余数及余数的位置
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length()); // 记录余数及余数的位置
            }
        }
        return res.toString();
    }
}
