package be.pxl.ja;

public abstract class Part {
    private final String name;

    public Part(String name){
        this.name = name;
    }

    public boolean equals(Object part){
        return (this.toString().equals(part.toString()));
    }

    public String getName(){
        return name;
    }

    public int hashCode(){
        return 0;
    }

    public String ToString(){
        return name;
    }
}
