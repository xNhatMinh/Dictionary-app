package GUI.ControlPanel;

import Translate.TranslateController;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;

public class TranslateGUI extends javax.swing.JPanel {
    private TranslateController controller;
    
    private String target;
    private String result;

    public TranslateGUI() {
        initComponents();
        
        controller = new TranslateController();
        
        languageSelect1.setLanguages((ArrayList)controller.getLanguages());
        languageSelect2.setLanguages((ArrayList)controller.getLanguages());
        
        transfer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textBar = new GUI.ControlPanel.Search.TextFieldAnimation();
        jPanel2 = new javax.swing.JPanel();
        Language1 = new GUI.ControlPanel.Search.ResultBoard();
        Language2 = new GUI.ControlPanel.Search.ResultBoard();
        jLabel1 = new javax.swing.JLabel();
        read1 = new GUI.roundComponent.Button();
        read2 = new GUI.roundComponent.Button();
        languageSelect1 = new GUI.ControlPanel.Translate.LanguagePanel();
        languageSelect2 = new GUI.ControlPanel.Translate.LanguagePanel();
        iconTranslate = new GUI.roundComponent.circleComponent();
        transfer = new javax.swing.JLabel();

        setOpaque(false);

        textBar.setBackground(new java.awt.Color(245, 242, 242));
        textBar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        textBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textBarMousePressed(evt);
            }
        });
        textBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textBarKeyPressed(evt);
            }
        });

        jPanel2.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setOpaque(true);

        read1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/audio.png"))); // NOI18N
        read1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                read1MousePressed(evt);
            }
        });

        read2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/audio.png"))); // NOI18N
        read2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                read2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Language1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(read1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Language2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(read2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Language1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Language2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(read2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(read1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        languageSelect1.setBackground(new java.awt.Color(245, 242, 242));
        languageSelect1.setText("English");
        languageSelect1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                languageSelect1MousePressed(evt);
            }
        });

        languageSelect2.setBackground(new java.awt.Color(245, 242, 242));
        languageSelect2.setText("Vietnamese");
        languageSelect2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                languageSelect2MousePressed(evt);
            }
        });

        iconTranslate.setBackground(new java.awt.Color(254, 236, 166));
        iconTranslate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/ggtranslate.png"))); // NOI18N
        iconTranslate.setOpaque(true);

        transfer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/transfer.png"))); // NOI18N
        transfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transferMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textBar, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(languageSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(languageSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(languageSelect2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(languageSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(textBar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(iconTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void transferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferMousePressed
        String tm1 = languageSelect1.getText();
        String tm2 = languageSelect2.getText();
        languageSelect1.setText(tm2);
        languageSelect2.setText(tm1);
        
    }//GEN-LAST:event_transferMousePressed

    private void languageSelect1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_languageSelect1MousePressed
        if (languageSelect2.isShow()) {
            languageSelect2.setShow(false);
        }
    }//GEN-LAST:event_languageSelect1MousePressed

    private void languageSelect2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_languageSelect2MousePressed
        if (languageSelect1.isShow()) {
            languageSelect1.setShow(false);
        }
    }//GEN-LAST:event_languageSelect2MousePressed

    private void textBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!textBar.getText().isEmpty()) {
                if (!textBar.getShow()) {
                    processing();   
                }
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (textBar.getShow()) {
                textBar.close_searching();    
            }
        }
    }//GEN-LAST:event_textBarKeyPressed

    private void textBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBarMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (textBar.checkMouseOver(evt.getPoint())) {
                if (!textBar.getShow()) {
                    if (!textBar.getText().isEmpty()) {
                        processing();
                    }
                } else {
                    textBar.close_searching();
                }
            }
        }
    }//GEN-LAST:event_textBarMousePressed

    private Thread thread;
    private void read1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_read1MousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (target != null && !target.isEmpty()) {
                if (thread != null) {
                    thread.interrupt();
                }
                thread = new Thread(() -> {
                    try {
                        controller.readMessage(target,
                                controller.getLanguageCode(languageSelect1.getText()));
                    } catch (IOException | JavaLayerException ex) {
                        JOptionPane.showMessageDialog(this, "Can't read Text");
                    }
                });
                
                thread.setDaemon(false);
                
                thread.start();
                
            }
        }
    }//GEN-LAST:event_read1MousePressed

    private void read2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_read2MousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (result != null && !result.isEmpty()) {
                if (thread != null) {
                    thread.interrupt();
                }
                thread = new Thread(() -> {
                    try {
                        controller.readMessage(result,
                                controller.getLanguageCode(languageSelect2.getText()));
                    } catch (IOException | JavaLayerException ex) {
                        JOptionPane.showMessageDialog(this, "Can't read Text");
                    }
                });
                
                thread.setDaemon(false);
                
                thread.start();
            }
        }
    }//GEN-LAST:event_read2MousePressed

    private void changeVisible(boolean visible) {
        jPanel2.setVisible(visible);
    }

    private void processing() {
        try {
            textBar.execute_searching();
            result = controller.translateWord(textBar.getText(),
                    controller.getLanguageCode(languageSelect1.getText()), 
                    controller.getLanguageCode(languageSelect2.getText()));
            Timer timer = new Timer(600, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Đoạn mã trong này sẽ được thực thi sau khi đợi (delay) kết thúc
                    if (textBar.getShow()) {
                        textBar.close_searching();
                        if (result != null) {
                            target = textBar.getText();
                            Language1.setData(target);
                            Language2.setData(result);
                            
                            changeVisible(false);
                            changeVisible(true);
                        }
                    }
                }
            });
            
            // Kích hoạt Timer để bắt đầu đợi
            timer.setRepeats(false);  // Đặt timer chỉ chạy một lần
            timer.start();
        } catch (IOException ex) {
            Logger.getLogger(TranslateGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.ControlPanel.Search.ResultBoard Language1;
    private GUI.ControlPanel.Search.ResultBoard Language2;
    private GUI.roundComponent.circleComponent iconTranslate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private GUI.ControlPanel.Translate.LanguagePanel languageSelect1;
    private GUI.ControlPanel.Translate.LanguagePanel languageSelect2;
    private GUI.roundComponent.Button read1;
    private GUI.roundComponent.Button read2;
    private GUI.ControlPanel.Search.TextFieldAnimation textBar;
    private javax.swing.JLabel transfer;
    // End of variables declaration//GEN-END:variables
}
