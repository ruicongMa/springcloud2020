import org.junit.Test;

/**
 * @author Mark
 * @date 2022/7/27 18:14
 */
public class MyTest {

    @Test
    public void test01() throws Exception {
        Thread t1 = new Thread(() -> {
            System.out.println("ok...");
        });

        t1.start();
        Thread.sleep(1000);
        t1.start();
        System.in.read();
    }
}
