package GUI.ControlPanel.Search;

import GUI.roundComponent.RoundedPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class SearchItem extends javax.swing.JPanel {

    public SearchItem(String data) {
        initComponents();
        setData(data);
    }

    private void setData(String data) {
        addEventMouse(this);
        addEventMouse(LText);
        LText.setText(data);
    }
    
    public void setIcon(String path) {
        if (path != null) {
            jLabel1.setIcon(new ImageIcon(path));
        }
    }

    public void setSelected(boolean act) {
        if (act) {
            setBackground(Color.WHITE);
        } else {
            setBackground(new Color(245, 242, 242));
        }
    }
    
    public String getText() {
        return LText.getText();
    }
    
    private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(245, 242, 242));
            }

        });
    }
    
    private ActionListener eventClick;
    public void addEvent(ActionListener eventClick) {
        this.eventClick = eventClick;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LText = new javax.swing.JLabel();

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setBackground(new java.awt.Color(245, 242, 242));

        jLabel1.setBackground(new java.awt.Color(245, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\huyho\\OneDrive\\Desktop\\Dictionary\\DictionaryCommandline\\src\\main\\java\\data\\img\\search_1.png")); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jLabel1.setMaximumSize(new java.awt.Dimension(18, 18));
        jLabel1.setMinimumSize(new java.awt.Dimension(18, 18));
        jLabel1.setPreferredSize(new java.awt.Dimension(18, 18));

        LText.setBackground(new java.awt.Color(245, 242, 242));
        LText.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        LText.setText("Text...");
        LText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LText, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(LText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LTextMouseClicked
        eventClick.actionPerformed(null);
    }//GEN-LAST:event_LTextMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbIcon;
    // End of variables declaration//GEN-END:variables
}
