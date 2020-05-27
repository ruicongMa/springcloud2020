package com.mark.visitor.eg;

/**
 * @author Mark
 * @date 2020/5/27 15:58
 */
public class Test {

    public static void main(String[] args) {
        //构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("==============CEO看报表===============");
        report.showReport(new CEOVisitor());
        System.out.println("==============CTO看报表===============");
        report.showReport(new CTOVisitor());
    }
}
