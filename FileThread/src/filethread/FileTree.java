/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filethread;

import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Monkey
 */
public class FileTree implements Runnable {

    private Stack<File> sf = new Stack<>();
    private final String path;
    private final MainUI main;
    public ArrayList<String> pathList = new ArrayList<>();

    public FileTree(String path, MainUI main) {
        this.main = main;
        this.path = path;
    }

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        Integer i = 0;
        File file = new File(this.path);
        if (file.isDirectory()) {
            sf.push(file);
            while (!sf.isEmpty()) {
                File fread = sf.pop();
                if (fread.isDirectory()) {
                    File[] list = fread.listFiles();
                    if (list != null) {
                        for (File f : list) {
                            if (f.isFile()) {
                                main.taFile.append(f.getName() + "\n");
                                i++;
                                main.tfCount.setText(i.toString());
                                Long resultTime = System.currentTimeMillis() - start;
                                main.tfTime.setText(resultTime.toString() + " ms");
                            }
                            try {
                                sleep(5);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FileTree.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (f.isDirectory()) {
                                sf.push(f);
                            }
                        }
                    }
                }
            }
        JOptionPane.showMessageDialog(null, "Done!");
        }
    }

}
