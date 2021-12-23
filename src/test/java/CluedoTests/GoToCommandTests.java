package CluedoTests;

import be.pxl.ja.CluedoException;
import be.pxl.ja.GameEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertThrows;

public class GoToCommandTests {
    Scanner keyboard = new Scanner(System.in);
    GameEngine gameEngine = new GameEngine(keyboard);

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        gameEngine.initialize("Stef");
    }

    @Test
    public void shouldStartInHall() {
        Assertions.assertEquals("Hall", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToDining(){
        gameEngine.executeCommand("goto dining");
        Assertions.assertEquals("Dining", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToBall(){
        gameEngine.executeCommand("goto ball");
        Assertions.assertEquals("Ball", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToConservatory(){
        gameEngine.executeCommand("goto conservatory");
        Assertions.assertEquals("Conservatory", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToKitchen(){
        gameEngine.executeCommand("goto kitchen");
        Assertions.assertEquals("Kitchen", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToLibrary(){
        gameEngine.executeCommand("goto library");
        Assertions.assertEquals("Library", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToLounge(){
        gameEngine.executeCommand("goto lounge");
        Assertions.assertEquals("Lounge", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToStudy(){
        gameEngine.executeCommand("goto study");
        Assertions.assertEquals("Study", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void shouldGoToBilliard(){
        gameEngine.executeCommand("goto billiard");
        Assertions.assertEquals("Billiard", GameEngine.detective.getCurrentRoom().getName());
    }

    @Test
    public void goToHallShouldThrowCluedoExceptionWithCorrectMessage(){
        CluedoException cluedoException = assertThrows(CluedoException.class, () -> gameEngine.executeCommand("goto hall"));
        Assertions.assertEquals("This move is not allowed", cluedoException.getMessage());
    }
}
