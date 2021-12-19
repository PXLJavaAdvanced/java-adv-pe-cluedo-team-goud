package be.pxl.ja.command;

import be.pxl.ja.GameEngine;

public class UnlockCommand implements Command<String>{
    @Override
    public void execute(String input) {
        GameEngine.detective.getCurrentRoom().unlock();
    }
}
