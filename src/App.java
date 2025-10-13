import character.CharacterStats;
import character.Character_1;
import character.Character_2;
import character.Character_3;
import character.Character_4;
import character.Miscellaneous;

//import java.util.Scanner;
//import java.nio.charset.Charset;

public class App {
    public static void main(String[] args){
       //Scanner scan = new Scanner(System.in);

        int maxCharacter = 2;

        Miscellaneous misc = new Miscellaneous();
        PlayerVersusPlayer pvp = new PlayerVersusPlayer();
        GameMechanics selectedCharacter_1 = new SelectedCharacter_1();
        GameMechanics selectedCharacter_2 = new SelectedCharacter_2();

        CharacterStats character_1 = new Character_1();
        CharacterStats character_2 = new Character_2();
        CharacterStats character_3 = new Character_3();
        CharacterStats character_4 = new Character_4();

        //System.out.println("Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █");

        //int player1 = misc.characterSelectionTryCatch(maxCharacter);
        //int player2 = misc.characterSelectionTryCatch(maxCharacter);
        character_1.setCharacter();
        character_2.setCharacter();
        character_3.setCharacter();
        character_4.setCharacter();

        character_1.displayCharacterStats();
        character_1.displayBackStory();

        character_2.displayCharacterStats();
        character_2.displayBackStory();

        character_3.displayCharacterStats();
        character_3.displayBackStory();

        character_4.displayCharacterStats();
        character_4.displayBackStory();

/*         
        character_1.minusHealth(character_1.getSkill_1());
        character_2.displayCharacterNameHealthAndMana();
        character_2.minusHealth(character_1.getSkill_2());
        character_1.displayCharacterNameHealthAndMana();
        character_2.minusHealth(500);
        character_2.useSupportSkill();
        character_2.displayCharacterNameHealthAndMana();
*/
        //now we implement PVP
        //misc.setPlayerName_1();
        //System.out.println(misc.getPlayerName_1());


        System.out.println("PVP");
        //pvp.setCharacterHealthAndMana(character_1.getHealth(), character_1.getMana(), 0);
        //selectedCharacter_1.displayCharacterNameHealthAndMana();
        pvp.setCharacters(); 
        pvp.mainPlayerVersusPlayerGame();

        /*
        Charset cp437 = Charset.forName("Cp437"); // DOS Extended ASCII
        for (int i = 0; i <= 255; i++) {
            byte[] b = { (byte) i };
            String s = new String(b, cp437);
            System.out.printf("%3d : %s%n", i, s);
        }
        */

       //scan.close();
    }
}

