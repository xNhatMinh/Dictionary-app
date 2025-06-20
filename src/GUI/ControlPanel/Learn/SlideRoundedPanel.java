package GUI.ControlPanel.Learn;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class SlideRoundedPanel extends javax.swing.JPanel {

    public SlideRoundedPanel() {
        initComponents();
        listComponent = new ArrayList<>();
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
            }
        });
        
    }

    private List<Component> listComponent;
    private final Timer timer;
    private Component comExit;
    private Component comShow;
    private int currentShowing;
    private boolean animateRight;
    private final int speed = 20;
    
    public int getCurrentShowing() {
        return currentShowing;
    }
    
    public Component getCurrentComponent() {
        return listComponent.get(currentShowing);
    }
    
    public void addComponent(Component ...com) {
        if (com.length > 0) {
            for (Component c : com) {
                listComponent.add(c);
                c.setSize(getSize());
                c.setVisible(false);
                this.add(c);
            }
        }
    }
    public void addComponent(List<Component> com) {
        if (!com.isEmpty()) {
            for (Component c : com) {
                listComponent.add(c);
                c.setSize(getSize());
                c.setVisible(false);
                this.add(c);
            }
        }
    }
    
    public void startShow() {
        if (!listComponent.isEmpty()) {
            for(Component c : listComponent) {
                c.setSize(getSize());
            }
            Component show = listComponent.get(0);
            show.setVisible(true);
            show.setLocation(0, 0);
            currentShowing = 0;
        }
    }
    
    public void clear() {
        removeAll();
        revalidate();
        listComponent.clear();
    }
    
    public void show(int index) throws IndexOutOfBoundsException {
        if (!timer.isRunning()) {
            if (listComponent.size() >= 2 && index != currentShowing) {
                comShow = listComponent.get(index);
                comExit = listComponent.get(currentShowing);
                animateRight = index < currentShowing;
                currentShowing = index;
                comShow.setVisible(true);
                if (animateRight) {
                    comShow.setLocation(-comShow.getWidth(), 0);
                } else {
                    comShow.setLocation(getWidth(), 0);
                }
                timer.start();
            }
        }
    }
    
    private void animate() {
        if (animateRight) {
            if (comShow.getLocation().x < 0) {
                comShow.setLocation(comShow.getLocation().x + speed, 0);
                comExit.setLocation(comExit.getLocation().x + speed, 0);
            } else {//stop slide animation
                comShow.setLocation(0, 0);
                timer.stop();
                comExit.setVisible(false);
            }
        } else {
            if (comShow.getLocation().x > 0) {
                comShow.setLocation(comShow.getLocation().x - speed, 0);
                comExit.setLocation(comExit.getLocation().x - speed, 0);
            } else {
                comShow.setLocation(0, 0);
                timer.stop();
                comExit.setVisible(false);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
