package be.pxl.ja;

import java.util.ArrayList;
import java.util.List;

public class Detective {

    private final String name;
    private Room currentRoom;
    public List<Part> collectedClues = new ArrayList<>(1);

    public Detective(String name) {
        this.name = name;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void moveTo(Room nextRoom) {
        if (nextRoom.equals(currentRoom)) {
            throw new CluedoException("This move is not allowed");
        }
        currentRoom = nextRoom;
    }
}
