package com.mark.delegate.eg;

/**
 * @author Mark
 * @date 2020/5/12 11:01
 */
public class EmployeeB implements IEmployee {

    protected String goodAt = "平面设计";

    @Override
    public void doing(String task) {
        System.out.println("我是员工B，我擅长" + goodAt + "，现在开始做" + task + "工作");
    }
}
