package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Room room : GameEngine.rooms){
            boolean isClue = false;
            for (Part part : GameEngine.detective.collectedClues){
                if (room.getName().equalsIgnoreCase(part.getName())){
                    System.out.println(room.getName() + " 0");
                    isClue = true;
                }
            }
            if (!isClue){
                System.out.println(room.getName());
            }
        }
    }
}
