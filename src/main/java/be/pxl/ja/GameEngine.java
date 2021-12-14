package be.pxl.ja;

import be.pxl.ja.command.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameEngine {

    private static final Random RANDOM = new Random();
    private Detective detective;
    private Scanner scanner;
    private boolean murderSolved;

    private HelpCommand helpCommand = new HelpCommand();
    private SuspectsCommand suspectsCommand = new SuspectsCommand();
    private RoomsCommand roomsCommand = new RoomsCommand();
    private WeaponsCommand weaponsCommand = new WeaponsCommand();
    private ClueCommand clueCommand = new ClueCommand();
    private GoToCommand goToCommand = new GoToCommand();
    private DescribeCommand describeCommand = new DescribeCommand();
    private UnlockCommand unlockCommand = new UnlockCommand();
    private AccuseCommand accuseCommand = new AccuseCommand();

    public List<Room> rooms;
    public List<Weapon> weapons;
    public List<Suspect> suspects;

    public GameEngine(Scanner scanner) {
        this.scanner = scanner;
    }

    public void initialize(String playerName) throws FileNotFoundException {
        murderSolved = false;

        File file = new File("src/main/resources/cluedo.txt");
        scanner = new Scanner(file); // todo: handle exception

        rooms = new ArrayList<>();
        weapons = new ArrayList<>();
        suspects = new ArrayList<>();

        String objectType = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if ("#ROOMS".equals(line) || "#WEAPONS".equals(line) || "#SUSPECTS".equals(line)) {
                objectType = line;
            } else {
                if ("#ROOMS".equals(objectType)) {
                    Room room = new Room(line);
                    if (!rooms.contains(room)) {
                        rooms.add(room);
                    }
                } else if ("#WEAPONS".equals(objectType)) {
                    Weapon weapon = new Weapon(line);
                    if (!weapons.contains(weapon)) {
                        weapons.add(weapon);
                    }
                } else if ("#SUSPECTS".equals(objectType)) {
                    String[] params = line.split(";");

                    String name = params[0].substring(params[0].indexOf(" "));
                    String title = params[0].substring(0, params[0].indexOf(" "));

                    Suspect suspect = new Suspect(name);
                    suspect.setAge(Integer.parseInt(params[1]));
                    suspect.setNationality(params[2]);
                    suspect.setOccupation(params[2]);
                    suspect.setTitle(title);

                    if (!suspects.contains(suspect)) {
                        suspects.add(suspect);
                    }
                }
            }
        }

        detective = new Detective(playerName);

        Room crimeScene = rooms.stream()
                .skip(RANDOM.nextInt(rooms.size()))
                .findFirst()
                .orElseThrow(() -> new CluedoException("No rooms found from game file"));
        crimeScene.setCrimeScene(true);

        Weapon murderWeapon = weapons.stream()
                .skip(RANDOM.nextInt(weapons.size()))
                .findFirst()
                .orElseThrow(() -> new CluedoException("No weapons found from game file"));

        Suspect murderer = suspects.stream()
                .skip(RANDOM.nextInt(suspects.size()))
                .findFirst()
                .orElseThrow(() -> new CluedoException("No suspects found from game file"));

        Envelope<Part> envelope = new Envelope<>();
        envelope.addSecret(crimeScene);
        envelope.addSecret(murderWeapon);
        envelope.addSecret(murderer);

        rooms.remove(crimeScene);
        weapons.remove(murderWeapon);
        suspects.remove(murderer);

        for (Room room : rooms) {
            Weapon weapon = weapons.get(RANDOM.nextInt(weapons.size()));
            weapons.remove(weapon);
            room.setWeapon(weapon);

            Suspect suspect = suspects.get(RANDOM.nextInt(suspects.size()));
            suspects.remove(suspect);
            room.setSuspect(suspect);
        }

        Mansion mansion = new Mansion(new ArrayList<>(rooms));
    }

    public void start() {
        System.out.println("Who murdered Dr. Black? Where did the crime took place, and which weapon was used?");
        System.out.println("Type 'help' for information...");
    }


    /**
     * Handle the command.
     *
     * @param command a command: goto, clue, describe,...
     */

    public void executeCommand(String command) {
        if ("SUSPECTS".equals(command)){
            suspectsCommand.execute(command);
        } else if ("ROOMS".equals(command)){
            roomsCommand.execute(command);
        } else if ("WEAPONS".equals(command)){
            weaponsCommand.execute(command);
        } else if ("DESCRIBE".equals(command)){
            describeCommand.execute(command);
        } else if ("UNLOCK".equals(command)){
            unlockCommand.execute(command);
        } else if (command.contains("CLUE")){ //voorlopig
            clueCommand.execute(command);
        } else if ("HELP".equals(command)){
            helpCommand.execute(command);
        } else if (command.contains("ACCUSE")){ //voorlopig
            accuseCommand.execute(command);
        }
    }

    public void printLocation() {
        System.out.println("You are in the " + detective.getCurrentRoom());
    }


    public boolean isMurderSolved() {
        return murderSolved;
    }
}
