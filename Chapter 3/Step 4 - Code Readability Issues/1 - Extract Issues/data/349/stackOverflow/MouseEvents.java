
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MouseEvents extends Applet implements MouseListener, MouseMotionListener {

    String msg = "";                        // I am not implementing those methods which
    int mouseX = 0, mouseY = 0;             // are not related to my question

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mouseEntered(MouseEvent me) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse Entered";
        repaint();
    }

    public void mouseMoved(MouseEvent me) {
        int currentMouseX = me.getX();
        int currentMouseY = me.getY();
        showStatus("Moving mouse at " + currentMouseX + ", " + currentMouseY);
    }

    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }
}
