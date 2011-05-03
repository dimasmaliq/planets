package planets;

import planets.Entity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

// -------------------------------------------------------------------------
/**
 *  Defines the camera position and rotation.
 *
 *  @author evant
 *  @version Apr 15, 2011
 */
public class Camera
    extends Entity
{
    // ----------------------------------------------------------
    /**
     * Create a new Camera object.
     */
    public Camera()
    {
        super();
    }

    public void draw()
    {
        GL11.glRotatef(getRotation().getX(), 1, 0, 0);
        GL11.glRotatef(getRotation().getY(), 0, 1, 0);
        GL11.glRotatef(getRotation().getZ(), 0, 0, 1);
        GL11.glTranslatef(-getLocation().getX(), -getLocation().getY(), -getLocation().getZ());
    }
}
