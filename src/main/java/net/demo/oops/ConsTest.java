package net.demo.oops;
class ConSuper {
    protected ConSuper() {
        this(2);
        System.out.print("1");
    }
    protected ConSuper(int a) {
        System.out.print(a);
    }
}
class ConSub extends  ConSuper{
    ConSub() {
        this(4);
        System.out.print("3");
    }

    ConSub(int a) {
        super(a);
        System.out.print(a);
    }
}
public class ConsTest {
    public static void main(String[] args) {
        ConSub sub = new ConSub(4);
    }
}
