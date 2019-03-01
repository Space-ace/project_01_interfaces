
package Exeption;

/**
 *
 * @author Исключение ввода параметра с "-"
 */
public class WrongParametrException extends Exception{
    public WrongParametrException(String message,String houseName, String name,String room, float space){
        super(message+ ",Дом: " + houseName +", комната "+ room + " ,предмет " + name + ", значение : " + space);
    }
    }
