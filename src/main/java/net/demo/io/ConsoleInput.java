package net.demo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Input:");
            String input = br.readLine();
            System.out.println("Echo:"+input);
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
