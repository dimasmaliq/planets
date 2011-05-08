package planets.entity;

/**
 * // -------------------------------------------------------------------------
/**
 *  A set of methods defining actions a movable object might make in space
 *
 *  @author carlos
 *  @version May 8, 2011
 */
public interface MovementMeans
{
    /**
     * Moves the object forward in space
     */
    public void forward();

    /**
     * Moves the object left in space
     */
    public void strafeLeft();

    /**
     * Moves the object right in space
     */
    public void strafeRight();

    /**
     * Moves the object backward in space
     */
    public void backward();

    /**
     * Moves the object upward vertically in space
     */
    public void fly();

    /**
     * Moves the object downward vertically in space
     */
    public void sink();
}
