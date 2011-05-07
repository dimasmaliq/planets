package planets.tests;

import planets.SampleEntity;
import planets.Entity;

public class SampleEntityTest
    extends EntityTest
{
    protected Entity getConcrete()
    {
        return new SampleEntity();
    }
}