package com.mark.visitor.eg;

import java.util.Random;

/**
 * @author Mark
 * @date 2020/5/27 15:25
 */

/**
 * 经理
 */
public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //一年的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
