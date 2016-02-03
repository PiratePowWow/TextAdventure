import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/3/16.
 */
public class Game {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveler.");

        Player player = new Player();
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

    }

}
