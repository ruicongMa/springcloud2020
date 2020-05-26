package com.mark.inerpreter.eg;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Mark
 * @date 2020/5/25 17:59
 */
public class Test3 {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("100 * 2 + 400 * 1 + 66");
        int result = (int) expression.getValue();
        System.out.println("计算结果是：" + result);
    }
}
