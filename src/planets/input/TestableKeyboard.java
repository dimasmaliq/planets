package planets.input;

import java.util.Hashtable;
import org.lwjgl.input.Keyboard;

// -------------------------------------------------------------------------
/**
 * A testable keyboard class.
 *
 * @author Evan Tatarka
 * @version May 1, 2011
 */
public class TestableKeyboard
{
    private static Hashtable<Integer, Boolean> keyStates =
                                                             new Hashtable<Integer, Boolean>();


    // ----------------------------------------------------------
    /**
     * Returns whether or not the key is down, checks first for a set key an
     * then for the keyboard key. If the key is not set and the Keyboard has not
     * been created, it returns false.
     *
     * @param key
     *            the key to check
     * @return true if the key is down, false otherwise
     */
    public static boolean isKeyDown(int key)
    {
        if (keyStates.containsKey(key))
        {
            return keyStates.get(key);
        }
        else if (Keyboard.isCreated())
        {
            return Keyboard.isKeyDown(key);
        }
        else
        {
            return false;
        }
    }


    // ----------------------------------------------------------
    /**
     * Sets a key to be down.
     *
     * @param key
     *            the key to set
     */
    public static void setKeyDown(int key)
    {
        keyStates.put(key, true);
    }


    // ----------------------------------------------------------
    /**
     * Sets a key to be up.
     *
     * @param key
     *            the key to set
     */
    public static void setKeyUp(int key)
    {
        keyStates.put(key, false);
    }

    // ----------------------------------------------------------
    /**
     * Clears all custom key states.
     */
    public static void clear() {
        keyStates.clear();
    }
}
