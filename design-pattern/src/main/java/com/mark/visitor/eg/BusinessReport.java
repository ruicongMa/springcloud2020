package com.mark.visitor.eg;

/**
 * @author Mark
 * @date 2020/5/27 15:32
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 员工业务报表类
 */
public class BusinessReport {

    private List<Employee> employees = new LinkedList<>();

    public BusinessReport() {
        employees.add(new Manager("经理-A"));
        employees.add(new Engineer("工程师-A"));
        employees.add(new Engineer("工程师-B"));
        employees.add(new Engineer("工程师-C"));
        employees.add(new Manager("经理-B"));
        employees.add(new Engineer("工程师-D"));
    }

    /**
     * 为访问者展示报表
     *
     * @param visitor 公司高层、如CTO、CEO
     */
    public void showReport(IVisitor visitor) {
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
