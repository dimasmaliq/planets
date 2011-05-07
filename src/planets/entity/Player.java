package planets.entity;

import planets.tests.TestableKeyboard;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.input.Keyboard;
import planets.Entity;

/**
 * // -------------------------------------------------------------------------
/**
 *  Controls and contains the state of the user. Closely attached with
 *  the camera.
 *
 *  @author carlos
 *  @version May 3, 2011
 */
public class Player extends Entity implements Moveable
{
    public void update()
    {
        handleInput();
    }

    public void move(Vector3f delta)
    {
        Vector3f loc = getLocation();
        setLocation(new Vector3f(loc.getX() + delta.getX(),
                                 loc.getY() + delta.getY(),
                                 loc.getZ() + delta.getZ()));
    }

    public void rotate(Vector3f delta)
    {
        Vector3f rot = getRotation();
        setRotation(new Vector3f(rot.getX() + delta.getX(),
                                 rot.getY() + delta.getY(),
                                 rot.getZ() + delta.getZ()));
    }

    /**
     * Moves the player when the wasd or the arrow keys are pressed
     */
    private void handleInput()
    {
        /**
         * Up and Down
         */
        if(TestableKeyboard.isKeyDown(Keyboard.KEY_W))
        {
            move(new Vector3f(0.0f, .10f, 0.0f));
        }
        else if(TestableKeyboard.isKeyDown(Keyboard.KEY_S))
        {
            move(new Vector3f(0.0f, -.10f, 0.0f));
        }

        /**
         * Left and Right
         */
        if(TestableKeyboard.isKeyDown(Keyboard.KEY_A))
        {
            move(new Vector3f(-.10f, 0.0f, 0.0f));
        }
        else if(TestableKeyboard.isKeyDown(Keyboard.KEY_D))
        {
            move(new Vector3f(.10f, 0.0f, 0.0f));
        }

        /**
         * Forward and Backward
         */
        if(TestableKeyboard.isKeyDown(Keyboard.KEY_Q))
        {
            move(new Vector3f(0.0f, 0.0f, -.10f));
        }
        else if(TestableKeyboard.isKeyDown(Keyboard.KEY_E))
        {
            move(new Vector3f(0.0f, 0.0f, .10f));
        }

        /**
         * Look left and right
         */
        if(TestableKeyboard.isKeyDown(Keyboard.KEY_LEFT))
        {
            rotate(new Vector3f(0.0f, -.10f, 0.0f));
        }
        else if(TestableKeyboard.isKeyDown(Keyboard.KEY_RIGHT))
        {
            rotate(new Vector3f(0.0f, 0.10f, 0.0f));
        }

        /**
         * Look Up and Down
         */
        if(TestableKeyboard.isKeyDown(Keyboard.KEY_UP))
        {
            rotate(new Vector3f(-.10f, 0.0f, 0.0f));
        }
        else if(TestableKeyboard.isKeyDown(Keyboard.KEY_DOWN))
        {
            rotate(new Vector3f(0.10f, 0.0f, 0.0f));
        }
    }
}
