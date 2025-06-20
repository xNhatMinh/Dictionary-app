package GUI.ControlPanel;

import GUI.roundComponent.GradientRoundedPanel;
import GUI.roundComponent.RoundedPanel;
import java.awt.event.MouseAdapter;

public class controlPanel extends GradientRoundedPanel {
    public static int LOOKUP = 0;
    public static int TRANSLATE = 1;
    public static int LEARN = 2;
    public static int EXPORT = 3;

    public controlPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new GUI.roundComponent.circleComponent();
        Tiltle = new javax.swing.JLabel();
        circleComponent1 = new GUI.roundComponent.circleComponent();
        button1 = new GUI.roundComponent.Button();
        menu = new GUI.ControlPanel.Menu.Menu();

        setBackground(new java.awt.Color(29, 42, 87));
        setRoundBottomLeft(40);
        setRoundBottomRight(40);

        Logo.setBackground(new java.awt.Color(254, 236, 166));
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/logo.png"))); // NOI18N
        Logo.setOpaque(true);

        Tiltle.setFont(new java.awt.Font("Imprint MT Shadow", 3, 40)); // NOI18N
        Tiltle.setForeground(new java.awt.Color(255, 255, 255));
        Tiltle.setText("Vortaro Dictionary");
        Tiltle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        circleComponent1.setBackground(new java.awt.Color(255, 255, 255));

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/exit.png"))); // NOI18N
        button1.setText("Exit");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        circleComponent1.add(button1);
        button1.setBounds(20, 30, 70, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circleComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(circleComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button1ActionPerformed

    
    public void setSelect(int item) {
        menu.unSelectAll();
        menu.setSelectedItem(item);
    }
    
    public void eventLookupGUI(MouseAdapter event) {
        menu.eventLookup(event);
    }
    
    public void eventTranslateGUI(MouseAdapter event) {
        menu.eventTranslate(event);
    }
    
    public void eventAddGUI(MouseAdapter event) {
        menu.eventAdd(event);
    }
    
    public void eventLearnGUI(MouseAdapter event) {
        menu.eventLearn(event);
    }
    
    public void eventExportGUI(MouseAdapter event) {
        menu.eventExport(event);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.circleComponent Logo;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.Button button1;
    private GUI.roundComponent.circleComponent circleComponent1;
    private GUI.ControlPanel.Menu.Menu menu;
    // End of variables declaration//GEN-END:variables
}
