
package Object;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Exeption.WrongIlluminanceException;
import Exeption.WrongParametrException;

/**
 *Класс описывающий здание
 * @author USER
 */
public class Building
{
    private String name;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    
    
    public Building(String name)
    {
        this.name = name;
    }
    
    
    /**
     * Метод добавления комнаы
     * @param RName - имя комнаты
     * @param RSquare - площадь комнаты
     * @param RIllumination - количество окон в команате
     */
    public void addRoom(String RName, int RSquare, int RIllumination) throws WrongParametrException 
    {
        try {
             if(RSquare < 0) throw new WrongParametrException("Площадь не может быть отрицательной",name , " площадь " ,RName ,RSquare);
             if(RIllumination < 0 ) throw new WrongParametrException("Количество окон не может быть отрицательной ",RName ,", Окна " ,name , RIllumination);
             
             
             rooms.add(new Room(RName,RSquare,RIllumination,name));
        }
        catch (WrongIlluminanceException ex) {
            Logger.getLogger(Building.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Метод изьятия объекта комнаты по названию
     * @param RName - имя комнаты
     * @return 
     */
    public Room getRoom(String RName) 
    {
        for (Room room : rooms) {
            if(room.name.equals(RName))
            {
              return room;
            }
       }
       System.out.println("Такой комнаты не существует");
       return null;
    }
    
    
    /**
     * Метод выводы информации о здании
     * @throws WrongIlluminanceException 
     */
    public void describe() throws WrongIlluminanceException
    {
       System.out.println("Дом: "+name);
       for (Room room : rooms) {
           Room.giveInfo(room);
       }
       
    }
    
}