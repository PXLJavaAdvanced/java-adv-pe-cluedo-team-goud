package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Suspect;

public class SuspectsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Suspect suspect : GameEngine.suspects){
            for (Part part : GameEngine.detective.collectedClues){
                if (suspect.getName().equals(part.getName())){
                    System.out.println(suspect.getName() + " 0");
                }
            }
            System.out.println(suspect.getName());
        }
    }
}
