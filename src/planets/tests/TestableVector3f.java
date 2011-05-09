package planets.tests;

import org.lwjgl.util.vector.Vector3f;

/**
 * // -------------------------------------------------------------------------
/**
 *  A wrapper class created for ease of testing against Vector3f's. smh
 *
 *  @author carlos
 *  @version May 3, 2011
 */
public class TestableVector3f
    extends Vector3f
{
    private static final float THRESHOLD = .002f;

    /**
     * Just instantiate the superclass version normally
     * @param x The X component of the Vector
     * @param y The Y component of the Vector
     * @param z The Z component of the Vector
     */
    public TestableVector3f(float x, float y, float z)
    {
        super(x, y, z);
    }

    /**
     * Compares a a vector3f by the value of its components.
     * Apparently the LWJGL implementation compares by reference?
     *
     * @param other Another object to compare equality with
     * @return Whether this Vector3f's components are equal to another's
     */
    public boolean equals(Object other)
    {
        if(other instanceof Vector3f)
        {
            Vector3f vecRef = (Vector3f)other;
            if(Math.abs(vecRef.getX() - getX()) < THRESHOLD &&
                Math.abs(vecRef.getY() - getY()) < THRESHOLD &&
                Math.abs(vecRef.getZ() - getZ()) < THRESHOLD)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
