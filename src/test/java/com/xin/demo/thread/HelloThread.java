package com.xin.demo.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther xgs
 * @date 2019/12/24 4:09 下午
 */

public class HelloThread {
    @Test
    public void test() {
        ThreadFactory threadFactory = new ThreadNameFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), threadFactory);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取锁成功");
//                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "尝试--释放锁");
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放锁--成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    class ThreadNameFactory implements ThreadFactory {
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "name>>>" + threadNumber.getAndIncrement());
        }
    }
}
