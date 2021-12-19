package be.pxl.ja;

import be.pxl.ja.command.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameEngine {

    private static final Random RANDOM = new Random();
    public static Detective detective;
    private Scanner scanner;
    public static boolean murderSolved;
    public static Envelope<Part> envelope;

    private HelpCommand helpCommand = new HelpCommand();
    private SuspectsCommand suspectsCommand = new SuspectsCommand();
    private RoomsCommand roomsCommand = new RoomsCommand();
    private WeaponsCommand weaponsCommand = new WeaponsCommand();
    private ClueCommand clueCommand = new ClueCommand();
    private GoToCommand goToCommand = new GoToCommand();
    private DescribeCommand describeCommand = new DescribeCommand();
    private UnlockCommand unlockCommand = new UnlockCommand();
    private AccuseCommand accuseCommand = new AccuseCommand();

    public static List<Room> rooms;
    public static List<Weapon> weapons;
    public static List<Suspect> suspects;
    public static Mansion mansion;
    public static List<Part> parts;

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
        parts = new ArrayList<>();

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
                        parts.add(room);
                    }
                } else if ("#WEAPONS".equals(objectType)) {
                    Weapon weapon = new Weapon(line);
                    if (!weapons.contains(weapon)) {
                        weapons.add(weapon);
                        parts.add(weapon);
                    }
                } else if ("#SUSPECTS".equals(objectType)) {
                    String[] params = line.split(";");

                    String name = params[0].substring(params[0].indexOf(" ")).strip();
                    String title = params[0].substring(0, params[0].indexOf(" "));

                    Suspect suspect = new Suspect(name);
                    suspect.setAge(Integer.parseInt(params[1]));
                    suspect.setNationality(params[2]);
                    suspect.setOccupation(params[2]);
                    suspect.setTitle(title);

                    if (!suspects.contains(suspect)) {
                        suspects.add(suspect);
                        parts.add(suspect);
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

        envelope = new Envelope<>();
        envelope.addSecret(crimeScene);
        envelope.addSecret(murderWeapon);
        envelope.addSecret(murderer);

        // overige wapens en suspects verdelen over de kamers
        List<Weapon> roomWeapons = new ArrayList<>();
        for (Weapon weapon : weapons){
            if (!weapon.equals(murderWeapon)){
                roomWeapons.add(weapon);
            }
        }

        List<Suspect> roomSuspects = new ArrayList<>();
        for (Suspect suspect : suspects){
            if (!suspect.equals(murderer)){
                roomSuspects.add(suspect);
            }
        }

        for (Room room : rooms) {
            if (roomWeapons.size() != 0){
                Weapon weapon = roomWeapons.get(RANDOM.nextInt(roomWeapons.size()));
                roomWeapons.remove(weapon);
                room.setWeapon(weapon);
            }

            if (roomSuspects.size() != 0){
                Suspect suspect = roomSuspects.get(RANDOM.nextInt(roomSuspects.size()));
                roomSuspects.remove(suspect);
                room.setSuspect(suspect);
            }
        }

        mansion = new Mansion(new ArrayList<>(rooms));
        detective.moveTo(mansion.getHall());
    }

    public void start() {
        System.out.println("Who murdered Dr. Black? Where did the crime took place, and which weapon was used?");
        System.out.println("Type 'help' for information...");
    }

    public void executeCommand(String command) {
        if ("suspects".equals(command)){
            suspectsCommand.execute(command);
        } else if ("rooms".equals(command)){
            roomsCommand.execute(command);
        } else if ("weapons".equals(command)){
            weaponsCommand.execute(command);
        } else if ("describe".equals(command)){
            describeCommand.execute(command);
        } else if ("unlock".equals(command)){
            unlockCommand.execute(command);
        } else if (command.contains("clue")){ //voorlopig
            clueCommand.execute(command.substring(5));
        } else if ("help".equals(command)){
            helpCommand.execute(command);
        } else if (command.contains("accuse")){ //voorlopig
            accuseCommand.execute(command.substring(7));
        } else if (command.contains("goto")){
            goToCommand.execute(command.substring(5));
        }
    }

    public void printLocation() {
        System.out.println("You are in the " + detective.getCurrentRoom().getName());
    }

    public boolean isMurderSolved() {
        return murderSolved;
    }
}
