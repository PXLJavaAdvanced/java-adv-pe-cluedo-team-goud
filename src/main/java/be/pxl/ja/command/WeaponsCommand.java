package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Room;
import be.pxl.ja.Weapon;

public class WeaponsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Weapon weapon : GameEngine.weapons){
            boolean isClue = false;
            for (Part part : GameEngine.detective.collectedClues){
                if (weapon.getName().equalsIgnoreCase(part.getName())){
                    System.out.println(weapon.getName() + " 0");
                    isClue = true;
                }
            }
            if (!isClue){
                System.out.println(weapon.getName());
            }
        }
    }
}
