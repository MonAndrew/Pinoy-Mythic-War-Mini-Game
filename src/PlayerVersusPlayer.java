import character.CharacterStats;
import character.Character_1;
import character.Character_2;
import character.Character_3;
import character.Character_4;
import character.Character_5;
import character.Character_6;
import character.Character_7;
import character.Character_8;
import character.Miscellaneous;

class PlayerVersusPlayer{
    Miscellaneous misc = new Miscellaneous();
    CharacterStats character_1 = new Character_1();
    CharacterStats character_2 = new Character_2();
    CharacterStats character_3 = new Character_3();
    CharacterStats character_4 = new Character_4();
    CharacterStats character_5 = new Character_5();
    CharacterStats character_6 = new Character_6();
    CharacterStats character_7 = new Character_7();
    CharacterStats character_8 = new Character_8();
    
    GameMechanics selectedCharacter_1 = new SelectedCharacter_1();
    GameMechanics selectedCharacter_2 = new SelectedCharacter_2();

    //seems useless also kinda annoying but do i really need this, just to organize the code?
    public void setCharacters(){
        character_1.setCharacter();
        character_2.setCharacter();
        character_3.setCharacter();
        character_4.setCharacter();
        character_5.setCharacter();
        character_6.setCharacter();
        character_7.setCharacter();
        character_8.setCharacter();
    }

     
    public int characterSelection_1(int num){
        //setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), character_1.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_1.getNormalSkillName(), character_1.getMinRangeNormalSkill(), character_1.getMaxRangeNormalSkill(), character_1.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_1.getSkillName_1(), character_1.getMinRangeSkill_1(), character_1.getMaxRangeSkill_1(), character_1.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_1.getSkillName_2(), character_1.getMinRangeSkill_2(), character_1.getMaxRangeSkill_2(), character_1.getManaCost2());
            return 1;}

            case 2 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), character_2.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_2.getNormalSkillName(), character_2.getMinRangeNormalSkill(), character_2.getMaxRangeNormalSkill(), character_2.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_2.getSkillName_1(), character_2.getMinRangeSkill_1(), character_2.getMaxRangeSkill_1(), character_2.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_2.getSkillName_2(), character_2.getMinRangeSkill_2(), character_2.getMaxRangeSkill_2(), character_2.getManaCost2());
            return 2;}

            case 3 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_3.getCharacterName(), character_3.getHealth(), character_3.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_3.getNormalSkillName(), character_3.getMinRangeNormalSkill(), character_3.getMaxRangeNormalSkill(), character_3.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_3.getSkillName_1(), character_3.getMinRangeSkill_1(), character_3.getMaxRangeSkill_1(), character_3.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_3.getSkillName_2(), character_3.getMinRangeSkill_2(), character_3.getMaxRangeSkill_2(), character_3.getManaCost2());
            return 3;}

            case 4 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_4.getCharacterName(), character_4.getHealth(), character_4.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_4.getNormalSkillName(), character_4.getMinRangeNormalSkill(), character_4.getMaxRangeNormalSkill(), character_4.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_4.getSkillName_1(), character_4.getMinRangeSkill_1(), character_4.getMaxRangeSkill_1(), character_4.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_4.getSkillName_2(), character_4.getMinRangeSkill_2(), character_4.getMaxRangeSkill_2(), character_4.getManaCost2());
            return 4;}

            case 5 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_5.getCharacterName(), character_5.getHealth(), character_5.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_5.getNormalSkillName(), character_5.getMinRangeNormalSkill(), character_5.getMaxRangeNormalSkill(), character_5.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_5.getSkillName_1(), character_5.getMinRangeSkill_1(), character_5.getMaxRangeSkill_1(), character_5.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_5.getSkillName_2(), character_5.getMinRangeSkill_2(), character_5.getMaxRangeSkill_2(), character_5.getManaCost2());
            return 5;}

            case 6 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_6.getCharacterName(), character_6.getHealth(), character_6.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_6.getNormalSkillName(), character_6.getMinRangeNormalSkill(), character_6.getMaxRangeNormalSkill(), character_6.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_6.getSkillName_1(), character_6.getMinRangeSkill_1(), character_6.getMaxRangeSkill_1(), character_6.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_6.getSkillName_2(), character_6.getMinRangeSkill_2(), character_6.getMaxRangeSkill_2(), character_6.getManaCost2());
            return 6;}

            case 7 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_7.getCharacterName(), character_7.getHealth(), character_7.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_7.getNormalSkillName(), character_7.getMinRangeNormalSkill(), character_7.getMaxRangeNormalSkill(), character_7.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_7.getSkillName_1(), character_7.getMinRangeSkill_1(), character_7.getMaxRangeSkill_1(), character_7.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_7.getSkillName_2(), character_7.getMinRangeSkill_2(), character_7.getMaxRangeSkill_2(), character_7.getManaCost2());
            return 7;}

            case 8 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_8.getCharacterName(), character_8.getHealth(), character_8.getMana());
            selectedCharacter_1.setCharacterNormalSkill(character_8.getNormalSkillName(), character_8.getMinRangeNormalSkill(), character_8.getMaxRangeNormalSkill(), character_8.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_8.getSkillName_1(), character_8.getMinRangeSkill_1(), character_8.getMaxRangeSkill_1(), character_8.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_8.getSkillName_2(), character_8.getMinRangeSkill_2(), character_8.getMaxRangeSkill_2(), character_8.getManaCost2());
            return 8;}

        }
        return 0;
    }

    public int characterSelection_2(int num){
        //setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), character_1.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_1.getNormalSkillName(), character_1.getMinRangeNormalSkill(), character_1.getMaxRangeNormalSkill(), character_1.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_1.getSkillName_1(), character_1.getMinRangeSkill_1(), character_1.getMaxRangeSkill_1(), character_1.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_1.getSkillName_2(), character_1.getMinRangeSkill_2(), character_1.getMaxRangeSkill_2(), character_1.getManaCost2());
            return 1;}

            case 2 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), character_2.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_2.getNormalSkillName(), character_2.getMinRangeNormalSkill(), character_2.getMaxRangeNormalSkill(), character_2.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_2.getSkillName_1(), character_2.getMinRangeSkill_1(), character_2.getMaxRangeSkill_1(), character_2.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_2.getSkillName_2(), character_2.getMinRangeSkill_2(), character_2.getMaxRangeSkill_2(), character_2.getManaCost2());
            return 2;}

            case 3 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_3.getCharacterName(), character_3.getHealth(), character_3.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_3.getNormalSkillName(), character_3.getMinRangeNormalSkill(), character_3.getMaxRangeNormalSkill(), character_3.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_3.getSkillName_1(), character_3.getMinRangeSkill_1(), character_3.getMaxRangeSkill_1(), character_3.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_3.getSkillName_2(), character_3.getMinRangeSkill_2(), character_3.getMaxRangeSkill_2(), character_3.getManaCost2());
            return 3;}

            case 4 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_4.getCharacterName(), character_4.getHealth(), character_4.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_4.getNormalSkillName(), character_4.getMinRangeNormalSkill(), character_4.getMaxRangeNormalSkill(), character_4.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_4.getSkillName_1(), character_4.getMinRangeSkill_1(), character_4.getMaxRangeSkill_1(), character_4.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_4.getSkillName_2(), character_4.getMinRangeSkill_2(), character_4.getMaxRangeSkill_2(), character_4.getManaCost2());
            return 4;}

            case 5 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_5.getCharacterName(), character_5.getHealth(), character_5.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_5.getNormalSkillName(), character_5.getMinRangeNormalSkill(), character_5.getMaxRangeNormalSkill(), character_5.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_5.getSkillName_1(), character_5.getMinRangeSkill_1(), character_5.getMaxRangeSkill_1(), character_5.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_5.getSkillName_2(), character_5.getMinRangeSkill_2(), character_5.getMaxRangeSkill_2(), character_5.getManaCost2());
            return 5;}

            case 6 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_6.getCharacterName(), character_6.getHealth(), character_6.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_6.getNormalSkillName(), character_6.getMinRangeNormalSkill(), character_6.getMaxRangeNormalSkill(), character_6.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_6.getSkillName_1(), character_6.getMinRangeSkill_1(), character_6.getMaxRangeSkill_1(), character_6.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_6.getSkillName_2(), character_6.getMinRangeSkill_2(), character_6.getMaxRangeSkill_2(), character_6.getManaCost2());
            return 6;}

            case 7 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_7.getCharacterName(), character_7.getHealth(), character_7.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_7.getNormalSkillName(), character_7.getMinRangeNormalSkill(), character_7.getMaxRangeNormalSkill(), character_7.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_7.getSkillName_1(), character_7.getMinRangeSkill_1(), character_7.getMaxRangeSkill_1(), character_7.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_7.getSkillName_2(), character_7.getMinRangeSkill_2(), character_7.getMaxRangeSkill_2(), character_7.getManaCost2());
            return 7;}

            case 8 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_8.getCharacterName(), character_8.getHealth(), character_8.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_8.getNormalSkillName(), character_8.getMinRangeNormalSkill(), character_8.getMaxRangeNormalSkill(), character_8.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_8.getSkillName_1(), character_8.getMinRangeSkill_1(), character_8.getMaxRangeSkill_1(), character_8.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_8.getSkillName_2(), character_8.getMinRangeSkill_2(), character_8.getMaxRangeSkill_2(), character_8.getManaCost2());
            return 8;}

        }
        return 0;
    }

    public void displayBackStory(int playerNum){
        switch(playerNum)
        {
        case 1 -> character_1.displayBackStory();
        case 2 -> character_2.displayBackStory();
        case 3 -> character_3.displayBackStory();
        case 4->  character_4.displayBackStory();
        case 5 -> character_5.displayBackStory();
        case 6 -> character_6.displayBackStory();
        case 7 -> character_7.displayBackStory();
        case 8 -> character_8.displayBackStory();
    }
    }
    public void displayCharacterStats(int playerNum){
        switch(playerNum)
        {
        case 1 -> character_1.displayCharacterStats();
        case 2 -> character_2.displayCharacterStats();
        case 3 -> character_3.displayCharacterStats();
        case 4->  character_4.displayCharacterStats();
        case 5 -> character_5.displayCharacterStats();
        case 6 -> character_6.displayCharacterStats();
        case 7 -> character_7.displayCharacterStats();
        case 8 -> character_8.displayCharacterStats();
    }
    }
    
    //System.out.println("Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █  ─ «  » ╠ ╣ ║ ╦ ╩ ╬ ╗ ╝ ╔ ╚ ");
    public void displayCharacters(){
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║   SELECT CHARACTER:  ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("      ╔══════════════════╦══════════════════════╦══════════════════╗");

        System.out.println("      ║ 0:   RANDOM      ║ 1: "+character_1.getCharacterName()+"    ║ 2: "+ character_2.getCharacterName()+"   ║");
        System.out.println("      ╠══════════════════╬══════════════════════╬══════════════════╣");
        System.out.println("      ║ 3: "+character_3.getCharacterName()+" ║ 4: "+character_4.getCharacterName()+"      ║ 5: "+ character_5.getCharacterName()+" ║");
        System.out.println("      ╠══════════════════╬══════════════════════╬══════════════════╣");
        System.out.println("      ║ 6: "+character_6.getCharacterName()+"  ║ 7: "+character_7.getCharacterName()+"  ║ 8: "+ character_8.getCharacterName()+"  ║");

        System.out.println("      ╚══════════════════╩══════════════════════╩══════════════════╝");
        System.out.println("\n\n\n\n");
    } 

    
    public int skillNumberForSelectedCharacter_1(int skillnum){
     
    int dmg = 0;
     
    switch(skillnum){
     
    case 1 -> { dmg  = selectedCharacter_1.getDamagefromNormalSkill(); 
    } 

    case 2 -> { 
    if(selectedCharacter_1.getMana() < selectedCharacter_1.getManaCost1()){
        System.out.println("Not enough Mana!");
        dmg  = selectedCharacter_1.getDamagefromNormalSkill();
    }
    else
        dmg  = selectedCharacter_1.getDamageFromSkill_1(); 
    }

    case 3 -> { 
        if(selectedCharacter_1.getMana() < selectedCharacter_1.getManaCost2()){
        System.out.println("Not enough Mana!");
        dmg  = selectedCharacter_1.getDamagefromNormalSkill();
        System.out.println("Random Effect: ");
    }
    else
        dmg  = selectedCharacter_1.getDamageFromSkill_2(); 
    }

    }
         
    return dmg;
    }

    public int skillNumberForSelectedCharacter_2(int skillnum){
     
    int dmg = 0;
    
    switch(skillnum){
     
    case 1 -> { 
        dmg  = selectedCharacter_2.getDamagefromNormalSkill(); 
    } 
    case 2 -> { 
    if(selectedCharacter_2.getMana() < selectedCharacter_2.getManaCost1()){
        System.out.println("Not enough Mana!");
        dmg  = selectedCharacter_2.getDamagefromNormalSkill();
    }
    else
        dmg  = selectedCharacter_2.getDamageFromSkill_1(); 
    }
    case 3 -> { 
        if(selectedCharacter_2.getMana() < selectedCharacter_2.getManaCost2()){
        System.out.println("Not enough Mana!");
        dmg  = selectedCharacter_2.getDamagefromNormalSkill();
    }
    else
        dmg  = selectedCharacter_2.getDamageFromSkill_2(); 
    }

    }
            
    return dmg;
    }
    
    public void dealDamageCharacter_1ToCharacter_2(int skillnum){
        // add 30% chance to miss :))
        int missChance = misc.getRNG(100, 1);
        // to <- from
        if(missChance > 30)
        selectedCharacter_2.minusHealth( misc.additionalCritDamage(misc.getRNG(100, 50),50,skillNumberForSelectedCharacter_1(skillnum)) );
        else{
        System.out.println(misc.BOLD+misc.RED+" ** "+misc.WHITE+selectedCharacter_1.getCharacterName()+" Attacks Missed!"+misc.RED+" ** "+misc.RESET+"\n");
        }

    }

    public void dealDamageCharacter_2ToCharacter_1(int skillnum){

         int missChance = misc.getRNG(100, 1);
        // to <- from
        if(missChance > 30)
        selectedCharacter_1.minusHealth( misc.additionalCritDamage(misc.getRNG(100, 50),50,skillNumberForSelectedCharacter_2(skillnum)) );
        else{
        System.out.println(misc.BOLD+misc.RED+" ** "+misc.WHITE+selectedCharacter_2.getCharacterName()+" Attacks Missed!"+misc.RED+" ** "+misc.RESET+"\n");
        }
    }

    public void mainPlayerVersusPlayerGame(int maxCharacter){
        setCharacters();

        displayCharacters();

        //misc.setPlayerName_1();
        //System.out.println(misc.getPlayerName_1());
        int player1 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_1(player1);
        displayCharacterStats(player1);
        displayBackStory(player1);

        int player2 = misc.characterSelectionTryCatch(maxCharacter);
        characterSelection_2(player2);
        displayCharacterStats(player2);
        displayBackStory(player2);
        
        misc.startButton();

        int round = 1;
        while(selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0){
                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                System.out.println("                              ╔════════════╗");
                System.out.print("                              ║ "+misc.BOLD+misc.YELLOW+" ROUND: "+round+misc.RESET);
                if(round < 10)System.out.println("  ║");else System.out.println(" ║");
                System.out.println("                              ╚════════════╝");
                round++;
            for(int turn = 10; (selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0) && turn > 0 ;turn--){

                System.out.println("═════════════════════════════════════════════════════════════════════════════════");
                System.out.println("                               ╔══════════╗");
                System.out.print("                               ║"+misc.BOLD+misc.YELLOW+" TURN: "+turn+misc.RESET);
                if(turn < 10)System.out.println("  ║");else System.out.println(" ║");
                System.out.println("                               ╚══════════╝");

                selectedCharacter_1.reduceCooldownAndEffectTurns();
                selectedCharacter_2.reduceCooldownAndEffectTurns();
                
                int chance = misc.getFifthyFifhtyChance();

                if(chance == 0){
                System.out.println("                                Player 1:");

                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    dealDamageCharacter_1ToCharacter_2(misc.getRNG(3, 1));
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                Player 2:");

                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    dealDamageCharacter_2ToCharacter_1(misc.getRNG(3, 1));

                }
                else //50/50
                {
                System.out.println("                                Player 2:");

                    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
                    dealDamageCharacter_2ToCharacter_1(misc.getRNG(3, 1));
                
                if(selectedCharacter_1.getHealth() <= 0 || selectedCharacter_2.getHealth() <= 0) break;

                System.out.println("                                Player 1:");

                    //selectedCharacter_1.addMana(1250);
                    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
                    dealDamageCharacter_1ToCharacter_2(misc.getRNG(3, 1));

                }

                System.out.println("═════════════════════════════════════════════════════════════════════════════════");

            }

            //end while loop
        }
    
    misc.displayCharacterNameHealthAndMana(selectedCharacter_1.getCharacterName(), selectedCharacter_1.getHealth(), misc.getMaxHealth(), selectedCharacter_1.getMana(), misc.getMaxMana());
    misc.displayCharacterNameHealthAndMana(selectedCharacter_2.getCharacterName(), selectedCharacter_2.getHealth(), misc.getMaxHealth(), selectedCharacter_2.getMana(), misc.getMaxMana());
    
    misc.displayEndBattle(selectedCharacter_1.getHealth(), selectedCharacter_2.getHealth());

        //end game main method
    }

}
