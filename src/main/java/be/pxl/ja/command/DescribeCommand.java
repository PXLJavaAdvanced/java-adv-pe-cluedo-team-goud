package be.pxl.ja.command;

import be.pxl.ja.GameEngine;

public class DescribeCommand implements Command<String>{
    @Override
    public void execute(String input) {
        //System.out.println(GameEngine.detective.getCurrentRoom().getName());
        System.out.println(GameEngine.detective.getCurrentRoom().describe(GameEngine.detective.getCurrentRoom().getName()));
    }
}
