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
    GameMechanics selectedCharacter_1 = new SelectedCharacter_1();
    GameMechanics selectedCharacter_2 = new SelectedCharacter_2();

    //seems useless also kinda annoying but do i really need this, just to organize the code?
    public void setCharacters(){
        character_1.setCharacter();
        character_2.setCharacter();
    }
    public void dealDamageCharacter_1ToCharacter_2(){
        // to <- from
        selectedCharacter_2.minusHealth(975);

    }

    public void dealDamageCharacter_2ToCharacter_1(){
        // to <- from
        selectedCharacter_1.minusHealth(950);

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
        setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), character_1.getMana());
            return 1;}

            case 2 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), character_2.getMana());
            return 2;}

        }
        return 0;
    }

    public int characterSelection_2(int num){
        setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), character_1.getMana());
            return 1;}

            case 2 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), character_2.getMana());
            return 2;}

        }
        return 0;
    }

    public void mainPlayerVersusPlayerGame(){

        System.out.println("WOw me in? PVP btw");
        int player1 = misc.characterSelectionTryCatch(2);
        System.out.println("Pnum: "+player1);
        int player2 = misc.characterSelectionTryCatch(2);
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
