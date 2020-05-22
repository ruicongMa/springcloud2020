package com.mark.command.eg;

/**
 * @author Mark
 * @date 2020/5/21 10:59
 */
public class StopAction implements IAction {

    private Player player;

    public StopAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.stop();
    }
}
