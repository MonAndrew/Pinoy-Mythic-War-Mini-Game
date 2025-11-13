package game_mechanics;
public class PlayerVersusEntity extends GameMechanics_2{
    
    public void mainPlayerVersusAIGame(int maxCharacter){
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

        System.out.println("Do you want to select Character for player 2?");
        int player2 = (misc.returnTrueOrFalseConfimation()) ? misc.characterSelectionTryCatch(maxCharacter) : misc.getRNG(8, 1);
        
        characterSelection_2(player2);
        displayCharacterStats(player2);
        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player2);}
        
        misc.startButton();

        int min = 1;
        int max = 4;
        String text = "Continuing....";
        int timeInMs = 90;

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

                //misc.displayKillStreak(killStreak);

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(max,min));//skill input
                    misc.slowPrint(text, timeInMs);

                    selectedCharacter_1.doStatusEffect();
                    selectedCharacter_2.doStatusEffect();

                }
                else //50/50
                {
                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(max,min));//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                //misc.displayKillStreak(killStreak);

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);

                    selectedCharacter_2.doStatusEffect();
                    selectedCharacter_1.doStatusEffect();

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

    //arcade next

    public void mainArcadeGameMode(int maxCharacter){
        misc.turnKillSwitch();
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

        int player2 = 1;
        if(player1 == player2){ player2++; characterSelection_2(player2);}
        characterSelection_2(player2);
        displayCharacterStats(player2);
        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player2);}
        
        misc.startButton();

        int min = 1;
        int max = 4;
        int killStreak = 0;
        String text = "Continuing....";
        int timeInMs = 90;

    while(selectedCharacter_1.getHealth() > 0 && player2 <= 8){

        if(player1 == player2){ player2++; characterSelection_2(player2);}
        characterSelection_1(player1);
        characterSelection_2(player2);

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

                misc.displayKillStreak(killStreak);

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(max,min));//skill input
                    misc.slowPrint(text, timeInMs);

                    selectedCharacter_1.doStatusEffect();
                    selectedCharacter_2.doStatusEffect();

                }
                else //50/50
                {
                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(max,min));//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                misc.displayKillStreak(killStreak);

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkill());//skill input
                    misc.slowPrint(text, timeInMs);

                    selectedCharacter_2.doStatusEffect();
                    selectedCharacter_1.doStatusEffect();

                }
                
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");

            }

            //end while loop
        }
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                 ╔════════════╗");
        System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
        System.out.println("                                 ╚════════════╝");
        misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
        System.out.println("                                 ╔════════════╗");
        System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
        System.out.println("                                 ╚════════════╝");
        misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");

        if(selectedCharacter_2.getHealth() <= 0)killStreak++;

        player2++;
        selectedCharacter_1.clearCooldownsAndEffectTurns();
        selectedCharacter_2.clearCooldownsAndEffectTurns();

    }
    misc.displayKillStreak(killStreak);
    System.out.println();

    if(killStreak >= 7){
        System.out.println("WOW u won! :D");
        if(misc.killSwitch == true){
            System.out.println("Or did UUuu??????... >:)))");
            bossBattleLMAO();
        }
    }else{misc.displayDeathScreen();}
    

    //end game main method
    }


    public void bossBattleLMAO(){
    selectedCharacter_2.setPlayerSelectedCharacter("Entity(Khai Gumunan)",3000, 1000);
    selectedCharacter_2.setCharacterNormalSkill("???", 25, 50, 75);
    selectedCharacter_2.setCharacterSkill_1("???", 100, 3000, 150);
    selectedCharacter_2.setCharacterSkill_2("???", 250, 3500, 300);
    selectedCharacter_2.setBuffAndDebuff(3, 5);

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

                //misc.displayKillStreak(killStreak);

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(misc.enterSkillTryCatch());//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(3,3));//skill input
                    misc.slowPrint(text, timeInMs);

                    selectedCharacter_1.doStatusEffect();
                    selectedCharacter_2.doStatusEffect();

                }
                else //50/50
                {
                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  2:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();
                    dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(3,3));//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                 ╔════════════╗");
                System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
                System.out.println("                                 ╚════════════╝");

                //misc.displayKillStreak(killStreak);

                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();
                    dealDamageCharacter_1ToCharacter_2(misc.enterSkillTryCatch());//skill input
                    misc.slowPrint(text, timeInMs);

                    selectedCharacter_2.doStatusEffect();
                    selectedCharacter_1.doStatusEffect();

                }
                
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");

            }

            //end while loop
        }

    }   
}



