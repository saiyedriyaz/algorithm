package net.demo.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOMain {
    public static void main(String[] args) throws Exception{

        /*Scanner scanner = new Scanner(System.console().reader());
        java.util.Set<String> workdSet = scanner.useDelimiter(";").tokens().collect(Collectors.toSet());
        System.out.println(workdSet);*/

        var lineStream = Files.lines(Path.of("/Users/mahammedriyazsaiyed/IdeaProjects/algorithm/src/main/java/net/demo/io/InnerClassDEMO.java"));
        lineStream.forEach(line -> System.out.println(line));
        System.out.println("----");
        var lineList = Files.readAllLines(Path.of("/Users/mahammedriyazsaiyed/IdeaProjects/algorithm/src/main/java/net/demo/io/InnerClassDEMO.java"));
        lineList.forEach(line -> System.out.println(line));

    }
}
