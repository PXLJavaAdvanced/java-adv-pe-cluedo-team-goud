package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Room;

public class GoToCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Room room : GameEngine.rooms){
            if (room.getName().equals(input)){
                GameEngine.detective.moveTo(room);
            }
        }
    }
}
