package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Room;

public class RoomsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Room room : GameEngine.rooms){
            System.out.println(room.getName());
        }
    }
}
