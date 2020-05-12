package com.mark.delegate.eg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @date 2020/5/12 11:06
 */
public class Leader implements IEmployee {

    private Map<String, IEmployee> employeeMap = new HashMap<>();

    public Leader() {
        employeeMap.put("爬虫", new EmployeeA());
        employeeMap.put("插画", new EmployeeB());
    }

    @Override
    public void doing(String task) {
        if (!employeeMap.containsKey(task)) {
            System.out.println("这个任务" + task + "超出我的能力范围");
            return;
        }
        employeeMap.get(task).doing(task);
    }
}
