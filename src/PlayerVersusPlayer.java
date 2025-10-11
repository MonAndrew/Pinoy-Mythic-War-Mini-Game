import character.CharacterStats;
import character.Character_1;
import character.Character_2;
import character.Miscellaneous;

class PlayerVersusPlayer{
    Miscellaneous misc = new Miscellaneous();
    CharacterStats character_1 = new Character_1();
    CharacterStats character_2 = new Character_2();
    GameMechanics selectedCharacter_1 = new SelectedCharacter_1();
    GameMechanics selectedCharacter_2 = new SelectedCharacter_2();

    public void dealDamage(){

    }

    public int characterSelection(int num){
        switch(num){

            case 1 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), character_1.getMana());}

            case 2 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), character_2.getMana());}

        }
        return 0;
    }

    public void mainPlayerVersusPlayerGame(){

        System.out.println("WOw me in?");
        //int player1 = characterSelection(misc.characterSelectionTryCatch(2));
        selectedCharacter_1.displayCharacterNameHealthAndMana();

    }

}
