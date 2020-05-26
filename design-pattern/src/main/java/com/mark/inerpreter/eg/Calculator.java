package com.mark.inerpreter.eg;

import java.util.Stack;

/**
 * @author Mark
 * @date 2020/5/25 17:34
 */
public class Calculator {

    private Stack<IArithmeticlnterpreter> stack = new Stack<>();

    public Calculator(String expression) {
        this.parse(expression);
    }

    private void parse(String expression) {
        String[] elements = expression.split(" ");
        IArithmeticlnterpreter left, right;

        for (int i = 0; i < elements.length; i++) {
            String operator = elements[i];
            if (OperatorUtil.isOperator(operator)) {
                left = this.stack.pop();
                right = new NumberInterpreter(Integer.valueOf(elements[++i]));
                System.out.println("出栈" + left.interpret() + "和" + right.interpret());
                this.stack.push(OperatorUtil.getInterpreter(left, right, operator));
                System.out.println("应用运算符：" + operator);
            } else {
                NumberInterpreter numberInterpreter = new NumberInterpreter(Integer.valueOf(elements[i]));
                this.stack.push(numberInterpreter);
                System.out.println("入栈：" + numberInterpreter.interpret());
            }
        }
    }

    public int calculate() {
        return this.stack.pop().interpret();
    }
}
