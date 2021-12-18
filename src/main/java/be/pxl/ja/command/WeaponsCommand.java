package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Room;
import be.pxl.ja.Weapon;

public class WeaponsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Weapon weapon : GameEngine.weapons){
            for (Part part : GameEngine.detective.collectedClues){
                if (weapon.getName().equals(part.getName())){
                    System.out.println(weapon.getName() + " 0");
                }
            }
            System.out.println(weapon.getName());
        }
    }
}
