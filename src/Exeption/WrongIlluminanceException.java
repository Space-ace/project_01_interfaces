
package Exeption;

/**
 *Исключение превышения освещённости в 4000 и недостатка в 300
 * @author USER
 */

public class WrongIlluminanceException extends Exception{
    public WrongIlluminanceException(String message,String houseName, String name,String room, float space){
        super(message + ",Дом: " + houseName+ ", Комната: " + room + " ,предмет " + name + ", уменьшите освещенность предмета на " + space);
    }
     public WrongIlluminanceException(String message,String houseName, String name,int space){
        super(message+ ",Дом: " + houseName +", Комната: " + name +" , Увеличьте освещенность на " +  space);
    }
}
