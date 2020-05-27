package com.mark.visitor.eg;

import java.util.Random;

/**
 * @author Mark
 * @date 2020/5/27 15:18
 */
//员工基类
public abstract class Employee {

    public String name;
    public int kpi;//员工KPI

    public Employee(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    //核心方法，接受访问者的访问
    public abstract void accept(IVisitor visitor);
}
