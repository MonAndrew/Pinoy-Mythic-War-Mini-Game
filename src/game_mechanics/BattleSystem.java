public class BattleSystem {

    public void startBattle(CharacterInfo player, CharacterInfo enemy) {
        System.out.println("Battle Start!");
        System.out.println(player.name + " vs " + enemy.name);

    while (player.isAlive() && enemy.isAlive()) {

        System.out.println("\nYour HP: " + player.getHp());
        System.out.println("Enemy HP: " + enemy.getHp());

        System.out.println("\nChoose Skill:");
        System.out.println("1. Normal");
        System.out.println("2. Mini Special");
        System.out.println("3. Burst");

        int choice = scan.nextInt();

        if (choice == 1)
            player.normalSkill(enemy);
        else if (choice == 2)
            player.miniSkill(enemy);
        else if (choice == 3)
            player.burstSkill(enemy);

        if (!enemy.isAlive())
            break;

        // Enemy random attack
        int enemyMove = rand.nextInt(3) + 1;

        if (enemyMove == 1)
            enemy.normalSkill(player);
        else if (enemyMove == 2)
            enemy.miniSkill(player);
        else
            enemy.burstSkill(player);
          
    }
}
    
