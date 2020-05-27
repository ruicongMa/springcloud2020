package com.mark.visitor.eg;

/**
 * @author Mark
 * @date 2020/5/27 15:20
 */
public interface IVisitor {

    //访问工程师类型
    void visit(Engineer engineer);

    //访问经理类型
    void visit(Manager manager);
}
