package net.demo.exception;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class SuppressedException {
    public static void m1() throws Exception {
        try {
           m2();
        } catch (Exception e) {
            //e.printStackTrace();
            throw new Exception("Exception from m1");
        }
    }

    public static void m2() throws Exception {
        try (Reader r = new FileReader("no-file");) {
            r.read();
        }catch (IOException ioException) {
            //ioException.printStackTrace();
            Exception reT = new Exception("Dummy IOException");
            reT.addSuppressed(ioException);
            throw reT;
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            m1();
        }catch (Throwable t) {
            //t.printStackTrace();
            Throwable ss[] = t.getSuppressed();
            for(Throwable s : ss) {
                System.out.println(s.getMessage());
            }
        }
    }
}
