package net.demo.oops;

class Paintable {
    public void paint() {
        System.out.println("Paint the Paintable");
    }
}

class House extends Paintable {
    public void paint() {
        System.out.println("Painting House.");
    }
}

class SmallHouse extends House {
    public void paint() {
        System.out.println("Painting Small House");
    }
}

class Vehicle extends Paintable {
    public void paint() {
        System.out.println("Painting Vehicle");
    }
}

public class PaintTest {
    public static void main(String[] args) {
        Paintable paintable = new SmallHouse();
        paintable.paint();

        paintable = new Vehicle();
        paintable.paint();
    }
}
