package com.moe.disruptor.v1;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

/**
 * @author Mark
 * @date 2022/5/17 21:04
 */
public class Main {

    public static void main(String[] args) {
        //Executor executor = Executors.newCachedThreadPool();
        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer，must be power of 2
        int ringBufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, ringBufferSize, Executors.defaultThreadFactory());

        // Connect the handle
        disruptor.handleEventsWith(new LongEventHandler());

        // Start the Disruptor，starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        // 官方教程
        long sequence = ringBuffer.next(); // Grab the next sequence
        try {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            event.setValue(8888); // Fill with data
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
