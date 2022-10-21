package net.demo.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    final static List<String> names = List.of("one", "two", "three");

    //static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        System.out.println("processors="+Runtime.getRuntime().availableProcessors());
        Runnable r1 = () -> {
            System.out.println("running in seperate thread:" + Thread.currentThread().getName());
            try {
                doTask(names);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        //new Thread(r1).start();
        //new Thread(r1).start();
        System.out.println("running in main thread:" + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        var f1 = executorService.submit(r1);
        var f2 = executorService.submit(r1);
        executorService.shutdown();
    }

    static void doTask(java.util.List<String> names) throws Exception {
        for (String name : names) {
            System.out.println(name);
            Thread.sleep(1000);
        }
        try {
            //reentrantLock.lock();

        } finally {
            //reentrantLock.unlock();
        }

    }
}
