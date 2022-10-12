package net.demo.interview;

interface Engine {
    void start();
    void stop();

    default void coolDown() {
        System.out.println("cooling down..");
    }
}

class CarEngine implements Engine {
    @Override
    public void start() {
        System.out.println("car started");
    }

    @Override
    public void stop() {
        System.out.println("car stopped");
    }

    /*public static void coolDown() {
        System.out.println("car engine cooling down");
    }*/
}

class TruckEngine implements Engine {
    @Override
    public void start() {
        System.out.println("truck started");
    }

    @Override
    public void stop() {
        System.out.println("truck stopped");
    }

    @Override
    public void coolDown() {
        System.out.println("truck engine cooling down");
    }
}

public class Polymorphism {
    public Polymorphism() { }
    public static void main(String[] args) {
        Engine engine1 = new CarEngine();
        Engine engine2 = new TruckEngine();
        engine1.start();
        engine1.coolDown();
        engine2.stop();
        engine2.coolDown();
        //Engine.coolDown(50);
    }
}
