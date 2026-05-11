public class BattleSystem {

    public void battleStart(CharacterInfo player, CharacterInfo enemy) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        RandomBuffDebuff objRand = new RandomBuffDebuff();

        boolean continueGame = true;

        int level = 1;

        while (continueGame && player.isAlive()) {

            System.out.println("\n====================");
            System.out.println("LEVEL " + level);
            System.out.println("====================");

            // Reset enemy HP every level
            enemy.setHealth(1000 + (level * 100));

            // Enemy becomes stronger
            enemy.setDmg(100 + (level * 15));

            System.out.println(enemy.getName() + " became stronger!");

            boolean chooseBuff = true;

            int turnCounter = 1;
             
            //TURNS ON THE CHOOSING BUFF EVERY 5 LEVELS
            if (turnCounter % 5 == 0) {
                    chooseBuff = true;
                }


            // BATTLE STARTS HERE!
            while (player.isAlive() && enemy.isAlive()) {

                System.out.println("\n--------------------");
                System.out.println("TURN " + turnCounter);
                System.out.println("--------------------");


                // BUFF EVERY 5 Levels
                if (chooseBuff) {

                    System.out.println("\nChoose Buff:");

                    System.out.println("1. LifeSteal");
                    System.out.println("2. +30 Damage");
                    System.out.println("3. Poison");
                    System.out.println("4. Fire");

                    System.out.print("Choice: ");
                    int buffChoice = scan.nextInt();

                    objRand.giveBuff(player, buffChoice);

                    chooseBuff = false;
                }

                
                // DISPLAY HP for both PLAYER and ENEMY
                System.out.println("\n" + player.getName() + " HP: " + player.getHealth());

                System.out.println(enemy.getName() + " HP: " + enemy.getHealth());

                // PLAYER TURN
                System.out.println("\nChoose Skill:");
                System.out.println("1. Normal");
                System.out.println("2. Mini Special");
                System.out.println("3. Burst");

                System.out.print("Choice: ");
                int choice = scan.nextInt();

                switch (choice) {

                    case 1:
                        player.normalSkill(enemy);
                        break;

                    case 2:
                        player.miniSkill(enemy);
                        break;

                    case 3:
                        player.burstSkill(enemy);
                        break;

                    default:
                        System.out.println("Invalid Input!");
                }

                // Apply effects
                objRand.applyEffects(enemy);

                if (!enemy.isAlive()) {
                    break;
                }

                // ENEMY TURN, CANNOT apply buff or  debuff to the PLAYER
                int enemyMove = rand.nextInt(3) + 1;

                System.out.println("\nEnemy Turn!");

                switch (enemyMove) {

                    case 1:
                        enemy.normalSkill(player);
                        break;

                    case 2:
                        enemy.miniSkill(player);
                        break;

                    case 3:
                        enemy.burstSkill(player);
                        break;
                }


                turnCounter++;
            }

            // OUTCOME
            if (player.isAlive()) {

                System.out.println("\nEnemy Defeated!");

                System.out.print("Continue to next level? (Y/N): ");
                char answer = scan.next().charAt(0);
                char choice = Character.toLowerCase(answer);

                if(choice == 'y' || choice == 'n'){
                    level++;
                    // heal the player so that it will not die, because he is him
                    player.heal(200);
                    System.out.println("You recovered 200 HP!");
                    enemy.setIsAlive(true);
                }
                else {
                    continueGame = false;
                    System.out.println("Game Ended.");
                }
            }
        }


        // GAME OVER or ENDING

        if (!player.isAlive()) {

            System.out.println("\nGAME OVER");
        }
    }
}
