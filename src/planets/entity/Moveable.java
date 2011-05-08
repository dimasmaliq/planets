package planets.entity;

import org.lwjgl.util.vector.Vector3f;

/**
 * // -------------------------------------------------------------------------
/**
 *  Describes an object that can move through the world
 *
 *  @author carlos
 *  @version May 3, 2011
 */
public interface Moveable
{
    /**
     * Moves the object around in the world
     * @param delta How much the object should move
     */
    public void move(Vector3f delta);

    /**
     * Rotates the object in the world
     * @param delta How much the object should rotate
     */
    public void rotate(Vector3f delta);

    /**
     * Gets the object's location
     * @return the object's location
     */
    public Vector3f getLocation();

    /**
     * Set the object's location
     * @param location the object's new location
     */
    public void setLocation(Vector3f location);

    /**
     * Gets the  object's rotation
     * @return The object's rotation
     */
    public Vector3f getRotation();

    /**
     * Sets the object's rotation
     * @param rotation the object's new rotation
     */
    public void setRotation(Vector3f rotation);

    /**
     * Gets the speed at which the moveable can move
     * @return The object's movement speed
     */
    public float getSpeed();
}
