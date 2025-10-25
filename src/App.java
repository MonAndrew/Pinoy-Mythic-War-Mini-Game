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

//import java.util.Scanner;
//import java.nio.charset.Charset;

public class App {
    public static void main(String[] args){
       //Scanner scan = new Scanner(System.in);

        int maxCharacter = 8;

        Miscellaneous misc = new Miscellaneous();
        PlayerVersusPlayer pvp = new PlayerVersusPlayer();
        //GameMechanics selectedCharacter_1 = new SelectedCharacter_1();
        //GameMechanics selectedCharacter_2 = new SelectedCharacter_2();

        CharacterStats character_1 = new Character_1();
        CharacterStats character_2 = new Character_2();
        CharacterStats character_3 = new Character_3();
        CharacterStats character_4 = new Character_4();
        CharacterStats character_5 = new Character_5();
        CharacterStats character_6 = new Character_6();
        CharacterStats character_7 = new Character_7();
        CharacterStats character_8 = new Character_8();

        //System.out.println("Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █");
        pvp.setCharacters();

        //now we implement PVP
        //misc.setPlayerName_1();
        //System.out.println(misc.getPlayerName_1());


        System.out.println("PVP");
        //pvp.setCharacterHealthAndMana(character_1.getHealth(), character_1.getMana(), 0);
        //selectedCharacter_1.displayCharacterNameHealthAndMana();
        pvp.setCharacters(); 
        pvp.mainPlayerVersusPlayerGame(8);

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

