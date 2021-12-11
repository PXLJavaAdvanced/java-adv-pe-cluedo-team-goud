package be.pxl.ja;

public class Suspect extends Part {
    private String title;
    private String occupation;
    private String nationality;
    private int age;

    public Suspect(String name) {
        super(name);
    }

    public int getAge(){
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return title + ", " + this.getName();
    }
}
