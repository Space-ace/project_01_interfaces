
package Object;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Exeption.WrongIlluminanceException;
import Exeption.WrongParametrException;
import Exeption.WrongSpaceException;

import Interface.Furniture;
import Interface.Things;
import Interface.Light;
/**
 *Класс описывающий комнату
 * @author USER
 */
public class Room
{
    String name;
    String buildingName; //Имя дома в котором содержитс комната, это нужно для исключений
    private float square,squareZanMax, squareZanMin=0;
    private int window;
    private int light;
    public ArrayList<Things> Frnt = new ArrayList<Things>(); //Лист хранящий объекты мебели
    public ArrayList<Things> bubl = new ArrayList<Things>(); //Лист хранящий объекты овсещения
    
    
    Room(String name, float square, int window, String bldName) throws WrongIlluminanceException
    {
        this.buildingName = bldName;
        this.name = name;
        this.square = square;
        this.window = window;
        this.light = window * 700;
            if(light > 4000) throw new WrongIlluminanceException("Интенсивность света больше 4000, комната ",buildingName ,name , " Окна " , light-4000);
    }
    
    
    /**
     * Метод добавления Предмета
     * @param furniture - общий для всех объектов интерфейс через который можно получить данныые об объекте 
     * @throws WrongIlluminanceException
     * @throws WrongSpaceException 
     */
    public void add(Things furniture) throws WrongIlluminanceException, WrongSpaceException, WrongParametrException
    {
        
        
        if(furniture instanceof  Light){
        try {
            //Проверка на введенный параметр, если он отрицательный генерируетс исключение
        if(((Light) furniture).getLight() < 0)
             throw new WrongParametrException("Интенсивность света не может быть отрицательной ",buildingName ,furniture.getName() ,name, ((Light) furniture).getLight());
        
        
        light = light + ((Light) furniture).getLight();//прибавляем к освещению освещение которое создает предмет
        if(light > 4000) {                            //Проверка на привышения лимита освещения
              float TempLight=light-4000;            //Переменная хранящая превышения лимита освещния для передачи её в ислючение
              light = light - ((Light) furniture).getLight();  //отнимаем от освещения освещение создаваемое предметом, так как исключение сообщит о том что превышен лимит нам это освещение не нужно
              throw new WrongIlluminanceException("Интенсивность света больше 4000, комната " ,buildingName ,  furniture.getName() ,name, TempLight);
              }
              this.bubl.add(furniture); //если проверка на свет прошла успешна добавляем в лист наш объект
        }
        catch(WrongParametrException ex) {
            Logger.getLogger(Armchair.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (WrongIlluminanceException ex) {
            Logger.getLogger(Armchair.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
        //Аналогичер предыдущему if
        if(furniture instanceof  Furniture)
        {
        try {
            //Проверка на введенный параметр, если он отрицательный генерируетс исключение
        if(((Furniture) ((Furniture) furniture)).getMaxSize()< 0)
        throw new WrongParametrException("размер не может быть отрицательным ",buildingName  , furniture.getName() ,name, ((Furniture) ((Furniture) furniture)).getMaxSize());   
        if(((Furniture) ((Furniture) furniture)).getMinSize()< 0)
        throw new WrongParametrException("размер не может быть отрицательным " ,buildingName , furniture.getName() ,name, ((Furniture) ((Furniture) furniture)).getMinSize());   
        
        
        
        squareZanMax = squareZanMax + ((Furniture) furniture).getMaxSize();
        squareZanMin = squareZanMin + ((Furniture) furniture).getMinSize();
        if(squareZanMax > square*0.7 || squareZanMin > square*0.7){
            float TempSize = (float) (squareZanMax - square*0.7);
            float TempSize1 = (float) (squareZanMin - square*0.7);
            if(squareZanMax > squareZanMin){
            squareZanMax = squareZanMax - ((Furniture) furniture).getMaxSize();
            squareZanMin = squareZanMin - ((Furniture) furniture).getMinSize();
              throw new WrongSpaceException("Занимаемая объектом площадь превышает доступную для комнаты площадь  ",buildingName  , furniture.getName(), name, TempSize);
            }
              else{
            squareZanMax = squareZanMax - ((Furniture) furniture).getMaxSize();
            squareZanMin = squareZanMin - ((Furniture) furniture).getMinSize();
               throw new WrongSpaceException("Занимаемая объектом площадь превышает доступную для комнаты площадь  ",buildingName  , furniture.getName(), name, TempSize1);               
            }
        }
        
        this.Frnt.add(furniture);
        }
        catch(WrongParametrException ex) {
            Logger.getLogger(Armchair.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (WrongSpaceException ex) {
            Logger.getLogger(Armchair.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
    
     
     //предоставляет информацию о комнате классу building
     public static void giveInfo(Room room) throws WrongIlluminanceException
     {
   
       try {
       System.out.println(room.name);
       if(room.light < 300)
            throw new WrongIlluminanceException("Интенсивность света меньше 300" , room.buildingName ,  room.name , 300-room.light);
       }
       catch (WrongIlluminanceException ex) {
            Logger.getLogger(Armchair.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       System.out.print("освещенность =" + room.light+ ", " + room.window +"окна, ламочки ");
       for (Things fr : room.bubl ) {
           System.out.print(((Light) fr).getLight() + "лк, ");
       }
      if(room.bubl.isEmpty())System.out.println(" нету ");

       
       System.out.println("Площадь = " + room.square + " (занято " + room.squareZanMin + " - " + room.squareZanMax + ")");
       System.out.println("Мебель:");
       
       int i=0;
       System.out.println("Стол:");
       for (Things fr : room.Frnt ) {
           if(fr instanceof  Table){
           i++;
           System.out.println(fr.getName() + " (площадь " + ((Table) fr).getMaxSize()+ ")");
           }
       }
       if(i==0) System.out.println(" нету ");i=0;
       
       
       System.out.println("Диван:");
       for (Things fr : room.Frnt ) {
           if(fr instanceof  Sofa)
           {
           i++;
          System.out.println(fr.getName() + " (площадь " + ((Sofa) fr).getMinSize()+" - "+ ((Sofa) fr).getMaxSize()+ ")");
           }
       }
       if(i==0) System.out.println(" нету ");i=0;
       
       
       System.out.println("Кресло:");
       for (Things fr : room.Frnt ) {
           if(fr instanceof  Armchair){
           i++;
           System.out.println(fr.getName() + " (площадь " + ((Armchair) fr).getMinSize()+" - "+ ((Armchair) fr).getMaxSize()+ ")");
           }
       }
       if(i==0) System.out.println(" нету ");i=0;
       
               System.out.println("");
    }
    
}
