
package Main;

import Object.Armchair;
import Object.Bulb;
import Object.Sofa;
import Object.Table;
import Object.Building;
import Exeption.WrongIlluminanceException;
import Exeption.WrongParametrException;
import Exeption.WrongSpaceException;





public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WrongIlluminanceException, WrongSpaceException, WrongParametrException {
        try{ 
        Building build = new Building("House1");
       
        
        
        build.addRoom("room3", 400, 1);
        build.getRoom("room3").add(new Bulb("Лампочка",250));
        build.getRoom("room3").add(new Sofa("Диван",4,-220));
        build.getRoom("room3").add(new Table("Стол",20));
        build.describe();
        
        
        Building build1 = new Building("House2");
        build1.addRoom("room4", 400, 2);
        build1.getRoom("room4").add(new Bulb("Лампочка",300));
        build1.getRoom("room4").add(new Bulb("Лампочка1",3000));
        build1.getRoom("room4").add(new Sofa("Диван",260,280));
        
        build1.addRoom("room5", 400, 0);
        build1.getRoom("room5").add(new Bulb("Лампочка",300));
        build1.getRoom("room5").add(new Sofa("Диван",40,44));
        build1.getRoom("room5").add(new Table("Стол",20));
        build1.getRoom("room5").add(new Armchair("Кресло",40,40));
        
        
      
        
        build1.describe();
        
        }
        //Runtime исключение
        catch(RuntimeException e ){
           System.out.print("невеерынй входной параметр");
        }
        }
    }
    


