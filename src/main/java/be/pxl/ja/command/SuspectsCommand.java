package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Room;
import be.pxl.ja.Suspect;

public class SuspectsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Suspect suspect : GameEngine.suspects) {
            boolean isClue = false;
            for (Part part : GameEngine.detective.collectedClues) {
                if (suspect.getName().equalsIgnoreCase(part.getName())) {
                    System.out.println(suspect.getName() + " 0");
                    isClue = true;
                }
            }
            if (!isClue) {
                System.out.println(suspect.getName());
            }
        }
    }
}
