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
    
    public void displayCharacters(){
        System.out.println(character_1.getCharacterName());
        System.out.println(character_2.getCharacterName());
        System.out.println(character_3.getCharacterName());
        System.out.println(character_4.getCharacterName());
        System.out.println(character_5.getCharacterName());
        System.out.println(character_6.getCharacterName());
        System.out.println(character_7.getCharacterName());
        System.out.println(character_8.getCharacterName());
    } 

    
    public int skillNumberForSelectedCharacter_1(int skillnum){
     
    int dmg = 0;
     
    switch(skillnum){
     
    case 1 -> { dmg  =  selectedCharacter_1.getDamageFromNormaSkill(); 
    } 
    case 2 -> { dmg  = selectedCharacter_1.getDamageFromSkill_1(); 
    } 
    case 3 -> { dmg  = selectedCharacter_1.getDamageFromSkill_2(); 
    }

    }
    //motin        
    return dmg;
    }

    public int skillNumberForSelectedCharacter_2(int skillnum){
     
    int dmg = 0;
     
    switch(skillnum){
     
    case 1 -> { dmg  =  selectedCharacter_2.getDamageFromNormaSkill(); 
    } 
    case 2 -> { dmg  = selectedCharacter_2.getDamageFromSkill_1(); 
    } 
    case 3 -> { dmg  = selectedCharacter_2.getDamageFromSkill_2(); 
    }

    }
    //motin        
    return dmg;
    }
    
    public void dealDamageCharacter_1ToCharacter_2(int skillnum){

        // to <- from
        selectedCharacter_2.minusHealth( skillNumberForSelectedCharacter_1(skillnum) );

    }

    public void dealDamageCharacter_2ToCharacter_1(){
        // to <- from
        selectedCharacter_1.minusHealth(selectedCharacter_2.getDamageFromSkill_1());
        

        /*call tryCatchEnterskill() return num
         * switchcase method(num)
         * Damage = 0;
         * {
         * case 1 -> Damage = Normalskill()
         * case 2 -> Damage = Skill_1()
         * case 3 -> Damage = Skill_2()
         * }
         * // now for the buff? how am i gonna add extra dmg? just incase
         * //now how would i know if i would call the buff or debuff?
         * extra = 0;
         * extra
         * return damage + (buff) and can be (-debuff);
         * damage + (+Positive Number) || (-Negative)
         * 
         * real return
         * return Damage + (extra);
         * 
         */

    }

    public void mainPlayerVersusPlayerGame(int maxCharacter){
        setCharacters();

        displayCharacters();

        System.out.println("WOw me in? PVP btw");
        int player1 = misc.characterSelectionTryCatch(maxCharacter);
        System.out.println("Pnum: "+player1);
        int player2 = misc.characterSelectionTryCatch(maxCharacter);
        System.out.println("Pnum: "+player2);
        characterSelection_1(player1);
        characterSelection_2(player2);

        while(selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0){

            for(int turn = 10; (selectedCharacter_1.getHealth() > 0 && selectedCharacter_2.getHealth() > 0) && turn > 0 ;turn--){

                System.out.println("                                  TURN: "+turn);

                if(turn % 2 == 0){
                    System.out.println("Player 1:");
                    selectedCharacter_1.displayCharacterNameHealthAndMana();
                    dealDamageCharacter_1ToCharacter_2(misc.enterSkillTryCatch());
                }else{
                    System.out.println("Player 2:");
                    selectedCharacter_2.displayCharacterNameHealthAndMana();
                    dealDamageCharacter_2ToCharacter_1();

                }

            }

            //end while loop
        }
        
    misc.displayEndBattle(selectedCharacter_1.getHealth(), selectedCharacter_2.getHealth());

        //end game main method
    }

}
