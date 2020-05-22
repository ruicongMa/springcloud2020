package com.mark.command.eg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2020/5/21 11:01
 */
public class Controller {

    private List<IAction> actions = new ArrayList<>();

    public void addAction(IAction action) {
        actions.add(action);
    }

    public void execute(IAction action) {
        action.execute();
    }

    public void executes() {
        for (IAction action : actions) {
            action.execute();
        }
        actions.clear();
    }
}
