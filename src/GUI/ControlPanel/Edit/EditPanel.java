package GUI.ControlPanel.Edit;

import GUI.roundComponent.RoundedTextField;
import GUI.roundComponent.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import manageData.Datatype.WordExplain;
import net.miginfocom.swing.MigLayout;

public class EditPanel extends javax.swing.JPanel {
    private List<RoundedTextField> explains = new ArrayList<>();

    public EditPanel(int n) {
        initComponents();
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
        addexplain(n);
    }
    
    private JTextPane createTitle(String text) {
        JTextPane txt = new JTextPane();
        txt.setFont(new Font("sansserif", Font.BOLD | Font.ITALIC, 12));
        txt.setBackground(new Color(215,246,248));
        txt.setForeground(new Color(80, 80, 80));
        txt.setSelectionColor(new Color(150, 150, 150));
        txt.setBorder(null);
        txt.setEditable(false);
        txt.setText(text);
        return txt;
    }
    
    public void addexplain(int num) {
        for (int i = 0; i < num; i++) {
            int index = explains.size() / 2 + 1;
            RoundedTextField define = new RoundedTextField();
            define.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
            define.setHintText("Definition " + index + " ...");
            RoundedTextField meaning = new RoundedTextField();
            meaning.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
            meaning.setHintText("Meaning " + index + " ...");
            
            explains.add(define);
            explains.add(meaning);
        }
        panel.removeAll();
        panel.revalidate();
        
        for (int i = 0; i < explains.size(); i += 2) {
            panel.add(createTitle("Definition"), "growx, align left, w 100::90%, wrap");
            panel.add(explains.get(i), "growx, align left, w 100::90%, wrap, gaptop 10");
            panel.add(createTitle("Meaning"), "growx, align left, w 100::90%, wrap, gaptop 10");
            panel.add(explains.get(i + 1), "growx, align left, w 100::90%, wrap, gaptop 10");
        }
        panel.repaint(); 
    }
    
    public void addexplain(String def, String mean) {
        int index = explains.size() / 2 + 1;
        
        RoundedTextField define = new RoundedTextField();
        define.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        define.setHintText("Definition " + index + " ...");
        define.setText(def);
        
        RoundedTextField meaning = new RoundedTextField();
        meaning.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        meaning.setHintText("Meaning " + index + " ...");
        meaning.setText(mean);
        
        explains.add(define);
        explains.add(meaning);
        panel.removeAll();
        panel.revalidate();
        for (int i = 0; i < explains.size(); i += 2) {
            panel.add(createTitle("Definition"), "growx, align left, w 100::90%, wrap");
            panel.add(explains.get(i), "growx, align left, w 100::90%, wrap, gaptop 10");
            panel.add(createTitle("Meaning"), "growx, align left, w 100::90%, wrap, gaptop 10");
            panel.add(explains.get(i + 1), "growx, align left, w 100::90%, wrap, gaptop 10");
        }
        panel.repaint(); 
    }
    
    public String getType() {
        return Type.getText();
    }
    
    public void setType(String type) {
        Type.setText(type);
    }
    
    public List<WordExplain> getWordExplain() {
        List<WordExplain> rs = new ArrayList<>();
        String type = Type.getText();
        if (type.isBlank() || type.isEmpty()) {
            return null;
        }
        for (int i = 0; i < explains.size(); i += 2) {
            String def = explains.get(i).getText();
            String mean = explains.get(i + 1).getText();
            if (!def.isBlank() && !def.isEmpty()) {
                if (!mean.isBlank() && !mean.isEmpty()) {
                    rs.add(new WordExplain(type, def, mean));
                } else {
                    return null;
                }
            } else if (!mean.isBlank() && !mean.isEmpty()) {
                return null;
            }
        }
        return rs;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Type = new GUI.roundComponent.RoundedTextField();
        addMeaning = new GUI.roundComponent.Button();
        scrollPane = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        delMeaning = new GUI.roundComponent.Button();

        setBackground(new java.awt.Color(215, 246, 248));
        setOpaque(false);

        Type.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Type.setHintText("Type ...");

        addMeaning.setText("Add meaning");
        addMeaning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addMeaningMouseReleased(evt);
            }
        });

        scrollPane.setBackground(new java.awt.Color(215, 246, 248));
        scrollPane.setOpaque(false);

        panel.setBackground(new java.awt.Color(215, 246, 248));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panel);

        delMeaning.setText("Delete meaning");
        delMeaning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delMeaningMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addMeaningMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMeaningMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            addexplain(1);
        }
    }//GEN-LAST:event_addMeaningMouseReleased

    private void delMeaningMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delMeaningMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (explains.size() >= 4) {
                explains.remove(explains.size()-1);
                explains.remove(explains.size()-1);
                panel.removeAll();
                panel.revalidate();
                for (int i = 0; i < explains.size(); i += 2) {
                   panel.add(createTitle("Definition"), "growx, align left, w 100::90%, wrap");
                   panel.add(explains.get(i), "growx, align left, w 100::90%, wrap, gaptop 10");
                   panel.add(createTitle("Meaning"), "growx, align left, w 100::90%, wrap, gaptop 10");
                   panel.add(explains.get(i + 1), "growx, align left, w 100::90%, wrap, gaptop 10");
                }
                panel.repaint();                
            } 
        }
    }//GEN-LAST:event_delMeaningMouseReleased

    public void eventType(KeyAdapter event) {
        Type.addKeyListener(event);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.RoundedTextField Type;
    private GUI.roundComponent.Button addMeaning;
    private GUI.roundComponent.Button delMeaning;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
