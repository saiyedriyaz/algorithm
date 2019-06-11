package net.other;

import java.io.File;

/**
 *
 */

/**
 * @author Riyaz Saiyed
 *
 */
public class FileRename {

    public static void main(String[] s) {
        System.err.println("RenameFile test");
        printFnames("D:\\ProjectSRC\\NCO-DevelopmentClient_MIG\\app-lib");
    }

    public static void printFnames(String sDir) {
        File[] faFiles = new File(sDir).listFiles();
        for (File file : faFiles) {
            if (file.getName().matches("^(.*?)")) {
                System.out.println("AbsolutePath=" + file.getParentFile().getPath());

                String newName = file.getName();
                newName = newName.replace("-1.0", "-2.0");
                System.out.println("newName:" + newName);
                File newFile = new File(file.getParentFile().getPath() + "\\" + newName);

                file.renameTo(newFile);
            }
        }
    }
}
