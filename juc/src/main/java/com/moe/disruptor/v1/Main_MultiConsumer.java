package com.moe.disruptor.v1;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/**
 * @author Mark
 * @date 2022/5/17 22:31
 */
public class Main_MultiConsumer {

    public static void main(String[] args) throws InterruptedException {
        LongEventFactory factory = new LongEventFactory();

        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory(),
                ProducerType.MULTI, new BlockingWaitStrategy());

        // Connect the handler
        LongEventHandler h1 = new LongEventHandler();
        LongEventHandler h2 = new LongEventHandler();
        disruptor.handleEventsWith(h1, h2);

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        final int threadCount = 10;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (long i = 0; i < threadCount; i++) {
            final long threadNum = i;
            executorService.submit(() -> {
                System.out.printf("Thread %s ready to start! \n", threadNum);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {
                    ringBuffer.publishEvent((event, sequence) -> {
                        event.setValue(threadNum);
                        System.out.println("生产了 " + threadNum);
                    });
                }
            });
        }
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(6);
        System.out.println(LongEventHandler.count);
    }
}
