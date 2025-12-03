package game_mechanics;
public class PlayerVersusPlayer extends GameMechanics_2{
    
    public void mainPlayerVersusPlayerGame(int maxCharacter){
        setCharacters();
        displayCharacters();

        misc.displayTurnPlayer_1();
        int player1 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_1(player1);
        displayCharacterStats(player1);

        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player1);}

        String namePlayer_2 = "Player 2:";
        misc.displayTurnPlayer_2(namePlayer_2);
        int player2 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_2(player2);
        displayCharacterStats(player2);

        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player2);}
        
        boolean isGameFinished = false;
        int winsPlayer_1 = 0;
        int winsPlayer_2 = 0;
        //int min = 2;
        //int max = 3;
        String text = "Continuing....";
        int timeInMs = 90;

        misc.startButton();

        int round = 1;
        while(!isGameFinished){
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                
                if((winsPlayer_1 == 1) && (winsPlayer_2 == 1)){
                misc.displayFinalRoundScreen();
                misc.slowPrint(text, 60);
                selectedCharacter_1.setPlayerSelectedCharacter(selectedCharacter_1.getCharacterName(), 1000, 300);
                selectedCharacter_2.setPlayerSelectedCharacter(selectedCharacter_2.getCharacterName(), 1000, 300);
                
                }else{System.out.println("                                 ╔════════════╗");
                System.out.print("                                 ║ "+misc.BOLD+misc.YELLOW+" ROUND: "+round+misc.RESET);
                if(round < 10)System.out.println("  ║");else System.out.println(" ║");
                System.out.println("                                 ╚════════════╝");
            }
                round++;
            for(int turn = 1; (selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0);turn++){

                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                System.out.println("                                  ╔══════════╗");
                System.out.print("                                  ║"+misc.BOLD+misc.YELLOW+" TURN: "+turn+misc.RESET);
                if(turn < 10)System.out.println("  ║");else System.out.println(" ║");
                System.out.println("                                  ╚══════════╝");

                selectedCharacter_1.reduceCooldownAndEffectTurns();
                selectedCharacter_2.reduceCooldownAndEffectTurns();
                
                int chance = misc.getFifthyFifhtyChance();

                if(chance == 0){
                misc.displayTurnPlayer_1();
                System.out.print(misc.BOLD+misc.YELLOW+"P2's: "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_2.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_2.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                misc.displayTurnPlayer_2(namePlayer_2);
                System.out.print(misc.BOLD+misc.YELLOW+"P1's: "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_1.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_1.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);

                }
                else //50/50
                {
                misc.displayTurnPlayer_2(namePlayer_2);
                System.out.print(misc.BOLD+misc.YELLOW+"P1's: "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_1.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_1.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                misc.displayTurnPlayer_1();
                System.out.print(misc.BOLD+misc.YELLOW+"P2's: "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_2.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_2.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);
                }

                selectedCharacter_1.doStatusEffect();
                selectedCharacter_2.doStatusEffect();
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");

            }

            if(selectedCharacter_2.getHealth() <= 0){ winsPlayer_1++;}
            if(selectedCharacter_1.getHealth() <= 0){ winsPlayer_2++;}

            if(winsPlayer_1 == 2 || winsPlayer_2 == 2){isGameFinished = true;}
            else{
            misc.displayEndBattle(selectedCharacter_1.getHealth(), selectedCharacter_2.getHealth());
            misc.slowPrint(text, timeInMs);
            selectedCharacter_1.clearCooldownsAndEffectTurns();
            selectedCharacter_2.clearCooldownsAndEffectTurns();
            characterSelection_1(player1);
            characterSelection_2(player2);
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
