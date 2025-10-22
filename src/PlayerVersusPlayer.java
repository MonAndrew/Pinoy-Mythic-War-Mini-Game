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
    public void dealDamageCharacter_1ToCharacter_2(){
        // to <- from
        selectedCharacter_2.minusHealth(selectedCharacter_1.getDamageFromSkill_2());

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
            return 2;}

            case 3 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_3.getCharacterName(), character_3.getHealth(), character_3.getMana());
            return 3;}

            case 4 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_4.getCharacterName(), character_4.getHealth(), character_4.getMana());
            return 4;}

            case 5 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_5.getCharacterName(), character_5.getHealth(), character_5.getMana());
            return 5;}

            case 6 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_6.getCharacterName(), character_6.getHealth(), character_6.getMana());
            return 6;}

            case 7 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_7.getCharacterName(), character_7.getHealth(), character_7.getMana());
            return 7;}

            case 8 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_8.getCharacterName(), character_8.getHealth(), character_8.getMana());
            return 8;}

        }
        return 0;
    }

    public int characterSelection_2(int num){
        //setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), character_1.getMana());
            return 1;}

            case 2 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), character_2.getMana());
            selectedCharacter_2.setCharacterNormalSkill(character_2.getNormalSkillName(), character_2.getMinRangeNormalSkill(), character_2.getMaxRangeNormalSkill(), character_2.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_2.getSkillName_1(), character_2.getMinRangeSkill_1(), character_2.getMaxRangeSkill_1(), character_2.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_2.getSkillName_2(), character_2.getMinRangeSkill_2(), character_2.getMaxRangeSkill_2(), character_2.getManaCost2());
            return 2;}

            case 3 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_3.getCharacterName(), character_3.getHealth(), character_3.getMana());
            return 3;}

            case 4 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_4.getCharacterName(), character_4.getHealth(), character_4.getMana());
            return 4;}

            case 5 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_5.getCharacterName(), character_5.getHealth(), character_5.getMana());
            return 5;}

            case 6 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_6.getCharacterName(), character_6.getHealth(), character_6.getMana());
            return 6;}

            case 7 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_7.getCharacterName(), character_7.getHealth(), character_7.getMana());
            return 7;}

            case 8 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_8.getCharacterName(), character_8.getHealth(), character_8.getMana());
            return 8;}

        }
        return 0;
    }

    public void mainPlayerVersusPlayerGame(int maxCharacter){
        setCharacters();

        System.out.println("WOw me in? PVP btw");
        int player1 = misc.characterSelectionTryCatch(maxCharacter);
        System.out.println("Pnum: "+player1);
        int player2 = misc.characterSelectionTryCatch(maxCharacter);
        System.out.println("Pnum: "+player2);
        characterSelection_1(player1);
        characterSelection_2(player2);

        System.out.println("Player 1:");
        selectedCharacter_1.displayCharacterNameHealthAndMana();
        System.out.println("Player 2:");
        selectedCharacter_2.displayCharacterNameHealthAndMana();

        dealDamageCharacter_1ToCharacter_2();
        dealDamageCharacter_2ToCharacter_1();
        System.out.println("Player 1:");
        selectedCharacter_1.displayCharacterNameHealthAndMana();
        System.out.println("Player 2:");
        selectedCharacter_2.displayCharacterNameHealthAndMana();

    }

}
