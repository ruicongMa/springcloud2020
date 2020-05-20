package com.mark.chain.uml;

/**
 * @author Mark
 * @date 2020/5/19 19:08
 */
public abstract class Handler {

    private Handler nextHandler;

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleRequest();

}
