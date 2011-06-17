package planets;

import org.lwjgl.util.vector.Vector3f;

public interface Physicsable
{
    public void applyForce(Vector3f force);

    public void applyTorque(Vector3f force, Vector3f location);

    public Vector3f getCenterOfMass();

    public float getMass();

    public Vector3f getVelocity();

    public void setVelocity(Vector3f velocity);

    public Vector3f getAngularVelocity();

    public void setAngularVelocity(Vector3f angularVelocity);

    public Vector3f getAcceleration();

    public Vector3f getAngularAcceleration();

    public float getSpeed();

    public float getInertia();
}
