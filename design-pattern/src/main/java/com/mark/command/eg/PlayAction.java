package com.mark.command.eg;

/**
 * @author Mark
 * @date 2020/5/21 10:54
 */
public class PlayAction implements IAction {

    private Player player;

    public PlayAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
