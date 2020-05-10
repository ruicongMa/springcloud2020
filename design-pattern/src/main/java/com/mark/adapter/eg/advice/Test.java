package com.mark.adapter.eg.advice;

import com.mark.adapter.eg.IPassportForThird;

/**
 * @author Mark
 * @date 2020/5/10 16:47
 */
public class Test {

    public static void main(String[] args) {
        IPassportForThird adpter = new PassportForThirdAdapter();
        adpter.loginForQQ("888888");
    }
}
