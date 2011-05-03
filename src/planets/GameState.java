package planets;

import java.util.LinkedList;

// -------------------------------------------------------------------------
/**
 * The Game State. Manages what events have occurred.
 *
 * @author evant
 * @version Apr 30, 2011
 */
public class GameState
{
    private LinkedList<String> events = new LinkedList<String>();


    // ----------------------------------------------------------
    /**
     * Add an event to the game state.
     *
     * @param event
     *            the event
     * @throws DuplicateEventException
     *             when the event has already be added
     */
    public void addEvent(String event)
    {
        if (events.contains(event))
        {
            throw new DuplicateEventException(
                "This event has already been added");
        }

        events.add(event);
    }


    // ----------------------------------------------------------
    /**
     * Determines if an event has be added to the GameState.
     *
     * @param event
     *            the event to check
     * @return true if the event has been added, false otherwise.
     */
    public boolean eventOccured(String event)
    {
        return events.contains(event);
    }


    // -------------------------------------------------------------------------
    /**
     * Throws this exception if an event has already been added.
     *
     * @author evant
     * @version May 1, 2011
     */
    public class DuplicateEventException
        extends RuntimeException
    {
        // ----------------------------------------------------------
        /**
         * Create a new DuplicateEventException object.
         *
         * @param message
         *            the message
         */
        public DuplicateEventException(String message)
        {
            super(message);
        }
    }
}
