import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mark
 * @date 2022/8/7 17:12
 */
@Slf4j
public class ConditionTest {

    public synchronized void a() {
        new Thread(() -> {
            a();
        }).start();
    }

    public static void main(String[] args) {

        ConditionTest conditionTest = new ConditionTest();
        conditionTest.a();

        // Lock lock = new ReentrantLock();
        // Condition condition = lock.newCondition();
        //
        // new Thread(() -> {
        //     lock.lock();
        //     try {
        //         log.debug(Thread.currentThread().getName() + " 开始处理任务1");
        //         condition.await();
        //         log.debug(Thread.currentThread().getName() + " 结束处理任务1");
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     } finally {
        //         lock.unlock();
        //     }
        // }).start();
        //
        // new Thread(() -> {
        //     lock.lock();
        //     try {
        //         log.debug(Thread.currentThread().getName() + " 开始处理任务2");
        //         Thread.sleep(2000);
        //         condition.signal();
        //         log.debug(Thread.currentThread().getName() + " 结束处理任务2");
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     } finally {
        //         lock.unlock();
        //     }
        // }).start();
    }
}
