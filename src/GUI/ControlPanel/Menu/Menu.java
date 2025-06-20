package GUI.ControlPanel.Menu;

import java.awt.event.MouseAdapter;

public class Menu extends javax.swing.JPanel {

    public Menu() {
        initComponents();
        lookup.setSelected(true);
    }

    public void unSelectAll() {
        lookup.setSelected(false); //0
        translate.setSelected(false); //1
        addword.setSelected(false); //2
        learn.setSelected(false); //3
        export.setSelected(false); //4
    }
    
    public void setSelectedItem(int item) {
        switch (item) {
            case 0 -> //controlPanel.LOOKUP
                lookup.setSelected(true);
            case 1 -> //controlPanel.TRANSLATE
                translate.setSelected(true);
            case 2 -> //controlPanel.LEARN
                learn.setSelected(true);
            case 3 -> //controlPanel.EXPORT
                export.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lookup = new GUI.ControlPanel.Menu.MenuItem();
        translate = new GUI.ControlPanel.Menu.MenuItem();
        addword = new GUI.ControlPanel.Menu.MenuItem();
        learn = new GUI.ControlPanel.Menu.MenuItem();
        export = new GUI.ControlPanel.Menu.MenuItem();

        setBackground(new java.awt.Color(29, 42, 87));
        setForeground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        lookup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/look up.png"))); // NOI18N
        lookup.setText("Look up");
        lookup.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        translate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/translate.png"))); // NOI18N
        translate.setText("Translate");
        translate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        addword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/add.png"))); // NOI18N
        addword.setText("Add Word");
        addword.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        learn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/learn.png"))); // NOI18N
        learn.setText("Learn");
        learn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/export.png"))); // NOI18N
        export.setText("Export");
        export.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lookup, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(translate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(addword, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(learn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lookup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(translate, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(addword, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(learn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void eventAdd(MouseAdapter event) {
        addword.addMouseListener(event);
    }
    
    public void eventLookup(MouseAdapter event) {
        lookup.addMouseListener(event);
    }
    
    public void eventTranslate(MouseAdapter event) {
        translate.addMouseListener(event);
    }
    
    public void eventLearn(MouseAdapter event) {
        learn.addMouseListener(event);
    }
    
    public void eventExport(MouseAdapter event) {
        export.addMouseListener(event);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.ControlPanel.Menu.MenuItem addword;
    private GUI.ControlPanel.Menu.MenuItem export;
    private GUI.ControlPanel.Menu.MenuItem learn;
    private GUI.ControlPanel.Menu.MenuItem lookup;
    private GUI.ControlPanel.Menu.MenuItem translate;
    // End of variables declaration//GEN-END:variables
}
