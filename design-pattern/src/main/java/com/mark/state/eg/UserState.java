package com.mark.state.eg;

/**
 * @author Mark
 * @date 2020/5/22 11:12
 */
public abstract class UserState {

    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);
}
