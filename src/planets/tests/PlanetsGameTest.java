package planets.tests;

import javax.swing.JFrame;
import planets.DrawPanel;
import planets.Game;
import planets.PlanetsGame;

/**
 * // -------------------------------------------------------------------------
/**
 *  Test our planet game. I'm not quite sure how exactly to work this :/
 *
 *  @author carlos
 *  @version May 10, 2011
 */
public class PlanetsGameTest extends GameTest
{
    private PlanetsGame testGame;
    private JFrame frame;
    private DrawPanel drawPanel;

    public void setUp()
    {
        frame = new JFrame();
        drawPanel = new DrawPanel();
        frame.add(drawPanel);
        frame.setVisible(true);
        testGame = new PlanetsGame(640, 480, drawPanel);
        super.setUp();
    }

    protected Game getConcrete()
    {
        return testGame;
    }
}
