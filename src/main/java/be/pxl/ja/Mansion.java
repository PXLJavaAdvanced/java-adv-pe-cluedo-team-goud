package be.pxl.ja;

import java.util.List;
import java.util.Optional;

public class Mansion extends Assembly<Room> {

    private static final String HALL = "Hall";

    public Mansion(List<Room> assemblyParts) {
        super(assemblyParts);
    }

    public Room getHall() {
        return getPart(HALL)
                .orElseThrow(() -> new CluedoException("Every mansion must have a hall"));
    }

    public int getNumberOfRooms() {
        return getNumberOfParts();
    }

    public Optional<Room> getRoom(String room) {
        return getPart(room);
    }

    public Room getRoom(int room) {
        return getPart(room);
    }

    public List<Room> getRooms() {
        return getParts();
    }
}
