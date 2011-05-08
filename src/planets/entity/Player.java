package planets.entity;

import java.util.HashMap;
import planets.input.TestableKeyboard;
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
    /**
     * How fast the player moves
     */
    private float speed;

    /**
     * How fast the player rotates
     */
    private float turnSpeed;

    /**
     * The keybindings to actions.
     */
    private HashMap<String, Integer> keys;

    /**
     * Controls how the player moves
     */
    private MovementMeans movement;

    /**
     * A good speed for the player to move at the start
     */
    private static final float DEFAULT_SPEED = .10f;

    /**
     * A good speed for the player to turn at the start
     */
    private static final float DEFAULT_TURNSPEED = 1.0f;

    /**
     * Make a new player
     */
    public Player()
    {
        super();
        speed = DEFAULT_SPEED;
        turnSpeed = DEFAULT_TURNSPEED;
        movement = new FlyMovement(this);
        keys = getDefaultKeys();
    }


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
        if(TestableKeyboard.isKeyDown(keys.get("up")))
        {
            movement.fly();
        }
        else if(TestableKeyboard.isKeyDown(keys.get("down")))
        {
            movement.sink();
        }

        /**
         * Left and Right
         */
        if(TestableKeyboard.isKeyDown(keys.get("left")))
        {
            movement.strafeLeft();
        }
        else if(TestableKeyboard.isKeyDown(keys.get("right")))
        {
            movement.strafeRight();
        }

        /**
         * Forward and Backward
         */
        if(TestableKeyboard.isKeyDown(keys.get("forward")))
        {
            movement.forward();
        }
        else if(TestableKeyboard.isKeyDown(keys.get("backward")))
        {
            movement.backward();
        }

        /**
         * Look left and right
         */
        if(TestableKeyboard.isKeyDown(keys.get("counterclockwise")))
        {
            rotate(new Vector3f(0.0f, -turnSpeed, 0.0f));
        }
        else if(TestableKeyboard.isKeyDown(keys.get("clockwise")))
        {
            rotate(new Vector3f(0.0f, turnSpeed, 0.0f));
        }

        /**
         * Look Up and Down
         */
        if(TestableKeyboard.isKeyDown(keys.get("incline")))
        {
            rotate(new Vector3f(-turnSpeed, 0.0f, 0.0f));
        }
        else if(TestableKeyboard.isKeyDown(keys.get("decline")))
        {
            rotate(new Vector3f(turnSpeed, 0.0f, 0.0f));
        }
    }

    /**
     * Gets how fast the player can move
     * @return the speed at which the player moves
     */
    public float getSpeed()
    {
        return speed;
    }

    /**
     * Get how fast the player can turn
     * @return the speed at which the player turns
     */
    public float getTurnSpeed()
    {
        return turnSpeed;
    }

    /**
     * Get the default keys that move the player around
     * @return the default key bindings
     */
    public HashMap<String, Integer> getDefaultKeys()
    {
        HashMap<String, Integer> keyMap = new HashMap<String, Integer>();
        keyMap.put("forward", Keyboard.KEY_E);
        keyMap.put("backward", Keyboard.KEY_Q);

        keyMap.put("up", Keyboard.KEY_W);
        keyMap.put("down", Keyboard.KEY_S);

        keyMap.put("left", Keyboard.KEY_A);
        keyMap.put("right", Keyboard.KEY_D);

        keyMap.put("clockwise", Keyboard.KEY_RIGHT);
        keyMap.put("counterclockwise", Keyboard.KEY_LEFT);

        keyMap.put("incline", Keyboard.KEY_UP);
        keyMap.put("decline", Keyboard.KEY_DOWN);

        return keyMap;
    }

    /**
     * Get the player's current keybindings
     * @return the current keybindings
     */
    public HashMap<String, Integer> getKeys()
    {
        return keys;
    }
}
