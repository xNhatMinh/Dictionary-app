package GUI.roundComponent;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GradientRoundedPanel extends RoundedPanel {
    public GradientRoundedPanel() {
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#000046"), 0, getHeight(), Color.decode("#1CB5E0"));
        g2.setPaint(gp);
        g2.fill(getArea());
        g2.dispose();
    }
    
    
}
