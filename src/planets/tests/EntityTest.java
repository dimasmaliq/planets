package planets.tests;

import org.lwjgl.util.vector.Vector3f;
import planets.Entity;
import junit.framework.TestCase;

/**
 * // -------------------------------------------------------------------------
/**
 *  Ensures that Entity performs as expected
 *
 *  @author carlos
 *  @version May 3, 2011
 */
public abstract class EntityTest extends TestCase
{
    /**
     * An Entity to test against
     */
    private Entity testEntity;

    /**
     * Initialize Entity with a concrete object
     */
    public void setUp()
    {
        testEntity = getConcrete();
    }

    /**
     * Gets a concrete Entity object to test abstractly
     *
     * @return A concrete, allocated object extending Entity
     */
    protected abstract Entity getConcrete();

    /**
     * Tests the the location is retrieved correctly
     */
    public void testGetLocation()
    {
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f), testEntity.getLocation());
    }

    /**
     * Tests that location is set correctly
     */
    public void testSetLocation()
    {
        testEntity.setLocation(new Vector3f(1.0f, 1.0f, 1.0f ));
        assertEquals(new TestableVector3f(1.0f, 1.0f, 1.0f), testEntity.getLocation());
    }

    /**
     * Tests the the rotation is retrieved correctly
     */
    public void testGetRotation()
    {
        assertEquals(new TestableVector3f(0.0f, 0.0f, 0.0f), testEntity.getRotation());
    }

    /**
     * Tests that rotation is set correctly
     */
    public void testSetRotation()
    {
        testEntity.setRotation(new Vector3f(1.0f, 1.0f, 1.0f));
        assertEquals(new TestableVector3f(1.0f, 1.0f, 1.0f), testEntity.getRotation());
    }
}
