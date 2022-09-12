package com.markzoe;

import com.markzoe.service.SPITest;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ServiceLoader;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2021/7/28 17:31
 */
public class MyTest {

    @Test
    public void spi() {
        ServiceLoader<SPITest> serviceLoader = ServiceLoader.load(SPITest.class);
        for (SPITest spiTest : serviceLoader) {
            spiTest.say();
        }
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        // String packageName = "com.markzoe";
        // String physicPath = "/" + packageName.replaceAll("\\.", "/");
        // URL url = MarkZoeMain666888.class.getClassLoader().getResource(physicPath);
        // String path = url.getPath();
        // File file = new File(path);
        // System.out.println(path);

        // CompletableFuture<String> af = CompletableFuture.supplyAsync(() -> {
        //     System.out.println("a");
        //     return "a";
        // });
        //
        // CompletableFuture<String> bf = af.thenCompose(result -> CompletableFuture.supplyAsync(() -> {
        //     System.out.println(result + "b");
        //     return result + "b";
        // }));
        //
        // bf.thenCombine(bf.thenApplyAsync(result -> {
        //     System.out.println(result + "c");
        //     return result + "c";
        // }),(k,v) -> k + v);
        //
        // bf.get();

        System.out.println(810 % 500);

    }
}
