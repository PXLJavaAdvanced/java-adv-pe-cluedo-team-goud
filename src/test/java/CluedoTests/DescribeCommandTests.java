package CluedoTests;

import be.pxl.ja.GameEngine;
import be.pxl.ja.Part;
import be.pxl.ja.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class DescribeCommandTests {
    Scanner keyboard = new Scanner(System.in);
    GameEngine gameEngine = new GameEngine(keyboard);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        gameEngine.initialize("Stef");
    }

    @Test
    public void shouldShowLockedWhenRoomIsLocked() {
        gameEngine.executeCommand("goto ball");

        System.setOut(new PrintStream(outContent));
        gameEngine.executeCommand("describe");

        Assertions.assertEquals("Ball is locked.", outContent.toString().strip());
    }

    @Test
    public void shouldGiveRightDescription(){
        gameEngine.executeCommand("goto kitchen");
        GameEngine.detective.getCurrentRoom().unlock();

        System.setOut(new PrintStream(outContent));
        gameEngine.executeCommand("describe");

        Assertions.assertEquals("There's no blood in this room", outContent.toString().strip());
    }
}
