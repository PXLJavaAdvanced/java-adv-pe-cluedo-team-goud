package be.pxl.ja;

import be.pxl.ja.command.HelpCommand;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

	private static final Random RANDOM = new Random();
	private Detective detective;
	private final Scanner scanner;
	private boolean murderSolved;
	private HelpCommand helpCommand = new HelpCommand();

	public GameEngine(Scanner scanner) {
		this.scanner = scanner;
	}

	public void initialize(String playerName) {
		murderSolved = false;
		// read all files to initialize the game
		detective = new Detective(playerName);
		// randomly choose weapon, crimescene and murderer
		// put all other weapons and suspects in the rooms of the mansion
	}

	public void start() {
		System.out.println("Who murdered Dr. Black? Where did the crime took place, and which weapon was used?");
		System.out.println("Type 'help' for information...");
	}


	/**
	 * Handle the command.
	 * @param command a command: goto, clue, describe,...
	 */
	public void executeCommand(String command) {
		helpCommand.execute(null);
	}

	public void printLocation() {
		System.out.println("You are in the " + detective.getCurrentRoom());
	}


	public boolean isMurderSolved() {
		return murderSolved;
	}
}
