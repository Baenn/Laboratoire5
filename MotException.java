package Laboratoire5;

public class MotException extends IllegalArgumentException {

    public MotException(){
        super("Empty or null Mot are invalid");
    }
}
