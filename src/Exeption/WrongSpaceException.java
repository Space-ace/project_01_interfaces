
package Exeption;

/**
 Исключение превышения площади предметом 70% площади комнаты
 * @author USER
 */

public class WrongSpaceException extends Exception{
    public WrongSpaceException(String message,String houseName, String name,String room, float space){
        super(message + ",Дом: " + houseName +", комната "+ room + " ,предмет " + name + ", уменьшите размер предмета на " + space);
    }
}
