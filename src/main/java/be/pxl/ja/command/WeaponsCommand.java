package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Room;
import be.pxl.ja.Weapon;

public class WeaponsCommand implements Command<String>{
    @Override
    public void execute(String input) {
        for (Weapon weapon : GameEngine.weapons){
            System.out.println(weapon.getName());
        }
    }
}
