package com.mark.command.uml;

/**
 * @author Mark
 * @date 2020/5/21 9:26
 */
public class Invoker {

    private ICommand iCommand;

    public void action() {
        iCommand.execute();
    }
}
