package planets;

/**
 * // -------------------------------------------------------------------------
/**
 *  Checks all of the existing entities for collision. It's more useful when you
 *  have physics implemented
 *
 *  @author carlos
 *  @version May 27, 2011
 */
public class CollisionManager extends Manager<Collidable>
{
    public void manage(Collidable toManage, Collidable other)
    {
        if(toManage.collidesWith(other))
        {
            toManage.collide();
            other.collide();
        }
    }
}
