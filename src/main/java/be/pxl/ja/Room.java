package be.pxl.ja;

import java.util.Optional;

public class Room extends Part {

    // use of static final to avoid changing multiple strings in case the separator needs to be different
    private static final String SEPARATOR = "\n";

    private Weapon weapon;
    private Suspect suspect;
    private boolean crimeScene;
    private boolean locked;

    public Room(String name) {
        super(name);
        this.locked = true;
    }

    public String describe() {
        if (locked) {
            throw new RoomLockedClientException();
        }

        StringBuilder description = new StringBuilder();

        if (crimeScene) {
            description.append("There's blood in this room");
        } else {
            description.append("There's no blood in this room");
        }

        getWeapon().map(Part::getName) // get the name in case the weapon is not empty
                .ifPresent(name -> description.append(SEPARATOR).append(name)); // if the name is present, add it to the description

        getSuspect().map(Part::getName) // get the name in case the suspect is not empty
                .ifPresent(name -> description.append(SEPARATOR).append(name)); // if the name is present, add it to the description

        return description.toString();
    }

    public Optional<Suspect> getSuspect() {
        return Optional.ofNullable(suspect);
    }

    public Optional<Weapon> getWeapon() {
        return Optional.ofNullable(weapon);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setCrimeScene(boolean crimeScene) {
        this.crimeScene = crimeScene;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void removeSuspect() {
        this.suspect = null;
    }

    public void unlock() {
        this.locked = false;
    }
}
