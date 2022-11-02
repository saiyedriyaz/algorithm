package net.demo.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Deadlock {
    static int count = 0;

    private static  AtomicInteger s1 = new AtomicInteger(0); // w1
    private static int s2 = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2
            for (int i = 0; i < 100; i++)
                service.execute(() -> {
                    s1.getAndIncrement();
                    s2++;
                }); // w3
            Thread.sleep(100);
            System.out.println(s1 + " " + s2);
        } finally {
            if (service != null) service.shutdown();
        }

    }

    public static void addAndPrintItems(BlockingQueue<Integer> queue) throws Exception {
        queue.offer(103);
        queue.offer(120);//,1, TimeUnit.SECONDS);
        queue.offer(85);//, 7, TimeUnit.HOURS);
        System.out.print(queue.poll(200, TimeUnit.NANOSECONDS));
        System.out.print(" " + queue.poll(1, TimeUnit.MINUTES));
    }
}
