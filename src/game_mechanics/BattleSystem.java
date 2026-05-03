public class BattleSystem {

    public void startBattle(CharacterInfo player, CharacterInfo enemy) {
        System.out.println("Battle Start!");
        System.out.println(player.name + " vs " + enemy.name);

        int round = 1;

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nRound " + round);

            enemy.hp -= player.attack;
            System.out.println(player.name + " attacks " + enemy.name + " for " + player.attack + " damage.");

            if (!enemy.isAlive()) break;

            player.hp -= enemy.attack;
            System.out.println(enemy.name + " attacks " + player.name + " for " + enemy.attack + " damage.");

            System.out.println(player.name + " HP: " + player.hp);
            System.out.println(enemy.name + " HP: " + enemy.hp);

            round++;
        }

        if (player.isAlive()) {
            System.out.println("\n" + player.name + " wins!");
        } else {
            System.out.println("\n" + enemy.name + " wins!");
        }
    }
