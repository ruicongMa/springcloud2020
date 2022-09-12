import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2021/9/9 11:58
 */
public class Person implements Animal {

    public static void main(String[] args) throws Exception {
        // System.out.println(Animal.class.isAssignableFrom(Person.class));
        // LinkedList<String> list = new LinkedList<>();

        Thread t1 = new Thread(() -> {
            // // 每隔一秒检测是否设置了中断标示
            // while (!Thread.currentThread().isInterrupted()) {
            //     System.out.println("Thread is running...");
            //     long time = System.currentTimeMillis();
            //     // 使用while循环模拟 sleep
            //     while ((System.currentTimeMillis() - time < 1000)) {
            //     }
            // }
            // System.out.println("Thread exiting under request...");
            //
            // while (true) {
            //     try {
            //         Thread.sleep(5000);
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            // }

            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Starting thread...");
        t1.start();

        Thread.sleep(1000);
        // System.out.println("Asking thread to stop...");
        //
        // // 发出中断请求
        // t1.interrupt();
        // Thread.sleep(3000);
        //
        //
        //
        //
        // System.out.println("Stopping application...");


    }
}
