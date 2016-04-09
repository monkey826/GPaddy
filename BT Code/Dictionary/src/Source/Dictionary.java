package Source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Monkey
 */
public class Dictionary implements Runnable {

    public Hashtable<String, Word> dictionary;
    private File indexFile;
    private File meansFile;
    public Vector<String> words = new Vector<>();

    // Constructor
    public Dictionary() {
        this.dictionary = new Hashtable<>();
        // Index file
        indexFile = new File(System.getProperty("user.dir").concat("/data/anhviet109K.index"));
        // File meanning
        meansFile = new File(System.getProperty("user.dir").concat("/data/anhviet109K.dict"));
        loadIndex();
        new Thread(this).start();

    }

    // Read file index 
    public void run() {
        loadFullDictionary();
    }

    private void loadIndex() {
        long begin = System.currentTimeMillis();
        try {
            // Using stringbuilder ( a thread )with big data and faster than StringBuffer 
            StringBuilder builder = new StringBuilder();
            try (FileInputStream input = new FileInputStream(indexFile)) {
                byte[] buffer = new byte[1024];
                while (input.read(buffer) != -1) { // Loops until read end file
                    builder.append(new String(buffer));
                }
                // Read data index.
                String data = builder.toString();
                StringTokenizer tokenizer = new StringTokenizer(data, "\n");
                while (tokenizer.hasMoreTokens()) {
                    String line = tokenizer.nextToken();
                    String elements[] = line.split("\t");
                    if (elements.length == 3) { // If enough length then read.
                        Word word = dictionary.get(elements[0]);
                        int address = base64ToBase10(elements[1]); // address word in file meanning
                        int length = base64ToBase10(elements[2]);
                        if (word == null) { // If word is not on list
                            word = new Word(elements[0], address, length);
                            dictionary.put(elements[0], word);
                            words.add(elements[0]);
                        } else { // If on list for updating.
                            // Store address and length of this word
                            word.addInfor(address, length);
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error IO" + ioe.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("Load index file took " + (-begin + end) + " ms");
    }

    public int base64ToBase10(String number) {
        int num = 0;
        int len = number.length();
        String opcode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (int i = 0; i < len; i++) {
            num += opcode.indexOf(number.charAt(i)) * Math.pow(64, len - i - 1);
        }
        return num;
    }

    public void loadFullDictionary() {
        long begin = System.currentTimeMillis();
        try {
            Word.input = new RandomAccessFile(meansFile, "r");
            Iterator<String> it = words.iterator();
            int i = 0;
            while (it.hasNext()) {
                Word word = (Word) dictionary.get(it.next());
                word.loadMean();
//                insertData(words.get(i), word.loadMean());
                i++;
            }
            Word.input.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Load full dictionary completed in: " + (-begin + end) + " ms");
    }

//    synchronized public void insertData(String key, String mean) {
//        Statement stmt = null;
//        try {
//            stmt = ConnectData.getConn().createStatement();
//            String sql = "INSERT INTO Dictionary (word,meanning) "
//                    + "VALUES ('" + key + "','" + mean + "');";
//            System.out.println(sql);
//            stmt.executeUpdate(sql);
//            stmt.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
