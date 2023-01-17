package net.demo.annotation;

public @interface Resource {
    String name();
    int priority() default 0;
}

@Resource(name = "riyaz", priority = 10)
class ProcessOrders {

}
