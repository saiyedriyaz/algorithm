package net.demo.draft;


public class DecimalConversion {

    public static void main(String[] args) {
        //String o = toBinary(3);
        String o = toOctal(500);
        System.err.println(o);
    }

    public static String toBinary(int decimal) {
        StringBuilder b = new StringBuilder();
        while (decimal > 0) {
            b.append(decimal % 2);
            decimal = decimal / 2;
        }
        return b.reverse().toString();
    }

    public static String toOctal(int decimal) {
        StringBuilder b = new StringBuilder();
        while (decimal > 0) {
            b.append(decimal % 8);
            decimal = decimal / 8;
        }
        return b.reverse().toString();
    }
}
