package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Room;

import java.util.Locale;

public class GoToCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Room room : GameEngine.rooms){
            if (input.equalsIgnoreCase(room.getName())){
                GameEngine.detective.moveTo(room);
            }
        }
    }
}
