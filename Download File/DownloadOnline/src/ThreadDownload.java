
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Monkey
 */
public class ThreadDownload extends Thread {

    private final String fileName;
    private final int MAX_BUFFER_SIZE = 4096;
    private final String fileDestination;
    private final int START;
    private final int END;
    private final boolean DONE = true;
    private final boolean FAILED = false;
    private final MainUI main;
    public final int ID;
    public int rate = 0;
    public boolean status;

    public ThreadDownload(MainUI main, String fileName, String fileDestination, int ID, int START, int END) {
        this.ID = ID;
        this.main = main;
        this.fileName = fileName;
        this.fileDestination = fileDestination;
        this.START = START;
        this.END = END;
    }

    @Override
    public void run() {
        try {
            status = FAILED; // update status
            URL url = new URL(fileName); // NEw URL

            // Check ??
            System.out.println(START + " " + END); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// Open connection
            // Request to the position
            connection.setRequestProperty("Range", "bytes" + START + "-");
            int downloaded = 0; // byte downloaded
            // Check error
            if (connection.getResponseCode() / 100 != 2) {
                System.err.println("Error request!" + connection.getResponseCode());
            }

            int length = connection.getContentLength();
            if (length < 1) {
                System.err.println("Error request: Length Connection" + getId());
            }

            int size = END - START;
            InputStream inputStream = connection.getInputStream();
            RandomAccessFile file = new RandomAccessFile(fileDestination, "rw");
            int read;
            while (downloaded < size) { // Loop to read and write File
                byte[] buffer;
                if ((size - downloaded) > MAX_BUFFER_SIZE) {
                    buffer = new byte[MAX_BUFFER_SIZE];
                } else {
                    buffer = new byte[size - downloaded];
                }
                read = inputStream.read(buffer);
                if (read == -1) {
                    break; // Break Loop
                }
                file.write(buffer, 0, read);
                downloaded += read;

                /// Update progress bar
                rate = (int) (downloaded*100)/size;
                main.updateProgress(ID, rate); // Update progress bar
            }
            status = DONE;
            file.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(ThreadDownload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
    public int getRate(){
        return rate;
    }
    public void mergeFile(String output, String input1, String input2) { // Merge file after downloaded
        FileInputStream fileInput1 = null; // File ~2
        FileInputStream fileInput2 = null; // File ~3
        System.out.println(input1);
        FileOutputStream fileOutput = null; // File ~1
        try {
            // Merge file 2 in the end of file1 and then file 3 again.
            fileInput1 = new FileInputStream(input1);
            fileInput2 = new FileInputStream(input2);
            fileOutput = new FileOutputStream(output, true);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = fileInput1.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, length);
            }
            while ((length = fileInput2.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, length);
            }
            fileInput1.close();
            fileInput2.close();
            // Delete buffer file
            File f1 = new File(input1);
            f1.delete();
            File f2 = new File(input2);
            f2.delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ThreadDownload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            try {

                fileOutput.close();
            } catch (IOException ex) {
                Logger.getLogger(ThreadDownload.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
