package planets;

import planets.Entity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

// -------------------------------------------------------------------------
/**
 *  Defines the camera position and rotation.
 *
 *  @author carlos
 *  @version May 7, 2011
 */
public class Camera
    extends Entity
{
    /**
     * An Entity to be attached to
     */
    private Entity follow;

    // ----------------------------------------------------------
    /**
     * Create a new Camera object.
     */
    public Camera()
    {
        super();
        follow = null;
    }

    /**
     * Set the entity to follow
     * @param toFollow The entity that this will follow
     */
    public Camera(Entity toFollow)
    {
        super();
        follow = toFollow;
    }

    /**
     * Draw the object
     */
    public void draw()
    {
        GL11.glRotatef(getRotation().getX(), 1, 0, 0);
        GL11.glRotatef(getRotation().getY(), 0, 1, 0);
        GL11.glRotatef(getRotation().getZ(), 0, 0, 1);
        GL11.glTranslatef(-getLocation().getX(), -getLocation().getY(), -getLocation().getZ());
    }

    @Override
    public void update()
    {
        if(follow != null)
        {
            setLocation(follow.getLocation());
        }
    }
}
