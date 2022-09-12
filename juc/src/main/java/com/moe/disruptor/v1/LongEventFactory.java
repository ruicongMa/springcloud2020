package com.moe.disruptor.v1;

import com.lmax.disruptor.EventFactory;

/**
 * @author Mark
 * @date 2022/5/17 21:02
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }
}
