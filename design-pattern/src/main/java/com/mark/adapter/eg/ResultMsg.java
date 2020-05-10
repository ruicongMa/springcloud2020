package com.mark.adapter.eg;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/10 15:39
 */
@Data
@AllArgsConstructor
public class ResultMsg {

    private int code;
    private String msg;
    private Object data;

}
