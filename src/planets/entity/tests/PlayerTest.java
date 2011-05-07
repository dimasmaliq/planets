package planets.entity.tests;

import planets.input.TestableKeyboard;
import org.lwjgl.input.Keyboard;
import planets.tests.TestableVector3f;
import org.lwjgl.util.vector.Vector3f;
import planets.entity.Player;
import planets.Entity;
import planets.tests.EntityTest;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the Player and it's movement
 *
 *  @author carlos
 *  @version May 7, 2011
 */
public class PlayerTest extends EntityTest
{
    private Player testPlayer;

    public void setUp()
    {
        testPlayer = new Player();
        super.setUp();
    }

    protected Entity getConcrete()
    {
        return testPlayer;
    }

    /**
     * Ensure that moving the player correctly sets his position
     */
    public void testMove()
    {
        testPlayer.move(new Vector3f(1.0f, 1.0f, 1.0f));
        assertEquals(new TestableVector3f(1.0f, 1.0f, 1.0f), testPlayer.getLocation());
    }

    /**
     * Ensure that rotating the player correctly sets his rotation
     */
    public void testRotate()
    {
        testPlayer.rotate(new Vector3f(1.0f, 1.0f, 1.0f));
        assertEquals(new TestableVector3f(1.0f, 1.0f, 1.0f), testPlayer.getRotation());
    }

    /**
     *
     */
    public void testUpdateLeftRight()
    {
        TestableKeyboard.setKeyDown(Keyboard.KEY_W);
        testPlayer.update();
    }
}
