package planets.tests.entity;

import planets.tests.TestableVector3f;
import org.lwjgl.util.vector.Vector3f;
import planets.entity.Player;
import planets.Entity;
import planets.entity.Camera;
import planets.tests.EntityTest;

/**
 * // -------------------------------------------------------------------------
/**
 *  Ensure that the camera correctly displays the world and follows
 *  its target.
 *
 *  @author carlos
 *  @version May 9, 2011
 */
public class CameraTest extends EntityTest
{
    private Camera camera;

    public void setUp()
    {
        camera = new Camera();
        super.setUp();
    }

    public Entity getConcrete()
    {
        return camera;
    }

    /**
     * Ensure that following works correctly
     */
    public void testFollow()
    {
        Entity player = new Player();

        camera = new Camera(player);
        player.setLocation(new Vector3f(1.0f, 1.0f, 1.0f));

        camera.update();

        assertEquals(new TestableVector3f(1.0f, 1.0f, 1.0f), camera.getLocation());
    }

    /**
     * Ensure that not following an entity works as well
     */
    public void testUpdate()
    {
        camera.update();
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f), camera.getLocation());
    }
}
