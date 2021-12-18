package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Room;

public class RoomsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        boolean clueNotAdded = true;
        for (Room room : GameEngine.rooms){
            String roomName = room.getName();
            for (Part part : GameEngine.detective.collectedClues){
                if (room.getName().equals(part.getName()) && clueNotAdded){
                    roomName += " 0";
                    clueNotAdded = false;
                }
            }
            System.out.println(roomName);
        }
    }
}
