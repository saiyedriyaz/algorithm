package net.demo.concurrency;

import java.util.concurrent.*;

public class CyclicBarrierDemo {
    private void removeLions() {System.out.println("Removing lions");}
    private void cleanPen() {System.out.println("Cleaning the pen");}
    private void addLions() {System.out.println("Adding lions");}
    public void performTask(CyclicBarrier c1) {
        try {
            removeLions();
            c1.await();
            cleanPen();
            c1.await();
            addLions();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            var manager = new CyclicBarrierDemo();
            var cc1 = new CyclicBarrier(4);
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.performTask(cc1));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
