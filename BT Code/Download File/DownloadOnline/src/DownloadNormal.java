
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
public class DownloadNormal {
    public boolean status ;
    public DownloadNormal(MainUI main ,String fileName, String fileDestination) {
        status = false;
        try {
            URLConnection conn = new URL(fileName).openConnection();
            InputStream is = conn.getInputStream();
            OutputStream outstream = new FileOutputStream(fileDestination);         
            int size = conn.getContentLength();
            byte[] buffer = new byte[4096];
            int len;
            int downloaded = 0;
            while((len = is.read(buffer)) >0){
                downloaded += len;
                outstream.write(buffer,0,len);
                main.pbNormal.setValue((int) (downloaded*100)/size);
            }
            outstream.close();
            status = true;
        } catch (MalformedURLException ex) {
            Logger.getLogger(DownloadNormal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
}
