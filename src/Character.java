/**
 * Created by PiratePowWow on 2/9/16.
 */
public class Character {
    String name;
    int health;
    int damage;

    public void battle(Character enemy) {
        System.out.printf("%s appears!\n", enemy.name);

        while (health>0 && enemy.health > 0) {
            health -= enemy.damage;
            enemy.health -= damage;
            System.out.printf("%s's health: %d\n%s's health: %d\n", name, health, enemy.name, enemy.health);
        }

        String message = "%s has died.";

        if (health<=0) {
            System.out.printf(message, name);
        }

        if (enemy.health <= 0){
            System.out.printf(message, enemy.name);
        }
    }
}
