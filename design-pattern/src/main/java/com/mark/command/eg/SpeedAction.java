package com.mark.command.eg;

/**
 * @author Mark
 * @date 2020/5/21 10:59
 */
public class SpeedAction implements IAction {

    private Player player;

    public SpeedAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.speed();
    }
}
