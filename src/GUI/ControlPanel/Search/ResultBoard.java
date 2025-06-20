package GUI.ControlPanel.Search;

import GUI.roundComponent.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class ResultBoard extends javax.swing.JPanel {

    public ResultBoard() {
        initComponents();
        setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
    }
    
    public void setData(ArrayList<String> data) {
        panel.removeAll();
        panel.revalidate();
        for (int i = 0; i < data.size(); i++) {
            JTextPane txt = new JTextPane();
            txt.setBackground(Color.WHITE);
            txt.setFont(new Font("sansserif", 1, 20));
            txt.setForeground(new Color(80, 80, 80));
            txt.setSelectionColor(new Color(150, 150, 150));
            txt.setBorder(null);
            txt.setOpaque(false);
            txt.setEditable(false);
            txt.setText("•      " + data.get(i));
            panel.add(txt, "growx, align left, w 100::90%, wrap, gaptop 10");
        }
        panel.repaint();
    }
    
    public void setData(String data) {
        panel.removeAll();
        panel.revalidate();
        JTextPane txt = new JTextPane();
        txt.setBackground(Color.WHITE);
        txt.setFont(new Font("sansserif", 1, 22));
        txt.setForeground(new Color(80, 80, 80));
        txt.setSelectionColor(new Color(150, 150, 150));
        txt.setBorder(null);
        txt.setOpaque(false);
        txt.setEditable(false);
        txt.setText(data);
        panel.add(txt, "growx, align left, w 100::95%, wrap, gaptop 10");
        panel.repaint();
    }
    
    public void addData(String s1, String s2) {
        JTextPane txt1 = new JTextPane();
        txt1.setBackground(Color.WHITE);
        txt1.setFont(new Font("sansserif", 2, 18));
        txt1.setForeground(new Color(0,51,153));
        txt1.setSelectionColor(new Color(150, 150, 150));
        txt1.setBorder(null);
        txt1.setOpaque(false);
        txt1.setEditable(false);
        txt1.setText("  -  " + s1);
        
        JTextPane txt2 = new JTextPane();
        txt2.setBackground(Color.WHITE);
        txt2.setFont(new Font("sansserif", 1, 22));
        txt2.setForeground(new Color(80, 80, 80));
        txt2.setSelectionColor(new Color(150, 150, 150));
        txt2.setBorder(null);
        txt2.setOpaque(false);
        txt2.setEditable(false);
        txt2.setText("      •   " + s2);
        panel.add(txt1, "growx, align left, w 100::95%, wrap, gaptop 10");
        panel.add(txt2, "growx, align left, w 100::95%, wrap, gaptop 10");
    }

    public void scrollToTop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jScrollPane1.getVerticalScrollBar().setValue(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setAutoscrolls(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
