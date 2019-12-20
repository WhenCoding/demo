package com.xin.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @auther xgs
 * @date 2019/12/12 10:51 上午
 */

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 1; i <= threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j <= 2; j++) {
                    MyUtil.add(String.valueOf(j));
                    MyUtil.print();
                }
                MyUtil.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();
    }

    private static class MyUtil {

        public static void add(String newStr) {
            StringBuilder str = StringBuilderUtil.stringBuilderThreadLocal.get();
            StringBuilderUtil.stringBuilderThreadLocal.set(str.append(newStr));
        }

        public static void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    StringBuilderUtil.stringBuilderThreadLocal.hashCode(),
                    StringBuilderUtil.stringBuilderThreadLocal.get().hashCode(),
                    StringBuilderUtil.stringBuilderThreadLocal.get().toString());
        }

        public static void set(String words) {
            StringBuilderUtil.stringBuilderThreadLocal.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    StringBuilderUtil.stringBuilderThreadLocal.hashCode(),
                    StringBuilderUtil.stringBuilderThreadLocal.get().hashCode(),
                    StringBuilderUtil.stringBuilderThreadLocal.get().toString());
        }
    }

    private static class StringBuilderUtil {
        // ThreadLocal 变量通常被 private static 修饰
        private static ThreadLocal<StringBuilder> stringBuilderThreadLocal = ThreadLocal.withInitial(() -> new StringBuilder());
    }

}
