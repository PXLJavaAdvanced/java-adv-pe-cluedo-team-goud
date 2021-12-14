package be.pxl.ja;

import java.util.Optional;

public class Room extends Part{
    private Weapon weapon;
    private Suspect suspect;
    private boolean crimeScene;
    private boolean locked;

    public Room(String name) {
        super(name);
        locked = true;
    }

    public String describe(){
        return "";
    }

    public Optional<Suspect> getSuspect(){
        return null;
    }

    public Optional<Weapon> getWeapon(){
        return null;
    }

    public boolean isLocked(){
        return false;
    }

    public void setCrimeScene(boolean crimeScene){

    }

    public void setSuspect(Suspect suspect){

    }

    public void setWeapon(Weapon weapon){

    }

    public void unlock(){

    }
}
