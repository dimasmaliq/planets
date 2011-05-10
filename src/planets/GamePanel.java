package planets;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

// -------------------------------------------------------------------------
/**
 * The game panel is responsible for displaying the game.
 *
 * @author evant
 * @version May 1, 2011
 */
public class GamePanel
    extends JPanel
{
    private DrawPanel    drawPanel;
    private JLayeredPane layeredPane;
    private Thread       gameThread;
    private Game         game;

    private int          width;
    private int          height;

    private boolean      isRunning;


    // ----------------------------------------------------------
    /**
     * Constructs a new game panel.
     *
     * @param width
     *            the width of the game panel
     * @param height
     *            the height of the game panel
     */
    public GamePanel(int width, int height)
    {
        this.width = width;
        this.height = height;

        isRunning = false;

        setPreferredSize(new Dimension(width + 10, height + 10));

        drawPanel = new DrawPanel();
        drawPanel.setBounds(0, 0, width, height);
        drawPanel.setBackground(Color.blue);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(width, height));
        layeredPane.add(drawPanel, new Integer(0));

        add(layeredPane);
    }


    // ----------------------------------------------------------
    /**
     * Runs the game in the game panel.
     */
    public void run()
    {
        gameThread = new Thread() {
            public void run()
            {
                // Start the game
                game = new PlanetsGame(width, height, drawPanel);
                game.execute();
            }
        };
        gameThread.start();
        isRunning = true;
    }


    // ----------------------------------------------------------
    /**
     * Determines if the game is running.
     *
     * @return true if the game is running, false otherwise
     */
    public boolean isRunning()
    {
        return isRunning;
    }
}
