package planets;

import javax.swing.JFrame;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector2f;
import java.io.File;
import java.io.IOException;
import org.lwjgl.input.Keyboard;

// -------------------------------------------------------------------------
/**
 * A game that simply draws a sphere to that rotates when you use the mouse.
 *
 * @author Evan Tatarka (evant)
 * @author trev
 * @version Apr 2, 2011
 */
public class PlanetsGame
    extends Game
{
    private GameState     gameState;
    private Camera        camera;

    private boolean       showingTriggerText;
    private boolean       keyPressed;

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
        ControlPanel controlPanel = new ControlPanel();

        frame.setJMenuBar(controlPanel);

        frame.getContentPane().add(gamePanel);

        frame.pack();
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.run();
    }

    // ----------------------------------------------------------
    /**
     * Create a new MyGame object.
     *
     * @param width
     *            the width of the game
     * @param height
     *            the height of the game
     * @param drawPanel
     *            the panel to draw the game on in windowed mode
     * @param textLabel
     *            the GameText
     */
    public PlanetsGame(int width, int height, DrawPanel drawPanel)
    {
        super(width, height, drawPanel);
    }


    @Override
    public void load()
    {
        gameState = new GameState();
        camera = new Camera();

        loadActors();
        loadTriggers();
    }


    @Override
    public void update(long gameTime)
    {
        camera.setLocation(new Vector3f(0.0f, 0.0f, 0.0f));
    }


    @Override
    public void draw()
    {
        camera.draw();
        Sphere sphere = new Sphere();
        GL11.glPushMatrix();
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            sphere.setDrawStyle(GLU.GLU_LINE);
            sphere.draw(1.0f, 32, 32);
        GL11.glPopMatrix();
    }


    private void loadActors()
    {

    }


    private void loadTriggers()
    {
    }
}
