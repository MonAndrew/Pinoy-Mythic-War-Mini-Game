package game_mechanics;
public class PlayerVersusPlayer extends GameMechanics_2{
    
    public void mainPlayerVersusPlayerGame(int maxCharacter){
        setCharacters();
        displayCharacters();

        //misc.setPlayerName_1();
        //System.out.println(misc.getPlayerName_1());
        System.out.println("                                 ╔════════════╗");
        System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
        System.out.println("                                 ╚════════════╝");

        int player1 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_1(player1);
        displayCharacterStats(player1);

        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player1);}

        System.out.println("                                 ╔════════════╗");
        System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
        System.out.println("                                 ╚════════════╝");

        int player2 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_2(player2);
        displayCharacterStats(player2);

        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player2);}
        
        //int min = 2;
        //int max = 3;
        String text = "Continuing....";
        int timeInMs = 90;

        misc.startButton();

        int round = 1;
        while(selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0){
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                System.out.println("                                 ╔════════════╗");
                System.out.print("                                 ║ "+misc.BOLD+misc.YELLOW+" ROUND: "+round+misc.RESET);
                if(round < 10)System.out.println("  ║");else System.out.println(" ║");
                System.out.println("                                 ╚════════════╝");
                round++;
            for(int turn = 10; (selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0) && turn > 0 ;turn--){

                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                System.out.println("                                  ╔══════════╗");
                System.out.print("                                  ║"+misc.BOLD+misc.YELLOW+" TURN: "+turn+misc.RESET);
                if(turn < 10)System.out.println("  ║");else System.out.println(" ║");
                System.out.println("                                  ╚══════════╝");

                selectedCharacter_1.reduceCooldownAndEffectTurns();
                selectedCharacter_2.reduceCooldownAndEffectTurns();
                
                int chance = misc.getFifthyFifhtyChance();

                if(chance == 0){
                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(misc.enterSkillTryCatch());//skill input
                    selectedCharacter_1.doStatusEffect();
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(misc.enterSkillTryCatch());//skill input
                    selectedCharacter_2.doStatusEffect();
                    misc.slowPrint(text, timeInMs);

                }
                else //50/50
                {
                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(misc.enterSkillTryCatch());//skill input
                    selectedCharacter_2.doStatusEffect();
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(misc.enterSkillTryCatch());//skill input
                    selectedCharacter_1.doStatusEffect();
                    misc.slowPrint(text, timeInMs);

                }
                
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");

            }

            //end while loop
        }
    System.out.println("═════════════════════════════════════════════════════════════════════════════════");
    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
    System.out.println("═════════════════════════════════════════════════════════════════════════════════");
    misc.displayEndBattle(selectedCharacter_1.getHealth(), selectedCharacter_2.getHealth());

    selectedCharacter_1.clearCooldownsAndEffectTurns();
    selectedCharacter_2.clearCooldownsAndEffectTurns();
    
        //end game main method
    }

}
