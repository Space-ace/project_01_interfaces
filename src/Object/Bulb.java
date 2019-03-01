
package Object;

import Interface.Things;
import Interface.Light;
/**
 *Класс описывающий лампочку
 * @author USER
 */
public class Bulb implements Light,Things{
    int light;
    String name;
    public Bulb(String name, int Light) 
    {
        this.name = name;
        light = Light;
    }
    @Override
    public int getLight()
    {
        return light;
    }
    
    
    @Override
    public String getName()
    {
    return name;
    }
}


