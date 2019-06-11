package net.other;

import java.io.File;

/**
 *
 */

/**
 * @author S425401
 *
 */
public class DirDelete {

    public static void main(String[] s) {
        System.err.println("test");
        printFnames("D:\\GIT_MIG_ROLLBACK");
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
