package net.demo.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo2 {
    public static void main(String[] args) {
        var rlock = new ReentrantLock();
        var f1 = rlock.tryLock(); // hold count 1
        System.out.println(f1);
        var f2 = rlock.tryLock(); // hold count 2
        System.out.println(f2);
        rlock.unlock(); // hold count 1, still locked
        rlock.unlock(); // hold count 0, unlocked
        rlock.unlock(); // exception

    }
}
