
package Object;
import Interface.Things;
import Interface.Furniture;
/**
 *Класс описыающий диван
 * @author USER
 */
public class Sofa implements Furniture,Things{
    
    float sizeMin,sizeMax;
    String name;
    public Sofa(String Nm, float SMin, float Smax)
    {
        name = Nm;
        sizeMin = SMin;
        sizeMax = Smax;
    }
    @Override
    public float getMaxSize()
    {
        return sizeMax;
        
    }
    
    @Override
    public float getMinSize()
    {
        return sizeMin;
    }
    
    
    @Override
    public String getName()
    {
    return name;
    }
    }
