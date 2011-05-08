package planets.entity;

import org.lwjgl.util.vector.Vector3f;

public class FlyMovement implements MovementMeans
{
    private Moveable toMove;

    /**
     * Create a movement profile controlling a moveable
     * @param toMove the Moveable to control
     */
    public FlyMovement(Moveable toMove)
    {
        this.toMove = toMove;
    }

    /**
     * Moves the object forward in space
     */
    public void forward()
    {
        double yaw = Math.toRadians(toMove.getRotation().getY());
        float speed = toMove.getSpeed();
        float xMovement = -speed * (float)Math.sin(yaw);
        float zMovement = speed * (float)Math.cos(yaw);
        toMove.move(new Vector3f(-xMovement, 0.0f, -zMovement));
    }

    /**
     * Moves the object backward in space
     */
    public void backward()
    {
        double yaw = Math.toRadians(toMove.getRotation().getY());
        float speed = toMove.getSpeed();
        float xMovement = speed * (float)Math.sin(yaw);
        float zMovement = -speed * (float)Math.cos(yaw);
        toMove.move(new Vector3f(-xMovement, 0.0f, -zMovement));
    }

    /**
     * Moves the object left in space
     */
    public void strafeLeft()
    {
        double yaw = Math.toRadians(toMove.getRotation().getY());
        float speed = toMove.getSpeed();
        float xMovement = -speed * (float)Math.sin(yaw-Math.PI/2);
        float zMovement = speed * (float)Math.cos(yaw-Math.PI/2);
        toMove.move(new Vector3f(-xMovement, 0.0f, -zMovement));
    }

    /**
     * Moves the object right in space
     */
    public void strafeRight()
    {
        double yaw = Math.toRadians(toMove.getRotation().getY());
        float speed = toMove.getSpeed();
        float xMovement = -speed * (float)Math.sin(yaw+Math.PI/2);
        float zMovement = speed * (float)Math.cos(yaw+Math.PI/2);
        toMove.move(new Vector3f(-xMovement, 0.0f, -zMovement));

    }

    /**
     * Moves the object upward vertically in space
     */
    public void fly()
    {
        toMove.move(new Vector3f(0.0f, toMove.getSpeed(), 0.0f));
    }

    /**
     * Moves the object downward vertically in space
     */
    public void sink()
    {
        toMove.move(new Vector3f(0.0f, -toMove.getSpeed(), 0.0f));
    }
}
