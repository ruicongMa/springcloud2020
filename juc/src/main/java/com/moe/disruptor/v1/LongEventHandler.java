package com.moe.disruptor.v1;

import com.lmax.disruptor.EventHandler;

/**
 * @author Mark
 * @date 2022/5/17 21:02
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    static long count = 0;

    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + ", value=>" + longEvent.getValue() + ", l=>" + l + ", b=>" + b);
        count++;
    }
}
