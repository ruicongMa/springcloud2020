import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2021/9/17 10:14
 */
public class SyncTest {

    Object o = new Object();

    // public synchronized void push() {
    //     synchronized (this) {
    //         System.out.println("push...");
    //         // notify();
    //     }
    //     System.out.println("push over...");
    //     notify();
    // }
    //
    // public synchronized void pop() {
    //     synchronized (this) {
    //         try {
    //             System.out.println("pop start");
    //             wait();
    //             System.out.println("pop ing...");
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     System.out.println("pop over...");
    // }
    //
    // public static void main(String[] args) throws InterruptedException {
    //     SyncTest syncTest = new SyncTest();
    //
    //     Thread t1 = new Thread(()->{
    //         syncTest.pop();
    //     });
    //
    //     t1.start();
    //
    //     // 保证线程1先执行
    //     TimeUnit.SECONDS.sleep(2);
    //
    //     Thread t2 = new Thread(()->{
    //         syncTest.push();
    //     });
    //
    //     t2.start();
    // }

    public synchronized void push() {
        synchronized (o) {
            System.out.println("push...");
        }
        System.out.println("push over...");
    }

    public synchronized void pop() {
        synchronized (o) {
            try {
                System.out.println("pop start");
                wait();
                System.out.println("pop ing...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("pop over...");
    }

    public static void main(String[] args) throws InterruptedException {
        SyncTest syncTest = new SyncTest();

        Thread t1 = new Thread(() -> {
            syncTest.pop();
        });

        t1.start();

        // 保证线程1先执行
        TimeUnit.SECONDS.sleep(2);

        Thread t2 = new Thread(() -> {
            syncTest.push();
        });

        t2.start();
    }
}
