
package Object;

import Interface.Furniture;
import Interface.Things;
import Interface.Furniture;



/**
 * Класс описываюзий кресло
 * @author USER
 */
public class Armchair implements Furniture,Things{
    
    private float sizeMax,sizeMin;
    private String name;
    public Armchair(String Name, float SMin, float SMax)
    {
        name = Name;
        sizeMin = SMin;
        sizeMax = SMax;
    }
    @Override
    public float getMinSize()
    {
        return sizeMin;
    }
    
    
    @Override
    public float getMaxSize()
    {
        return sizeMax;
    }
    
    @Override
    public String getName()
    {
    return name;
    }
    
}
