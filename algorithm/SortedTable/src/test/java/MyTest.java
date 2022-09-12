import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2021/9/8 23:39
 */
public class MyTest {

    public static class T implements Runnable {

        private int count = 100;

        public synchronized void run() {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }

    }

    public static void main(String[] args) {

        // T t = new T();
        // for (int i = 0; i < 5; i++) {
        //     new Thread(t, "THREAD" + i).start();
        // }

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        System.out.println("start");
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("ok");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);

    }

}
