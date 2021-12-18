package be.pxl.ja.command;

import be.pxl.ja.*;

public class ClueCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Part part : GameEngine.parts){
            if (input.equalsIgnoreCase(part.getName())){
                GameEngine.detective.collectedClues.add(part);
            }
        }
    }
}
