package GUI.ControlPanel.Learn;

import GUI.ControlPanel.Search.EventClick;
import GUI.ControlPanel.Search.SearchItem;
import GUI.roundComponent.RoundedPanel;
import GUI.roundComponent.ScrollBarCustom;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import net.miginfocom.swing.MigLayout;

public class topicSuggestPanel extends RoundedPanel {
    private EventClick event;
    private int SelectedIndex = -1;
    
    public topicSuggestPanel() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setHorizontalScrollBar(null);
        jPanel1.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }
    
    public void addEventClick(EventClick event) {
        this.event = event;
    }
    
    public void setSuggestData(ArrayList<String> data) {
        SelectedIndex = -1;
        showSelected();
        jPanel1.removeAll();
        for (String d : data) {
            
            SearchItem item = new SearchItem(d);
            item.setIcon(null);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when click
                    event.itemClick(d);
                }
            });
            jPanel1.add(item, "wrap");
            //  wrap mean add to new row after this add
        }
        repaint();
        revalidate();
        //  Refresh Component
    }
    
    public int getItemSize() {
        return jPanel1.getComponentCount();
    }
    
    private void showSelected() {
        Component com[] = jPanel1.getComponents();
        for (int i = 0; i < com.length; i++) {
            ((SearchItem)com[i]).setSelected(i == SelectedIndex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setRoundBottomLeft(10);
        setRoundBottomRight(10);
        setRoundTopLeft(10);
        setRoundTopRight(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
