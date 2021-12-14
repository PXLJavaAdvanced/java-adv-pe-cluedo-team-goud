package be.pxl.ja;

import java.util.List;

public class Detective {

    private final String name;
    private Room currentRoom;
    private List<Part> collectedClues;

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
