package GUI;

import javax.swing.*;
import GUI.ControlPanel.LookupGUI;
import Dict.DictionaryManagement;
import GUI.ControlPanel.EditGUI;
import GUI.ControlPanel.LearnGUI;
import GUI.ControlPanel.TranslateGUI;
import GUI.ControlPanel.controlPanel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import jnafilechooser.api.JnaFileChooser;

public class DictionaryGUI extends javax.swing.JFrame {
    private CardLayout cardLayout;
    
    private DictionaryManagement dictionaryManagement;
    
    private LookupGUI lookupGUI;
    private TranslateGUI translateGUI;
    private LearnGUI learnGUI;
    
    private ArrayList<String> Listfuntion = new ArrayList<>();
    
    public DictionaryGUI() {
        initComponents();
        init();
    }
    
    private void init() {
        JFrame f = this;
        
        ImageIcon iconApp = new ImageIcon("src/data/img/logo.png");
        setIconImage(iconApp.getImage());
        
        dictionaryManagement = new DictionaryManagement();
//        dictionaryManagement.insertFromFile();
        
        cardLayout = new CardLayout(0, 0);
        
        lookupGUI = new LookupGUI();
        lookupGUI.setDictionay(dictionaryManagement);
        lookupGUI.setframe(f);
        
        translateGUI = new TranslateGUI();
        
        learnGUI = new LearnGUI(dictionaryManagement);
               
        workPanel.setLayout(cardLayout);
        
        workPanel.add("lookup",lookupGUI);
        workPanel.add("translate", translateGUI);
        workPanel.add("learn", learnGUI);
        
        Listfuntion.add("lookup");
        Listfuntion.add("translate");
        Listfuntion.add("learn");
        

        controlpanel.eventLookupGUI(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controlpanel.setSelect(controlPanel.LOOKUP);
                change(controlPanel.LOOKUP);
            }
            
        });
        
        controlpanel.eventTranslateGUI(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controlpanel.setSelect(controlPanel.TRANSLATE);
                change(controlPanel.TRANSLATE);
            }
            
        });
        
        controlpanel.eventAddGUI(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                EditGUI add = new EditGUI(f, " Add Word", dictionaryManagement);
                add.showDialog();
            }
            
        });
        
        controlpanel.eventLearnGUI(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                controlpanel.setSelect(controlPanel.LEARN);
                change(controlPanel.LEARN);
                dictionaryManagement.GetListVocabFromDB();
                learnGUI.refresh();
                learnGUI.startLearn();
                JOptionPane.showMessageDialog(learnGUI, "Choose a subject to review vocabulary");
            }
            
        });
        
        controlpanel.eventExportGUI(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                ExportToFile(e);
            }
            
        });
    }
    
    private void change(int select) {
        CardLayout c = (CardLayout)(workPanel.getLayout());
        c.show(workPanel, Listfuntion.get(select));  
    }
    
    private void ExportToFile(MouseEvent e) {
        JnaFileChooser fc = new JnaFileChooser();
        fc.setTitle("Export to File");
        boolean save = fc.showSaveDialog(this);
        
        if (save) {
            File file = fc.getSelectedFile();
            dictionaryManagement.dictionaryExportToFile(file.getAbsolutePath());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new GUI.roundComponent.Button();
        controlpanel = new GUI.ControlPanel.controlPanel();
        roundedPanel1 = new GUI.roundComponent.RoundedPanel();
        workPanel = new javax.swing.JPanel();

        button1.setText("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vortaro");
        setBackground(new java.awt.Color(245, 245, 245));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundTopLeft(80);
        roundedPanel1.setRoundTopRight(80);

        workPanel.setBackground(new java.awt.Color(255, 255, 255));
        workPanel.setOpaque(false);

        javax.swing.GroupLayout workPanelLayout = new javax.swing.GroupLayout(workPanel);
        workPanel.setLayout(workPanelLayout);
        workPanelLayout.setHorizontalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(workPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(controlpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controlpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        dictionaryManagement.dictionaryExportToFile("src/data/dictionary.txt");
//save file learn
    }//GEN-LAST:event_formWindowClosing


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DictionaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DictionaryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button button1;
    private GUI.ControlPanel.controlPanel controlpanel;
    private GUI.roundComponent.RoundedPanel roundedPanel1;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
