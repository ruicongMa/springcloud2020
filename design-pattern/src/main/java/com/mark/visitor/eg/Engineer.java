package com.mark.visitor.eg;

import java.util.Random;

/**
 * @author Mark
 * @date 2020/5/27 15:23
 */

/**
 * 工程师
 */
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //工程师一年的代码量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
