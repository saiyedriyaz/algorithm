package net.demo.generics;

import java.security.AccessController;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlaceHolder<K, V> { //1
    private K k;
    private V v;
    public PlaceHolder(K k, V v){ //2
        this.k = k;
        this.v = v;
    }
    public K getK() { return k; }
    public static <X> PlaceHolder<X, X> getDuplicateHolder(X x){ //3
        return new PlaceHolder<X, X>(x, x); //4
    }

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3);
        Function<Integer, String> func = a->a*a+"-"; //1
        var v1 = ls.stream().map(func).peek(System.out::print).collect(Collectors.toList()); //2
        System.out.println(v1);

        //int[] ia1 = { 1,2,2}; //-1 2
        //int[] ia2 = { 1,2,3};

        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("test.MyBundle", locale);
    }



}