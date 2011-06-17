package planets;

import org.lwjgl.util.vector.Vector3f;

/**
 * // -------------------------------------------------------------------------
/**
 *  Describes an object which may come into contact with other objects
 *
 *  @author carlos
 *  @version May 19, 2011
 */
public interface Collidable
{
    /**
     * Checks if this object contacts another object
     * @param other The object to check
     * @return Whether this collides with the other object
     */
    public boolean collidesWith(Collidable other);

    /**
     * Fired when an object does come into contact with another
     */
    public void collide();

    /**
     * Gets the angle and speed at which the object contacted the other
     * @return The vector of collision
     */
    public Vector3f getCollisionVector();
}
