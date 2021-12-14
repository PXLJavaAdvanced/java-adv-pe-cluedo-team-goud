package be.pxl.ja;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.TreeSet;

public class Assembly<T extends Part> {
    private ArrayList<T> assemblyParts;

    public int getNumberOfParts(){
        return assemblyParts.size();
    }

    public Optional<Part> getPart(String name){
        for (Part part : assemblyParts){
            if (part.getName().equals(name)){
                return Optional.of(part);
            }
        }
        return Optional.empty();
    }

    public T getPart(int index){
        return assemblyParts.get(index);
    }

    public <T> getParts(){

    }
}
