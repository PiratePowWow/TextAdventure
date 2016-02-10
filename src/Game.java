import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/3/16.
 */
public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveler.");

        try {
            player = loadGame();
            System.out.println("Loading saved game.");
        }
        catch (Exception e){
            System.out.println("Starting new game.");
        }

        if (player.name == null) player.chooseName();
        if (player.weapon == null) player.chooseWeapon();
        if (player.location == null) player.chooseLocation();

        if (player.items.isEmpty()) {
            player.findItem("shield");
            player.findItem("boots");
            player.findItem("belt");
            player.findItem("helm");
        }


        Enemy ogre = new Enemy("Ogre", 10, 10);
        player.battle(ogre);



//        System.out.println("You found a shield! Pick it up? [y/n]");
//        String answer = scanner.nextLine();
//        if (answer.equalsIgnoreCase("y")){
//            player.items.add("shield");
//        }

    }

    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            switch (line) {
                case "/hello":
                    System.out.println("Hello!");
                    break;
                case "/inv":
                    for (String item : player.items) {
                        System.out.println(item);
                    }
                    break;
                case "/exit":
                    System.exit(0);
                    break;
                case "/save":
                    try {
                        saveGame();
                        System.out.println("Saved Game");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Command not found!");
                    break;
            }
            line = scanner.nextLine();
        }
        return line;
    }

    public static void saveGame() throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(player);
        File savegame = new File("savegame.json");
        FileWriter fw = new FileWriter(savegame);
        fw.write(json);
        fw.close();
    }

    public static Player loadGame() throws FileNotFoundException {
        File f = new File("savegame.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        return p.parse(contents, Player.class);

    }

    //
    //String num = scanner.nextLine();
    //int n = Integer.valueOf(num);
}
