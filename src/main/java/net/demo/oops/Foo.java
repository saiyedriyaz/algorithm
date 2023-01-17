package net.demo.oops;

import java.util.ArrayList;
import java.util.Collection;

public class Foo {
    public void foo(Collection arg) {
        System.out.println("Bonjor le monde!");
    }
}

class Bar extends Foo {
    public void foo(Collection arg) {
        System.out.println("Hello world!");
    }

    public void foo(java.util.List arg) {
        System.out.println("Ola Mundo!");
    }

    public static void main(String[] args) {
        Foo f1 = new Foo();
        Foo f2 = new Bar();
        Bar b1 = new Bar();
        Collection<String> c = new ArrayList<>();
        f1.foo(c);
        f2.foo(c); /// ???
        b1.foo(c);
    }
}
