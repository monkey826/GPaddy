/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filethread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Monkey
 */
public class MainUI extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        taFile = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tfCount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTime = new javax.swing.JTextField();
        btnNewFile = new javax.swing.JButton();
        btnCopyFile = new javax.swing.JButton();
        btnCutFile = new javax.swing.JButton();
        btnInsertIntoFile = new javax.swing.JButton();
        btnDeleteFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Program");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-file_318-76247.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        taFile.setColumns(20);
        taFile.setLineWrap(true);
        taFile.setRows(5);
        taFile.setAutoscrolls(false);
        taFile.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        taFile.setEnabled(false);
        jScrollPane1.setViewportView(taFile);

        scrollPane1.add(jScrollPane1);

        jLabel2.setText("Count Search");

        tfCount.setEnabled(false);

        jLabel3.setText("Time counting");

        tfTime.setEnabled(false);

        btnNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_1_97378.jpg"))); // NOI18N
        btnNewFile.setText("New File");
        btnNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFileActionPerformed(evt);
            }
        });

        btnCopyFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copy.png"))); // NOI18N
        btnCopyFile.setText("Copy File");
        btnCopyFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyFileActionPerformed(evt);
            }
        });

        btnCutFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/21-o-128.png"))); // NOI18N
        btnCutFile.setText("Cut File");
        btnCutFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCutFileActionPerformed(evt);
            }
        });

        btnInsertIntoFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Table Field Insert.jpg"))); // NOI18N
        btnInsertIntoFile.setText("Insert into File");
        btnInsertIntoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertIntoFileActionPerformed(evt);
            }
        });

        btnDeleteFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-48.jpg"))); // NOI18N
        btnDeleteFile.setText("Delete File");
        btnDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewFile, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCopyFile, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertIntoFile, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCutFile, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewFile, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCopyFile, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCutFile, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertIntoFile, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Choose a file
     *
     * @return
     */
    public File getSelectedFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file");
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    /**
     * Choose a folder
     *
     * @return
     */
    public File chooseADirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose the destination file");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    /**
     * Search
     *
     * @param evt
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String filePath = chooseADirectory().toString();
        if (filePath != null ) {
            FileTree fileTree = new FileTree(filePath, this);
            Thread threadFile = new Thread(fileTree);
            threadFile.start();
            taFile.removeAll();
        }


    }//GEN-LAST:event_btnSearchActionPerformed
    /**
     * New File
     *
     * @param evt
     */
    private void btnNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFileActionPerformed
        // TODO add your handling code here:
        String fileName = JOptionPane.showInputDialog("Enter file name, remember type of format file ");
        if (fileName != null) {
            File file = new File(chooseADirectory().getAbsolutePath() + "\\" + fileName);
            try {
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(null, " File is created! ");
                } else {
                    JOptionPane.showMessageDialog(null, "File already exists.");
                }
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnNewFileActionPerformed
    /**
     * Cut file
     *
     * @param evt
     */
    private void btnCutFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCutFileActionPerformed
        // TODO add your handling code here:
        try {
            File fileSource = getSelectedFile();
            if (fileSource != null) {
                File fileDestination = chooseADirectory();
                if (fileSource.renameTo(new File(fileDestination.getAbsolutePath() + "\\" + fileSource.getName()))) {
                    JOptionPane.showMessageDialog(null, "ok");
                } else {
                    JOptionPane.showMessageDialog(null, "Error");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCutFileActionPerformed
    /**
     * Insert into File
     *
     * @param evt
     */
    private void btnInsertIntoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertIntoFileActionPerformed
        // TODO add your handling code here:
        // Read file 
        byte[] content = JOptionPane.showInputDialog("Enter a string, you want to insert into file").getBytes();
        Long indexByte = 5l;
        try {
            indexByte = Long.parseLong(JOptionPane.showInputDialog("Enter the postition you want to insert by Byte unit"));
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }
        try {
            insert(getSelectedFile().toString(), indexByte, content);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnInsertIntoFileActionPerformed
    /**
     * insert Function
     *
     * @param filename
     * @param offset
     * @param content
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void insert(String filename, long offset, byte[] content) throws FileNotFoundException, IOException {
        RandomAccessFile r = new RandomAccessFile(new File(filename), "rw");
        File ftemp = new File(filename + "~");
        RandomAccessFile rtemp = new RandomAccessFile(ftemp, "rw");
        long fileSize = r.length();
        FileChannel targetChannel;
        try (FileChannel sourceChannel = r.getChannel()) {
            targetChannel = rtemp.getChannel();
            sourceChannel.transferTo(offset, (fileSize - offset), targetChannel);
            sourceChannel.truncate(offset);
            r.seek(offset);
            r.write(content);
            long newOffset = r.getFilePointer();
            targetChannel.position(0L);
            sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - offset));
        }
        targetChannel.close();
    }

    /**
     * Delete File
     *
     * @param evt
     */
    private void btnDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFileActionPerformed
        // TODO add your handling code here:
        File file = getSelectedFile();
        if (file != null) {
            if (JOptionPane.showConfirmDialog(null, file, "Are you sure want to delete this file ?", JOptionPane.YES_NO_OPTION) == 0) {
                if (file.delete()) {
                    JOptionPane.showMessageDialog(null, " File is deleted! ");
                } else {
                    JOptionPane.showMessageDialog(null, " Error! Maybe file haven't existed! ");
                }
            }
        }

    }//GEN-LAST:event_btnDeleteFileActionPerformed
    /**
     * Copy File
     *
     * @param evt
     */
    private void btnCopyFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyFileActionPerformed
        // TODO add your handling code here:
        File fileSource = getSelectedFile();
        String nameSource = fileSource.getName();
        String path = chooseADirectory().getAbsolutePath() + "\\" + nameSource;
        File fileDestination = new File(path);
        try {
            fileDestination.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(fileSource);
            os = new FileOutputStream(fileDestination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            JOptionPane.showMessageDialog(null, "Succesful");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Oh! Error! Forgive me");
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCopyFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopyFile;
    private javax.swing.JButton btnCutFile;
    private javax.swing.JButton btnDeleteFile;
    private javax.swing.JButton btnInsertIntoFile;
    private javax.swing.JButton btnNewFile;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.ScrollPane scrollPane1;
    public javax.swing.JTextArea taFile;
    public javax.swing.JTextField tfCount;
    public javax.swing.JTextField tfTime;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
