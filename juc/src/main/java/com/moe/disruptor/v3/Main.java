package com.moe.disruptor.v3;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.moe.disruptor.v1.LongEvent;

/**
 * @author Mark
 * @date 2022/5/17 21:48
 */
public class Main {

    public static void main(String[] args) {
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handler
        disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println(event.getValue()));

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ringBuffer.publishEvent((event, sequence, arg0) -> event.setValue(arg0), 1000L);

    }
}
