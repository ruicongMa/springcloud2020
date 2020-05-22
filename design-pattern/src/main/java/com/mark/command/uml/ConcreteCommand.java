package com.mark.command.uml;

/**
 * @author Mark
 * @date 2020/5/21 9:27
 */
public class ConcreteCommand implements ICommand {

    private Receiver receiver;

    @Override
    public void execute() {
        receiver.action();
    }
}
