package planets.tests.entity;

import planets.input.TestableKeyboard;
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
     * Ensure that vertical movement correctly corresponds to input
     */
    public void testUpdateUpDown()
    {
        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("up"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, testPlayer.getSpeed(), 0.0f),
                        testPlayer.getLocation());

        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("down"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f),
                        testPlayer.getLocation());
    }

    /**
     * Ensure that horizontal movement correctly corresponds to input
     */
    public void testUpdateLeftRight()
    {
        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("right"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(testPlayer.getSpeed(), 0.0f, 0.0f),
                        testPlayer.getLocation());

        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("left"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f),
                        testPlayer.getLocation());
    }

    /**
     * Ensure that depth movement correctly corresponds to input
     */
    public void testUpdateForwardBackward()
    {
        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("backward"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, 0.0f, testPlayer.getSpeed()),
                        testPlayer.getLocation());

        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("forward"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f),
                        testPlayer.getLocation());
    }

    /**
     * Ensure looking up and down correctly functions
     */
    public void testUpdateXRotation()
    {
        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("incline"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(-testPlayer.getTurnSpeed(), 0.0f, 0.0f),
                        testPlayer.getRotation());

        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("decline"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f),
                        testPlayer.getRotation());
    }

    /**
     * Ensure looking up and down correctly functions
     */
    public void testUpdateYRotation()
    {
        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("clockwise"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, testPlayer.getTurnSpeed(), 0.0f),
                        testPlayer.getRotation());

        TestableKeyboard.setKeyDown(testPlayer.getKeys().get("counterclockwise"));
        testPlayer.update();
        TestableKeyboard.clear();
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f),
                        testPlayer.getRotation());
    }
}
