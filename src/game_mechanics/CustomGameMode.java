package game_mechanics;
public class CustomGameMode extends GameMechanics_2{
    private boolean isVSAIattacks;
    private boolean isSpecificEnemyCharacterSelection;
    private int specificEnemyCharacterSelection;
    //private boolean isMatchWinsCounter;
    private int matches;
    private int rounds;

    public CustomGameMode(){
        setCharacters();
        this.isVSAIattacks = false;
        this.isSpecificEnemyCharacterSelection = false;
        this.specificEnemyCharacterSelection = misc.getRNG(8, 1);
        //this.isMatchWinsCounter = false;
        this.matches = 1;
        this.rounds = 3;
    }

    public void setCustomHealthAndMana(boolean T){

    }
    public void displayCustomGameModeSettings(){
        System.out.println("─────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Options:                                                       "+misc.BOLD+misc.RED+"5: CONFIRM OPTIONS"+misc.RESET);

        System.out.print("\n1: ");
        if(this.isVSAIattacks){ 
        System.out.println("Enemy AI ─────────────────────────────────────────────────────────> ██"+misc.GREEN+"████"+misc.RESET+" ON");}
        else{ 
        System.out.println("Enemy AI ─────────────────────────────────────────────────────────> "+misc.RED+"████"+misc.RESET+"██ OFF");}

        System.out.print("\n2: ");
        if(this.isSpecificEnemyCharacterSelection){ 
        System.out.println("Specific Character (Enemy: "+this.specificEnemyCharacterSelection+") ────────────────────────────────────> ██"+misc.GREEN+"████"+misc.RESET+" ON ");}
        else{ 
        System.out.println("Specific Character (Enemy: "+misc.BOLD+"RANDOM"+misc.RESET+") ───────────────────────────────> "+misc.RED+"████"+misc.RESET+"██ OFF ");}
        System.out.println("   (Only works when Enemy AI is on)");

        System.out.print("\n3: ");
        System.out.println(misc.BOLD+"Matches: "+misc.YELLOW+this.matches+misc.RESET);
        /*if(this.isMatchWinsCounter){ 
        System.out.println("   Match Wins Counter  ──────────────────────────────────────────────> ██"+misc.GREEN+"████"+misc.RESET+" ON");}
        else{ 
        System.out.println("   Match Wins Counter  ──────────────────────────────────────────────> "+misc.RED+"████"+misc.RESET+"██ OFF");}*/

        System.out.print("\n4: ");
        System.out.println(misc.BOLD+"Rounds:  "+misc.YELLOW+this.rounds+misc.RESET);
        
        System.out.println("─────────────────────────────────────────────────────────────────────────────────");
        System.out.println();
    }

    public void setCustomGameModeSettings(int maxCharacter){
        boolean confirmation = false;

        while(!confirmation){
        
        misc.addSpace();
        displayCustomGameModeSettings();
        System.out.print("Enter Option Selection: ");
        switch(misc.tryCatchIntWithMinMax(1, 5)){
        
        case 1 ->{

        if(this.isVSAIattacks){ System.out.println("Enemy AI -> ██"+misc.GREEN+"████"+misc.RESET+" ON");}
        else{ System.out.println("Enemy AI -> "+misc.RED+"████"+misc.RESET+"██ OFF");}

        System.out.print("\nSwitch (Y: On/N: Off):");
        this.isVSAIattacks = misc.returnTrueOrFalseConfimation();

        if(this.isVSAIattacks){ System.out.println("Enemy AI -> ██"+misc.GREEN+"████"+misc.RESET+" ON");}
        else{ System.out.println("Enemy AI -> "+misc.RED+"████"+misc.RESET+"██ OFF");}

        }
        
        case 2 -> {

        if(this.isSpecificEnemyCharacterSelection){ System.out.println("Specific Character -> ██"+misc.GREEN+"████"+misc.RESET+" ON (Enemy: "+this.specificEnemyCharacterSelection+")");}
        else{ System.out.println("Specific Character -> "+misc.RED+"████"+misc.RESET+"██ OFF (Enemy: "+this.specificEnemyCharacterSelection+")");}

        System.out.print("\nSwitch (Y: On/N: Off):");
        this.isSpecificEnemyCharacterSelection = misc.returnTrueOrFalseConfimation();

        if(this.isSpecificEnemyCharacterSelection){ 
            displayCharacters();
            this.specificEnemyCharacterSelection = misc.characterSelectionTryCatch(maxCharacter);
            System.out.println("Specific Character -> ██"+misc.GREEN+"████"+misc.RESET+" ON (Enemy: "+this.specificEnemyCharacterSelection+")");}
        else{ System.out.println("Specific Character -> "+misc.RED+"████"+misc.RESET+"██ OFF (Enemy: "+this.specificEnemyCharacterSelection+")");}
        }

        case 3 -> {

        this.matches = misc.tryCatch("Enter Preferred Matches (Current Matches: "+this.matches+"):", "Matches must be 1 and above.", "Invalid Matches!",1);
        /* 
        if(this.isMatchWinsCounter){ System.out.println("Match Wins Counter  -> ██"+misc.GREEN+"████"+misc.RESET+" ON");}
        else{ System.out.println("Match Wins Counter  -> "+misc.RED+"████"+misc.RESET+"██ OFF");}

        System.out.print("\nSwitch (Y: On/N: Off):");
        this.isMatchWinsCounter = misc.returnTrueOrFalseConfimation();

        if(this.isMatchWinsCounter){ System.out.println("Match Wins Counter -> ██"+misc.GREEN+"████"+misc.RESET+" ON");}
        else{ System.out.println("Match Wins Counter  -> "+misc.RED+"████"+misc.RESET+"██ OFF");}
        */}

        case 4 -> {
            int roundToOddNum = misc.tryCatch("Enter Preferred Rounds (Only Odd numbers, Current Rounds: "+this.rounds+"):", "Round must be 3 and above.", "Invalid Input Round!",3);
            System.out.println(roundToOddNum);
            if(roundToOddNum % 2 == 0){ roundToOddNum++;}
            System.out.println(roundToOddNum);
            this.rounds = roundToOddNum;
        }

        case 5 -> {
            misc.addSpace();
            displayCustomGameModeSettings();
            System.out.print("Confirm Settings?");
            confirmation = misc.returnTrueOrFalseConfimation();
        }

        default -> {misc.displayInvalidScreen();}

        }
    
    }

    System.out.println("─────────────────────────────────────────────────────────────────────────────────");

    }

    public void mainCustomGame(int maxCharacter){
        setCharacters();
        displayCharacters();

        System.out.println("                                 ╔════════════╗");
        System.out.println("═════════════════════════════════║ "+misc.BOLD+"PLAYER  1:"+misc.RESET+" ║═════════════════════════════════");
        System.out.println("                                 ╚════════════╝");

        int player1 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_1(player1);
        displayCharacterStats(player1);
        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player1);}

        int player2;
        String namePlayer_2;

        if(this.isVSAIattacks){
        namePlayer_2 = "OPPONENT ";
        misc.displayTurnPlayer_2(namePlayer_2+this.specificEnemyCharacterSelection);
        player2 = this.specificEnemyCharacterSelection;
        namePlayer_2 = "OPPONENT:"+player2;
        }
        else{
        namePlayer_2 = "PLAYER 2: ";
        misc.displayTurnPlayer_2(namePlayer_2);
        player2 = misc.characterSelectionTryCatch(maxCharacter);
        }

        characterSelection_2(player2);
        displayCharacterStats(player2);
        System.out.print("Show Character BackStory?");
        if(misc.returnTrueOrFalseConfimation() == true){displayBackStory(player2);}
        
        misc.startButton();
        boolean isGameFinished = false;
        int winsMatchesPlayer_1 = 0;
        int winsMatchesPlayer_2 = 0;
        int winsPlayer_1 = 0;
        int winsPlayer_2 = 0;

        int tempWin_1 = 0;
        int tempWin_2 = 0;

        int min = 1;
        int max = 4;
        String text = "Continuing....";
        int timeInMs = 9;

    for(int numOfMatches = 1; numOfMatches <= this.matches ;numOfMatches++){

        int round = 1;
        while(!isGameFinished){
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                
                if(round ==  (this.rounds)){
                System.out.println("                                 ╔════════════╗");
                System.out.print("                                 ║ "+misc.BOLD+misc.YELLOW+" ROUND: "+round+misc.RESET);
                if(round < 10){System.out.println("  ║");}else{ System.out.println(" ║");}
                System.out.println("                                 ╚════════════╝");

                misc.displayFinalRoundScreen();
                misc.slowPrint(text, 60);
                
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
                chance = 0;
                if(chance == 0){/* 
                misc.displayTurnPlayer_1();
                System.out.print(misc.BOLD+misc.YELLOW+namePlayer_2+": "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_2.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_2.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                misc.displayKillStreak(winsPlayer_1);
                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();*/
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkillForBots(4, 1));//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;
/*
                misc.displayTurnPlayer_2(namePlayer_2);
                System.out.println(misc.BOLD+misc.YELLOW+"P1's: "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_1.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_1.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                misc.displayKillStreak(winsPlayer_2);
                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();*/

                    if(this.isVSAIattacks) {dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(max, min));}//skill input
                    else {dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkill());}//skill input
                    misc.slowPrint(text, timeInMs);

                }
                else //50/50
                {/* 
                misc.displayTurnPlayer_2(namePlayer_2);
                System.out.println(misc.BOLD+misc.YELLOW+"P1's: "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_1.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_1.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");

                misc.displayKillStreak(winsPlayer_2);
                    selectedCharacter_2.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    selectedCharacter_2.displaySkillsAndIfAvailable();*/

                    if(this.isVSAIattacks) {dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkillForBots(max, min));}//skill input
                    else {dealDamageCharacter_2ToCharacter_1(selectedCharacter_2.enterSkill());}//skill input
                    misc.slowPrint(text, timeInMs);
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;
/*
                misc.displayTurnPlayer_1();
                System.out.print(misc.BOLD+misc.YELLOW+namePlayer_2+": "+misc.GREEN+"HP \t"+misc.RESET);selectedCharacter_2.displayCurrectStatusEffect();
                misc.displayASCIIBars(selectedCharacter_2.getHealth(), misc.getMaxHealth());
                System.out.println("\n─────────────────────────────────────────────────────────────────────────────────");
                
                misc.displayKillStreak(winsPlayer_1);
                    selectedCharacter_1.displayCurrectStatusEffect();
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    selectedCharacter_1.displaySkillsAndIfAvailable();*/
                    dealDamageCharacter_1ToCharacter_2(selectedCharacter_1.enterSkillForBots(4, 1));//skill input
                    misc.slowPrint(text, timeInMs);

                }

                selectedCharacter_1.doStatusEffect();
                selectedCharacter_2.doStatusEffect();
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");

            }

            if(selectedCharacter_2.getHealth() <= 0){ winsPlayer_1++;}
            if(selectedCharacter_1.getHealth() <= 0){ winsPlayer_2++;}

            if(winsPlayer_1%3 == 2 && winsPlayer_2%3 == 0 || winsPlayer_1%3 == 0 && winsPlayer_2%3 == 2){isGameFinished = true;}
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
        
        //reset of winsPlayer 1 and 2 add it pls
        tempWin_1 += winsPlayer_1;
        tempWin_2 += winsPlayer_2;
        winsPlayer_1 = 0;
        winsPlayer_2 = 0;

        if(selectedCharacter_2.getHealth() <= 0){ winsMatchesPlayer_1++;}
        if(selectedCharacter_1.getHealth() <= 0){ winsMatchesPlayer_2++;}

        selectedCharacter_1.clearCooldownsAndEffectTurns();
        selectedCharacter_2.clearCooldownsAndEffectTurns();

    //end matches
    }
    System.out.println("TEMP Rounds Wins:P1 And P2 total:"+(tempWin_1+tempWin_2));   
    misc.displayKillStreak(tempWin_1);
    misc.displayKillStreak(tempWin_2);
    System.out.println("Rounds Wins:P1 And P2 total:"+(winsPlayer_1+winsMatchesPlayer_2));   
    misc.displayKillStreak(winsPlayer_1);
    misc.displayKillStreak(winsPlayer_2);
    System.out.println("Matches Wins:P1 And P2");
    misc.displayKillStreak(winsMatchesPlayer_1);
    misc.displayKillStreak(winsMatchesPlayer_2);
    misc.displayEndBattle(winsMatchesPlayer_1, winsMatchesPlayer_2);
     //end game main method
    }

}
