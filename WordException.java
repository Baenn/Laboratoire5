package Laboratoire5;

public class WordException extends IllegalArgumentException {

    public WordException(){
        super("Empty or null Mot are invalid");
    }
}
