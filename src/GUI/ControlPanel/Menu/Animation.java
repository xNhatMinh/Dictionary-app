package GUI.ControlPanel.Menu;

import java.awt.Dimension;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Animation {

    private final MenuItem item;
    private Animator animator;
    private TimingTarget target;

    public Animation(MenuItem item) {
        this.item = item;
        this.animator = new Animator(150);
        this.animator.setResolution(0);
    }

    public void mouseEnter() {
        stop();
        animator.removeTarget(target);
        target = new PropertySetter(item, "buttonSize", item.getButtonSize(), new Dimension(125, 60));
        animator.addTarget(target);
        animator.start();
    }

    public void mouseExit() {
        stop();
        animator.removeTarget(target);
        target = new PropertySetter(item, "buttonSize", item.getButtonSize(), new Dimension(100, 48));
        animator.addTarget(target);
        animator.start();
    }

    public void stop() {
        if (animator.isRunning()) {
            animator.stop();
        }
    }
}
