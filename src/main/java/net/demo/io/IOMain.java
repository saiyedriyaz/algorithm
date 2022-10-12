package net.demo.io;

import java.util.Scanner;
import java.util.stream.Collectors;

public class IOMain {
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.console().reader());
        java.util.Set<String> workdSet = scanner.useDelimiter(";").tokens().collect(Collectors.toSet());
        System.out.println(workdSet);

    }
}
