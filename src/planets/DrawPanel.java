package planets;
import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JPanel;

/**
 * Contains the GUI elements for the game
 *
 * @author carlos
 * @version Mar 31, 2011
 */
public class DrawPanel
    extends JPanel
{

    /** The Canvas where the LWJGL Display is added */
    private Canvas displayParent;

    /**
     * Set up the panel and initialize it. Add a canvas, which we
     * will use later as the drawing area for graphic elements
     */
    public DrawPanel()
    {
        setLayout(new BorderLayout());

        displayParent = new Canvas();
        displayParent.setSize(getWidth(), getHeight());

        add(displayParent);

        displayParent.setFocusable(true);
        displayParent.requestFocus();
        displayParent.setIgnoreRepaint(true);

        setVisible(true);
    }

    /**
     * Getter method for displayParent. Allows other classes to use this
     * as a canvas for drawing LWJGL elements
     * @return The canvas of the DrawPanel
     */
    public Canvas getCanvas()
    {
        return displayParent;
    }
}
