package GUI.ControlPanel.Learn;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class Question extends javax.swing.JPanel {

    private String hint = "--Click here to get a hint for this question--";
    private String QuestionMeaning;
    private boolean showHint;
    private String CorrectAns;
    private boolean showAns;
    
    public void restart() {
        Hint();
        showAns = false;
        ans1.setBackground(new Color(254,239,184));
        ans2.setBackground(new Color(254,239,184));
        ans3.setBackground(new Color(254,239,184));
        ans4.setBackground(new Color(254,239,184));
        repaint();
    }
    
    private void showHint() {
        meaning.setFont(new Font("SansSerif", Font.PLAIN, 18));
        meaning.setText(QuestionMeaning);
        showHint = true;
    }
    
    private void Hint() {
        meaning.setFont(new Font("SansSerif", Font.ITALIC, 14));
        meaning.setText(hint);
        showHint = false;
    }
    
    public Question(String def, String type, String meaning, String correctAns, String wrongAns1, String wrongAns2, String wrongAns3) {
        initComponents();
        
        ans1.setBackground(new Color(254,239,184));
        ans2.setBackground(new Color(254,239,184));
        ans3.setBackground(new Color(254,239,184));
        ans4.setBackground(new Color(254,239,184));
        
        this.def.setText("<html><div style='width: 425px; text-align: center;'>" + def + "</div></html>");

//        this.def.setText(def);
        this.type.setText(type);
        
        QuestionMeaning = meaning;
        
        this.CorrectAns = correctAns;
        List<String> ans = new ArrayList<>();
        ans.add(CorrectAns);
        ans.add(wrongAns1);
        ans.add(wrongAns2);
        ans.add(wrongAns3);
        
        Collections.shuffle(ans);
        
        ans1.setText(ans.get(0));
        ans2.setText(ans.get(1));
        ans3.setText(ans.get(2));
        ans4.setText(ans.get(3));
        
        restart();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ans3 = new GUI.roundComponent.Button();
        ans4 = new GUI.roundComponent.Button();
        roundedPanel1 = new GUI.roundComponent.RoundedPanel();
        def = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        meaning = new javax.swing.JLabel();
        ans1 = new GUI.roundComponent.Button();
        ans2 = new GUI.roundComponent.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        ans3.setText("button1");
        ans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans3ActionPerformed(evt);
            }
        });

        ans4.setText("button2");
        ans4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans4ActionPerformed(evt);
            }
        });

        roundedPanel1.setBackground(new java.awt.Color(254, 239, 184));
        roundedPanel1.setRoundBottomLeft(30);
        roundedPanel1.setRoundBottomRight(30);
        roundedPanel1.setRoundTopLeft(30);
        roundedPanel1.setRoundTopRight(30);

        def.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        def.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        def.setText("Definition");
        def.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        def.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        def.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        type.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type.setText("jLabel2");

        meaning.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        meaning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meaning.setText("jLabel3");
        meaning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meaningMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(def, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meaning, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(def, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(meaning, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        ans1.setBackground(new java.awt.Color(255, 255, 255));
        ans1.setText("button3");
        ans1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans1ActionPerformed(evt);
            }
        });

        ans2.setText("button4");
        ans2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ans3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(ans1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ans2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ans4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ans1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(ans2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ans4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(ans3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void meaningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meaningMouseClicked
        if (showHint) {
            Hint();
        } else {
            showHint();
        }
    }//GEN-LAST:event_meaningMouseClicked

    public void showCorrectAns() {
        if (showAns) {
            return;
        }
        if (ans1.getText().equals(CorrectAns)) {
            ans1.setBackground(new Color(175,252,137));
        } else if (ans2.getText().equals(CorrectAns)) {
            ans2.setBackground(new Color(175,252,137));
        } else if (ans3.getText().equals(CorrectAns)) {
            ans3.setBackground(new Color(175,252,137));
        } else {
            ans4.setBackground(new Color(175,252,137));
        }
        showAns = true;
        repaint();
    }
    private void ans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans1ActionPerformed
        if (showAns) {
            return;
        }
        if (ans1.getText().equals(CorrectAns)) {
            ans1.setBackground(new Color(175,252,137));
            showAns = true;
        } else {
            ans1.setBackground(new Color(249,118,72));
            showCorrectAns();
        }
        showHint();
    }//GEN-LAST:event_ans1ActionPerformed

    private void ans2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans2ActionPerformed
        if (showAns) {
            return;
        }
        if (ans2.getText().equals(CorrectAns)) {
            ans2.setBackground(new Color(175,252,137));
            showAns = true;
        } else {
            ans2.setBackground(new Color(249,118,72));
            showCorrectAns();
        }
        showHint();
    }//GEN-LAST:event_ans2ActionPerformed

    private void ans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans3ActionPerformed
        if (showAns) {
            return;
        }
        if (ans3.getText().equals(CorrectAns)) {
            ans3.setBackground(new Color(175,252,137));
            showAns = true;
        } else {
            ans3.setBackground(new Color(249,118,72));
            showCorrectAns();
        }
        showHint();
    }//GEN-LAST:event_ans3ActionPerformed

    private void ans4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans4ActionPerformed
        if (showAns) {
            return;
        }
        if (ans4.getText().equals(CorrectAns)) {
            ans4.setBackground(new Color(175,252,137));
            showAns = true;
        } else {
            ans4.setBackground(new Color(249,118,72));
            showCorrectAns();
        }
        showHint();
    }//GEN-LAST:event_ans4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button ans1;
    private GUI.roundComponent.Button ans2;
    private GUI.roundComponent.Button ans3;
    private GUI.roundComponent.Button ans4;
    private javax.swing.JLabel def;
    private javax.swing.JLabel meaning;
    private GUI.roundComponent.RoundedPanel roundedPanel1;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
