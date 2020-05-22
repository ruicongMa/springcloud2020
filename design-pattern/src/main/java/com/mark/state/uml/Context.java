package com.mark.state.uml;

/**
 * @author Mark
 * @date 2020/5/22 10:59
 */
public class Context {

    private IState iState;

    public void setState(IState iState) {
        this.iState = iState;
    }

    public void handle() {
        iState.handle();
    }
}
