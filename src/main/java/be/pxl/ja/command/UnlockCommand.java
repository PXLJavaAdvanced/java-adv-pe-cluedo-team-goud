package be.pxl.ja.command;

import be.pxl.ja.GameEngine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class UnlockCommand implements Command<String>{
    @Override
    public void execute(String input) {
        /*
        Scanner keyboard = new Scanner(System.in);
        // keyboard.nextLine()

        System.out.println(GameEngine.crackTheCodes.get(0).getAnswer());

        if (keyboard.nextLine().equals(GameEngine.crackTheCodes.get(0).getAnswer())){
            GameEngine.detective.getCurrentRoom().unlock();
        } else {
            System.out.println("Wrong answer!");
        }

         */

        GameEngine.detective.getCurrentRoom().unlock();
    }
}
