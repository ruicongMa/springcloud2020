package com.mark.command.uml;

/**
 * @author Mark
 * @date 2020/5/21 8:27
 */
public class Receiver {

    private ICommand iCommand;

    public void action() {
        iCommand.execute();
    }
}
