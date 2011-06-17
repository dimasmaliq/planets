package planets;

import java.util.LinkedList;

public abstract class Manager<T> extends Entity
{
    /**
     * Holds the items we're managing
     */
    private LinkedList<T> managed;

    /**
     * Adds an item to be managed
     * @param toAdd The item to add to the manager
     */
    public void add(T toAdd)
    {
        managed.add(toAdd);
    }

    /**
     * Removes a managed item
     * @param toRemove The item to remove from the manager
     */
    public void remove(T toRemove)
    {
        managed.remove(toRemove);
    }

    /**
     * Manages the items in the list, updates them every frame
     */
    public abstract void manage(T toManage, T other);

    public void update()
    {
        for(T item : managed)
        {
            for(T other : managed)
            {
                if(item != other)
                {
                    manage(item, other);
                }
            }
        }
    }
}
