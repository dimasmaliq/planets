package planets;

import planets.tests.TestableVector3f;
import org.lwjgl.util.vector.Vector3f;

public abstract class PhysicsObject extends Entity implements Physicsable
{
    private float mass;

    private Vector3f velocity;

    private Vector3f angularVelocity;

    private Vector3f acceleration;

    private Vector3f angularAcceleration;

    public PhysicsObject()
    {
        velocity = new Vector3f(0.0f, 0.0f, 0.0f);
        angularVelocity = new Vector3f(0.0f, 0.0f, 0.0f);
        acceleration = new Vector3f(0.0f, 0.0f, 0.0f);
        angularAcceleration = new Vector3f(0.0f, 0.0f, 0.0f);
    }

    public void applyForce(Vector3f force)
    {
        Vector3f forceAcceleration = new Vector3f(force.getX()/getMass(),
                                                    force.getY()/getMass(),
                                                    force.getZ()/getMass());
        acceleration = TestableVector3f.add(acceleration, forceAcceleration);
    }

    public void applyTorque(Vector3f force, Vector3f location)
    {
        // TODO Auto-generated method stub

    }

    public Vector3f getCenterOfMass()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public float getMass()
    {
        return mass;
    }

    public Vector3f getVelocity()
    {
        return velocity;
    }

    public void setVelocity(Vector3f velocity)
    {
        this.velocity = velocity;
    }

    public Vector3f getAngularVelocity()
    {
        return angularVelocity;
    }

    public void setAngularVelocity(Vector3f angularVelocity)
    {
        this.angularVelocity = angularVelocity;
    }

    public Vector3f getAcceleration()
    {
        return acceleration;
    }

    @Override
    public Vector3f getAngularAcceleration()
    {
        return angularAcceleration;
    }

    @Override
    public float getSpeed()
    {
        return getVelocity().length();
    }

    public float getInertia()
    {
        return getSpeed()*getMass();
    }

    public void update()
    {
        setLocation(TestableVector3f.add(getLocation(), getVelocity()));
        setVelocity(TestableVector3f.add(getVelocity(), getAcceleration()));

        setRotation(TestableVector3f.add(getRotation(), getAngularVelocity()));
        setAngularVelocity(TestableVector3f.add(getAngularVelocity(), getAngularAcceleration()));
    }

}
