package Source;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monkey
 */
public class Word {

    public static RandomAccessFile input = null;
    public static int seek;
    private String key;
    private String mean;
    private Vector<Integer> length = new Vector<>();
    private Vector<Integer> off = new Vector<>();
    private boolean isLoaded;

    public Word(String key, int off, int len) {
        this.key = key;
        this.isLoaded = false;
        addInfor(off, len);
    }

    public Word(String key, String mean) {
        this.key = key;
        this.mean = mean;
        this.isLoaded = true;
    }

    public void addInfor(int off, int length) {
        this.off.add(off);
        this.length.add(length);
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getMean() {
        if (!isLoaded) {
            loadMean();
        }
        return mean;
    }

    public void insertData(String key, String mean) {
        Statement stmt = null;
        try {
            stmt = ConnectData.conn.createStatement();
            String sql = "INSERT INTO COMPANY (word,meanning) "
                    + "VALUES ( " + key + "," + mean + ");";
            stmt.executeQuery(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    synchronized public String loadMean() {
        this.mean = "This word didn't have meaning in dictionary";
        // Word on list but don't have mean.
        int size = off.size();
        for (int i = 0; i < size; i++) {
            try {
                int off = this.off.get(i);
                int length = this.length.get(i);
                byte[] buff = new byte[length];
                input.seek(off);
                input.read(buff, 0, length);
               
                String mean = new String(buff, "UTF8").replaceAll("\0+", "");
//                insertData(key, mean);
                if (i == 0) {
                    this.mean = mean;
                } else if (!this.mean.contains(mean.trim())) {
                    this.mean += '\n' + mean;
                }
            } catch (IOException ex) {
                Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.isLoaded = true;
        return this.mean;
    }
}
