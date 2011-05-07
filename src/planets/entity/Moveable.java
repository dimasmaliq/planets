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
}
