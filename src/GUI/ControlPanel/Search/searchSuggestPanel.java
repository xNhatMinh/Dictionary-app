package GUI.ControlPanel.Search;

import GUI.roundComponent.RoundedPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import net.miginfocom.swing.MigLayout;

public class searchSuggestPanel extends RoundedPanel {
    private EventClick event;
    private int SelectedIndex = -1;
    private String pathIcon;
    
    public void setPathIcon(String pathIcon) {
        this.pathIcon = pathIcon;
    }
    
    public void addEventClick(EventClick event) {
        this.event = event;
    }

    public searchSuggestPanel() {
        super(10, 10, 10, 10);
        initComponents();
        setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }

    public void setSuggestData(ArrayList<String> data) {
        SelectedIndex = -1;
        showSelected();
        this.removeAll();
        int cnt = 0;
        for (String d : data) {
            if (cnt >= 8) break; // max of suggest can show
            
            SearchItem item = new SearchItem(d);
            item.setIcon(pathIcon);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when click
                    event.itemClick(d);
                }
            });
            this.add(item, "wrap");
            //  wrap mean add to new row after this add
            cnt++;
        }
        repaint();
        revalidate();
        //  Refresh Component
    }
    
    public int getItemSize() {
        return getComponentCount();
    }
    
    public void keyUp() {
        int size = getComponentCount();
        if (size > 0) {
            if (SelectedIndex <= 0) {
                SelectedIndex = size-1;
            } else {
                SelectedIndex--;
            }
            showSelected();
        }
    }
    
    public void keyDown() {
        int size = getComponentCount();
        if (size > 0) {
            if (SelectedIndex >= size-1) {
                SelectedIndex = 0;
            } else {
                SelectedIndex++;
            }
            showSelected();
        }
    }
    
    private void showSelected() {
        Component com[] = getComponents();
        for (int i = 0; i < com.length; i++) {
            ((SearchItem)com[i]).setSelected(i == SelectedIndex);
        }
    }
    
    public String getSelectedText() {
        if (SelectedIndex != -1 && SelectedIndex < getComponentCount()) {
            return ((SearchItem)getComponent(SelectedIndex)).getText();
        }
        return "";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
