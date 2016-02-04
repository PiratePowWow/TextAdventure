import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/3/16.
 */
public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveler.");

        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

        player.findItem("shield");
        player.findItem("boots");
        player.findItem("belt");
        player.findItem("helm");



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
                default:
                    System.out.println("Command not found!");
                    break;
            }
            line = scanner.nextLine();
        }
        return line;
    }

    //
    //String num = scanner.nextLine();
    //int n = Integer.valueOf(num);
}
