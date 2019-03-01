
package Interface;

import Interface.Things;
/**
 *
 * @author USER
 */


//Интерфейс опысывающий предметы освещенния(лампочки)
public interface Light extends Things
{
        /**
         * Метод возращающий Свет который исходит из светящегося предмета в лк
         */
     int getLight();
}
