import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mark
 * @date 2021/9/2 20:57
 */
public class MyTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("测试线程2=>" + new Date());
                Thread.sleep(4000);
                System.out.println("测试线程2结束=>" + new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 15;
        }, executor).thenAcceptBothAsync(CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("测试线程1=>" + new Date());
                Thread.sleep(3000);
                System.out.println("测试线程1结束=>" + new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 10;
        }, executor), (r, s) -> {
            System.out.println("对应的计算结果是：" + (r + s));
            System.out.println("结束计算的时间=>" + new Date());
        }, executor);

        System.out.println("main start");
        System.in.read();
        System.out.println("main over");
    }
}
