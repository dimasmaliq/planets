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
    /**
     * The rotation of the camera
     */
    private Vector3f rotation;

    // ----------------------------------------------------------
    /**
     * Create a new Camera object.
     */
    public Camera()
    {
        super();
        rotation = new Vector3f(0.0f, 0.0f, 0.0f);
    }

    /**
     * Getter method for the rotation of the Entity
     * @return The rotation of the Entity
     */
    public Vector3f getRotation()
    {
        return rotation;
    }

    // ----------------------------------------------------------
    /**
     * Sets the rotation of the entity.
     * @param rotationX the x rotation
     * @param rotationY the y rotation
     * @param rotationZ the z rotation
     */
    public void setRotation(float rotationX, float rotationY, float rotationZ)
    {
        rotation.x = rotationX;
        rotation.y = rotationY;
        rotation.z = rotationZ;
    }

    // ----------------------------------------------------------
    /**
     * Returns the x rotation of the object.
     *
     * @return the x rotation
     */
    public float getRotationX()
    {
        return rotation.getX();
    }


    // ----------------------------------------------------------
    /**
     * Sets the x rotation of the object.
     *
     * @param x
     *            the x rotation
     */
    public void setRotationX(float x)
    {
        rotation.setX(x);
    }


    /**
     * Returns the y rotation of the object.
     *
     * @return the y rotation
     */
    public float getRotationY()
    {
        return rotation.getY();
    }


    /**
     * Sets the y rotation of the object.
     *
     * @param y
     *            the y rotation
     */
    public void setRotationY(float y)
    {
        rotation.setY(y);
    }


    /**
     * Returns the z rotation of the object.
     *
     * @return the z rotation
     */
    public float getRotationZ()
    {
        return rotation.getZ();
    }


    /**
     * Sets the z rotation of the object.
     *
     * @param z
     *            the z rotation
     */
    public void setRotationZ(float z)
    {
        rotation.setZ(z);
    }

    public void draw()
    {
        GL11.glRotatef(getRotationX(), 1, 0, 0);
        GL11.glRotatef(getRotationY(), 0, 1, 0);
        GL11.glRotatef(getRotationZ(), 0, 0, 1);
        GL11.glTranslatef(-getLocation().getX(), -getLocation().getY(), -1);
    }
}
