package be.pxl.ja.command;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Room;
import be.pxl.ja.Suspect;
import be.pxl.ja.Weapon;

public class AccuseCommand implements Command<String>{
    @Override
    public void execute(String input) {
        String[] inputParts = input.split(", ");
        boolean corrrectRoom = false;
        boolean correctWeapon = false;
        boolean correctSuspect = false;

        if (!GameEngine.envelope.isSecret(GameEngine.detective.getCurrentRoom())){
            System.out.println("It was not in the " + GameEngine.detective.getCurrentRoom().getName() + ".");
        } else {
            corrrectRoom = true;
        }

        for (Weapon weapon : GameEngine.weapons){
            if (inputParts[1].equalsIgnoreCase(weapon.getName())){
                if (GameEngine.envelope.isSecret(weapon)){
                    System.out.println("It was not with a " + weapon.getName());
                } else {
                    System.out.println(weapon.getName() + " is the murder weapon yes.");
                    correctWeapon = true;
                }
            }
        }

        for (Suspect suspect : GameEngine.suspects){
            if (inputParts[0].equalsIgnoreCase(suspect.getName().strip())){
                if (!GameEngine.envelope.isSecret(suspect)){
                    System.out.println(suspect.getName().strip() + " is not the killer.");
                } else {
                    System.out.println(suspect.getName().strip() + " is the killer indeed.");
                    correctSuspect = true;
                }
            }
        }





        if (correctWeapon && corrrectRoom && correctSuspect){
            System.out.println("Correct you won!");
        }
    }
}
