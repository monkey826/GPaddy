package Source;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Monkey
 */
public class MainUI extends javax.swing.JFrame {

    private Dictionary dict = null;
    private DefaultListModel model = new DefaultListModel();

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        this.setTitle(" Dictionary - Dao Nam Tien");
        this.setResizable(false);
        ConnectData connectData = new ConnectData();
        taMeanning.setEditable(false);
        dict = new Dictionary();
        setFullListData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listWords = new javax.swing.JList<>();
        tfWord = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMeanning = new javax.swing.JTextArea();
        tbChangeFontSize = new javax.swing.JToggleButton();
        lbCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listWords.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listWords.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listWordsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listWords);

        tfWord.setToolTipText("Enter word here...");
        tfWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfWordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfWordKeyReleased(evt);
            }
        });

        taMeanning.setColumns(20);
        taMeanning.setLineWrap(true);
        taMeanning.setRows(5);
        taMeanning.setWrapStyleWord(true);
        taMeanning.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(taMeanning);

        tbChangeFontSize.setText("A");
        tbChangeFontSize.setToolTipText("Change font size");
        tbChangeFontSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbChangeFontSizeActionPerformed(evt);
            }
        });

        lbCount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Facebook-Messenger-search-icon.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfWord)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbChangeFontSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCount, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbChangeFontSize))
                    .addComponent(lbCount, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfWordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = tfWord.getText().toLowerCase().trim();
            int index = 0;
            boolean isFind = false;
            for (index = 0; index < dict.words.size(); index++) {
                String it = dict.words.get(index).toLowerCase();
                if (it.startsWith(value)) {
                    isFind = true;
                    break;
                }
            }
            if (isFind == true) {
//                listWords.setSelectedIndex(index);
//                listWords.ensureIndexIsVisible(index);
            } else if (isFind == false) {
                JOptionPane.showMessageDialog(this, " This word \"" + value + "\" doesn't existed in dictionary.,",
                        "Search failed", JOptionPane.INFORMATION_MESSAGE);
            }
//             Enter was pressed. Your code goes here.
        }
    }//GEN-LAST:event_tfWordKeyPressed

    private void listWordsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listWordsValueChanged
        // TODO add your handling code here:
        int index = listWords.getSelectedIndex();
        if (index != -1) {
            String value = dict.words.get(index);
            String mean = ((Word) dict.dictionary.get(value)).getMean();
            taMeanning.setText(mean);
        }
    }//GEN-LAST:event_listWordsValueChanged

    private void tfWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfWordKeyReleased
        // TODO add your handling code here:
        String value = tfWord.getText().toLowerCase().trim();
        int index;
        for (index = 0; index < dict.words.size(); index++) {
            String it = dict.words.get(index).toLowerCase();
            if (it.startsWith(value) || it.compareTo(value) > 0) {
                break;
            }
        }
        listWords.setSelectedIndex(index);
        listWords.ensureIndexIsVisible(index);


    }//GEN-LAST:event_tfWordKeyReleased

    private void tbChangeFontSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbChangeFontSizeActionPerformed
        // TODO add your handling code here
        if (tbChangeFontSize.isSelected()) {
            taMeanning.setFont(new Font("Serif", Font.PLAIN, 20));
        } else {
            taMeanning.setFont(new Font("Serif", Font.PLAIN, 16));
        }

    }//GEN-LAST:event_tbChangeFontSizeActionPerformed
    public void setFullListData() {
        int i = 0;
        for (Iterator<String> it = dict.words.iterator(); it.hasNext(); i++) {
            model.add(i, it.next());
        }
        listWords.setModel(model);
        String s = dict.words.size() + " words ";
        lbCount.setText(s);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable ex) {
            old = null;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCount;
    private javax.swing.JList<String> listWords;
    private javax.swing.JTextArea taMeanning;
    private javax.swing.JToggleButton tbChangeFontSize;
    private javax.swing.JTextField tfWord;
    // End of variables declaration//GEN-END:variables
}
