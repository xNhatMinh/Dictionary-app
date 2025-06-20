package GUI.ControlPanel.Menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class MenuItem extends JButton{
    private boolean selected = false;
    private boolean mousePress;

    public boolean isSelected() {
        return selected;
    }
    
    public void setSelected(boolean selected) {
        if (selected) {
            selectedColor = Color.WHITE;
            animation.mouseEnter();
        } else {
            selectedColor = new Color(245, 242, 242);
            animation.mouseExit();
        }
        this.selected = selected;
        repaint();
    }
    
    private final Animation animation;
    private Dimension buttonSize = new Dimension(100, 48);
    
    private Color selectedColor = new Color(245, 242, 242);

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Dimension getButtonSize() {
        return buttonSize;
    }

    public void setButtonSize(Dimension buttonSize) {
        this.buttonSize = buttonSize;
        repaint();
    }
    
    public MenuItem() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        animation = new Animation(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                if (!selected) {
                    selectedColor = Color.WHITE;
                    animation.mouseEnter();
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (!selected) {
                    selectedColor = new Color(245, 242, 242);
                    animation.mouseExit();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    mousePress = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    mousePress = false;
                }
            }
            
            
        });
        
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if (mousePress) {
            g2.setColor(selectedColor.darker());
        } else {
            g2.setColor(selectedColor);
        }
        
        int width = getWidth();
        int height = getHeight();
        int x = (width - buttonSize.width) / 2;
        int y = (height - buttonSize.height) / 2;
        int w = buttonSize.width;
        int h = buttonSize.height;
        g2.fill(new RoundRectangle2D.Double(x, y, w, h, h, h));
        g2.dispose();
        super.paintComponent(grphcs);
    }
}
