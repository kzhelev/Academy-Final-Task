package application.customexceptions;

public class ParseException extends Exception{

    public ParseException(String errorMessage){
        super(errorMessage);
    }
}
