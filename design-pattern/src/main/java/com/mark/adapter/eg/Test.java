package com.mark.adapter.eg;

/**
 * @author Mark
 * @date 2020/5/10 15:56
 */
public class Test {
    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        adapter.login("mark", "123456");
        adapter.loginForQQ("8888888888888");
        adapter.loginForWeChat("qwertyuiop");

    }
}
