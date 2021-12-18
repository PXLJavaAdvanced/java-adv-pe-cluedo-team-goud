package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Suspect;

public class SuspectsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Suspect suspect : GameEngine.suspects){
            System.out.println(suspect.getName());
        }
    }
}
