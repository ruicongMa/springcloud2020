package com.mark.delegate.eg;

/**
 * @author Mark
 * @date 2020/5/12 11:27
 */
public class Test {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Leader leader = new Leader();
        boss.command("爬虫", leader);
        boss.command("插画", leader);
        boss.command("撩妹", leader);
    }
}
