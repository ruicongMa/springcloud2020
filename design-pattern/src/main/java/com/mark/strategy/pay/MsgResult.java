package com.mark.strategy.pay;

import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/14 11:45
 */

/**
 * 支付完成后的状态
 */
@Data
public class MsgResult {

    private int code;
    private Object data;
    private String msg;

    public MsgResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

}
