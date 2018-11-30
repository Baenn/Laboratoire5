package Laboratoire5;

public class DefinitionException extends IllegalArgumentException {

    public DefinitionException(){
        super("Empty or null Definition are invalid");
    }

}
