package GUI.ControlPanel.Learn;

import GUI.ControlPanel.Search.EventClick;
import GUI.roundComponent.RoundedPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class TopicChoosePanel extends RoundedPanel {

    private JPopupMenu menu;
    private topicSuggestPanel suggestPanel;
    private List<String> topics = new ArrayList<>();

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    
    public int getChoose() {
        return topics.indexOf(topic.getText());
    }
    
    private boolean show = false;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    
    public void setMenuVisible(boolean show) {
        menu.setVisible(show);
    }
    
    public void setText(String language) {
        this.topic.setText(language);
    }
    
    public String getText() {
        return topic.getText();
    }
    
    public TopicChoosePanel() {
        initComponents();
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        menu = new JPopupMenu();
        suggestPanel = new topicSuggestPanel();

        menu.setBorder(BorderFactory.createLineBorder(new Color(245, 242, 242)));
        menu.add(suggestPanel);
        menu.setFocusable(false);
        suggestPanel.addEventClick(new EventClick() {
            @Override
            public void itemClick(String data) {
                topic.setText(data);
                menu.setVisible(false);
                show = false;
            }
        });
    }
    
    public void eventClickSugestPanel(EventClick e) {
        suggestPanel.addEventClick(e);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 242, 242));
        setRoundBottomLeft(20);
        setRoundBottomRight(20);
        setRoundTopLeft(20);
        setRoundTopRight(20);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        topic.setBackground(new java.awt.Color(245, 242, 242));
        topic.setFont(new java.awt.Font("SansSerif", 3, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("▼\t");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topic, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(topic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (show) {
                menu.setVisible(false);
                show = false;
            } else {
                suggestPanel.setSuggestData((ArrayList<String>) topics);
                if (suggestPanel.getItemSize() > 0) {
                    menu.show(this, 0, getHeight());
                    menu.setPopupSize(getWidth(), (suggestPanel.getItemSize() * 35) + 2);
                    menu.setVisible(true);
                    show = true;
                }
            }
        }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel topic;
    // End of variables declaration//GEN-END:variables
}
