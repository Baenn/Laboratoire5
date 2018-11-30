package Laboratoire5;

import java.util.List;

public interface IMotDefinition {
    boolean addMotDefinition(MotDefinition m);
    boolean removeMotDefinition(MotDefinition m);


    List<MotDefinition> getMot(String m);
    List<MotDefinition> getAllMotDefinition();
}
