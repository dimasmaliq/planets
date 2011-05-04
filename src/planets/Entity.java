package planets;
import org.lwjgl.util.vector.Vector3f;

/**
 *  The most basic game-object. Contains methods and fields common to all
 *  objects in the game. All possible objects will have a location and an
 *  orientation, i.e. physical objects and trigger areas. Also, all objects
 *  will have a means of displaying themselves in-game, including invisible
 *  objects such as triggers or logic controllers for debugging purposes.
 *  All objects will have some means of thinking and interacting with
 *  the world around them.
 *
 *  @author carlos
 *  @version Apr 3, 2011
 */
public abstract class Entity
{
    /**
     * The location of the entity
     */
    private Vector3f location;

    /**
     * The rotation of the entity
     */
    private Vector3f rotation;

    /**
     * Create a new entity at the origin
     */
    public Entity()
    {
        setLocation(new Vector3f(0.0f, 0.0f, 0.0f));
        setRotation(new Vector3f(0.0f, 0.0f, 0.0f));
    }

    /**
     * Getter method for the location of the Entity
     * @return The location of the Entity
     */
    public Vector3f getLocation()
    {
        return location;
    }

    /**
     * Sets the Entity's location to a new location
     * @param location A new location
     */
    public void setLocation(Vector3f location)
    {
        this.location = location;
    }

    /**
     * Sets the rotation of the entity
     * @param rotation the rotation to set
     */
    public void setRotation(Vector3f rotation)
    {
        this.rotation = rotation;
    }

    /**
     * Gets the rotation of the entity
     * @return the rotation
     */
    public Vector3f getRotation()
    {
        return rotation;
    }
}
