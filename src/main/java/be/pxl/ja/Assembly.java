package be.pxl.ja;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Assembly<T extends Part> {
    private List<T> assemblyParts;

    public Assembly(List<T> assemblyParts) {
        this.assemblyParts = assemblyParts;
    }

    public int getNumberOfParts() {
        return assemblyParts.size();
    }

    public Optional<T> getPart(String name) {
        return assemblyParts.stream() // loop over assemblyParts
                .filter(assemblyPart -> name.equals(assemblyPart.getName())) // if name = assemblyPart name
                .findFirst(); // return the first that matches the if statement
    }

    public T getPart(int index) {
        return assemblyParts.get(index);
    }

    public List<T> getParts() {
        return assemblyParts.stream()
                .sorted(Comparator.comparing(Part::getName))
                .collect(Collectors.toList());
    }
}
