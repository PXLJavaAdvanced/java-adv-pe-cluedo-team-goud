package be.pxl.ja;

import java.util.Optional;
import java.util.TreeSet;

public class Assembly<T extends Part> {
    private TreeSet<T> assemblyParts;

    public int getNumberOfParts(){
        return assemblyParts.size();
    }

    public Optional<T> getPart(String obj){

    }

    public T getPart(int obj){

    }

    public <T> getParts(){

    }

    public Assembly(TreeSet<T> assemblyParts) {
        this.assemblyParts = assemblyParts;
    }
}
