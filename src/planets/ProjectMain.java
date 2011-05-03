package planets;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Sets up and contains all of the panels for the game and control. Also runs
 * the game
 *
 * @author carlos
 * @version Apr 1, 2011
 */
public class ProjectMain
{

    /**
     * The driver for the game
     *
     * @param args
     *            Command-line arguments
     */
    public static final void main(String[] args)
    {
        JFrame frame = new JFrame();

        GamePanel gamePanel = new GamePanel(800, 600);

        frame.getContentPane().add(gamePanel);

        frame.pack();
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.run();
    }
}
