package GUI.roundComponent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RoundedTextField extends JTextField{

    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }

    private Color backgroundColor = Color.WHITE;
    private String hintText = "Search ...";
    

    public RoundedTextField() {
        super.setBackground(new Color(255, 255, 255, 0));
        setOpaque(false);
        setBorder(new EmptyBorder(10, 10, 10, 10)); //  Set Right border 50
        setSelectionColor(new Color(80, 199, 255));
        setCursor(new Cursor(Cursor.TEXT_CURSOR));  
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);    //  For smooth line
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, width, height, height, height);
        if (!hintText.equals("") && getText().length() == 0) {
            createHintText(g2);
        }
        g2.dispose();
        super.paintComponent(grphcs);
    }

    public void createHintText(Graphics2D g) {
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(hintText, ins.left, getHeight() / 2 + fm.getAscent() / 2 - 2);

    }

    @Override
    public void setBackground(Color color) {
        this.backgroundColor = color;
    }
}
