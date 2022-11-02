package net.demo.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.*;

public class Bank {
    //private Lock vault = new ReentrantLock();
    private int total = 0;

    public void deposit(int value) {
        try {
            //vault.tryLock();
            total += value;
            System.out.println("inside deposite.."+ value+":"+total);
        } finally {
            //vault.unlock();
        }
    }
    private static int counter = 0;
    public static void main(String[] unused)  {
        /*Runnable task = () -> {
            try {
                Thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };*/
        IntConsumer consumer = counter -> counter++;
        LongStream.range(1, 500)
                .forEach(value ->
                        consumer.accept(counter)
                );
        System.out.println(counter);
    }
}