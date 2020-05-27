package com.mark.visitor.eg;

/**
 * @author Mark
 * @date 2020/5/27 15:54
 */
public class CTOVisitor implements IVisitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师" + engineer.name + "，KPI：" + engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + "，产品数量：" + manager.getProducts());
    }
}
