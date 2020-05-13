package com.mark.template.eg;

/**
 * @author Mark
 * @date 2020/5/13 10:37
 */
public class JavaCourse extends AbstractCourse {

    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查Java作业");
    }
}
