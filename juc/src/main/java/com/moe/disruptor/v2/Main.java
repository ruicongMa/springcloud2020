package com.moe.disruptor.v2;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.moe.disruptor.v1.LongEvent;
import com.moe.disruptor.v1.LongEventFactory;
import com.moe.disruptor.v1.LongEventHandler;

import java.util.concurrent.Executors;

/**
 * @author Mark
 * @date 2022/5/17 21:04
 */
public class Main {

    public static void main(String[] args) {
        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer，must be power of 2
        int ringBufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, ringBufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handle
        disruptor.handleEventsWith(new LongEventHandler());

        // Start the Disruptor，starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        EventTranslator<LongEvent> translator1 = new EventTranslator<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence) {
                event.setValue(8888);
            }
        };
        ringBuffer.publishEvent(translator1);

        EventTranslatorOneArg<LongEvent, Long> translator2 = new EventTranslatorOneArg<LongEvent, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0) {
                event.setValue(arg0);
            }
        };
        ringBuffer.publishEvent(translator2, 7777L);

        EventTranslatorTwoArg<LongEvent, Long, Long> translator3 = new EventTranslatorTwoArg<LongEvent, Long, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long arg0, Long arg1) {
                event.setValue(arg0 + arg1);
            }
        };
        ringBuffer.publishEvent(translator3, 1000L, 1000L);

        EventTranslatorVararg<LongEvent> translatorVararg = new EventTranslatorVararg<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Object... args) {
                long result = 0;
                for (Object arg : args) {
                    long l = (Long) arg;
                    result += l;
                }
                event.setValue(result);
            }
        };
        ringBuffer.publishEvent(translatorVararg, 10000L, 10000L, 10000L, 10000L, 10000L, 10000L);
    }
}
