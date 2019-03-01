
package Object;

import Interface.Things;
import Interface.Furniture;
/**
 *Класс описывающий стол
 * @author USER
 */
public class Table implements Furniture,Things{
    float size;
    String name;
    public Table(String Nm, float sz)
    {
        name = Nm;
        size = sz;
    }
    @Override
    public float getMaxSize()
    {
        return size;
    }
    
    
    @Override
    public float getMinSize()
    {
        return size;
    }
    
    @Override
    public String getName()
    {
    return name;
    }
}