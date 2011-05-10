package planets.tests;

import planets.Game;
import org.lwjgl.LWJGLException;
import junit.framework.TestCase;

/**
 * // -------------------------------------------------------------------------
/**
 *  Ensure that the Game objects perform correctly
 *
 *  @author carlos
 *  @version May 10, 2011
 */
public abstract class GameTest extends TestCase
{
    /**
     * The game to test against
     */
    private Game testGame;

    public void setUp()
    {
        testGame = getConcrete();
    }

    /**
     * Gets a concrete object to test with
     * @return A non-abstract Game object
     */
    protected abstract Game getConcrete();

    /**
     * Make sure execution correctly proceeds
     */
    public void testExecute()
    {
        Exception occurred = null;

        try
        {
            testGame.execute();
        }
        catch(Exception e)
        {
            occurred = e;
        }
        assertNull(occurred);
        assertFalse(occurred instanceof LWJGLException);
    }
}
