package Laboratoire5;


import java.util.Comparator;

public class MotDefinitionComparator implements Comparator<MotDefinition> {

    @Override
    public int compare(MotDefinition o1, MotDefinition o2) {
       return o1.getMot().compareTo(o2.getMot());
    }
}
