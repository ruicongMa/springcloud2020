package com.mark.command.eg;

/**
 * @author Mark
 * @date 2020/5/21 11:04
 */
public class Test {

    public static void main(String[] args) {
        Player player = new Player();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));

        controller.executes();
    }
}
