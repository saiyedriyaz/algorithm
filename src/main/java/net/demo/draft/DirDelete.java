package net.demo.draft;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

/**
 *
 */
public class DirDelete {

    public static void main(String[] s) {
        System.err.println("test");
        Set<String> hs = new HashSet<>();
        hs.add("sss");
        printFnames("C:\\Users\\se41hk\\OneDrive - ING\\Interviews\\Sushant\\meetup\\frontend\\frontend\\node_modules");
    }

    public static void printFnames(String sDir) {
        File[] faFiles = new File(sDir).listFiles();
        for (File file : faFiles) {
            if (file.getName().matches("^(.*?)")) {
                System.out.println(file.getAbsolutePath());
                file.delete();
            }
            if (file.isDirectory()) {
                printFnames(file.getAbsolutePath());
                if (file.listFiles().length == 0) {
                    System.out.println("empty dir going to delete..");
                    file.delete();
                }
            }
        }
    }
}
