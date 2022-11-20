package Exceptions;

public class InvalidFileFormatException extends Exception{

    public String getMessage(){
        return "Please provide a .txt file!";
    }
}
