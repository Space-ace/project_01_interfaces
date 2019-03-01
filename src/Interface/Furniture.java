
package Interface;
import Interface.Things;
/**
 *
 * @author USER
 */

//Интерфейс опысывающий мебель
public interface Furniture extends Things{
    /**
     *Метод возращающий размер сложенного предмета 
     * @return 
     */
     float getMinSize();
     
     /**
      * Метод возращающий размер разложенного предмета
      * @return 
      */
     float getMaxSize();
}
