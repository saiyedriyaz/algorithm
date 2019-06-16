package net.demo.draft;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownload {

    public static void downloadWithJavaIO(String url, String localFilename) {

        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream()); FileOutputStream fileOutputStream = new FileOutputStream(localFilename)) {

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadFolderData(String urlString, String localFilename) throws Exception {
        URL url = new URL(urlString);
        InputStream is = null;
        try {
            is = url.openStream();
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            StringBuilder page = new StringBuilder(1024);
            while ((bytesRead = is.read(buffer)) != -1) {
                page.append(new String(buffer, 0, bytesRead));
            }
            // Spend the rest of your life using String methods
            // to parse the result...
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        downloadFolderData("https://1drv.ms/u/s!AtQT7iz4iQiWguFNOinLSnld_Fmo_A?e=cBFXzM", "Videos-2");
    }
}