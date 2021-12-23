package be.pxl.ja.command;

import be.pxl.ja.*;

public class ClueCommand implements Command<String>{
    @Override
    public void execute(String input) {
        boolean containsClue = false;

        // controle op dubbele ingave
        for (Part part : GameEngine.detective.collectedClues){
            if (input.equalsIgnoreCase(part.getName())){
                System.out.println("Deze clue heb je al doorgegeven.");
                containsClue = true;
            }
        }

        if (!containsClue){
            for (Part part : GameEngine.parts){
                if (input.equalsIgnoreCase(part.getName())){
                    GameEngine.detective.collectedClues.add(part);
                }
            }
        }
    }
}
