
import character.Miscellaneous;
import playerversusentity.Main;
import java.nio.charset.Charset;

public class App {
    public static void main(String[] args){
        int maxCharacter = 8;

        Miscellaneous misc = new Miscellaneous();
        Main pve = new Main();
        PlayerVersusPlayer pvp = new PlayerVersusPlayer();

        misc.displayGameMainScreen();
        misc.addSpace();
















        
        int test = misc.displayGamePlayOptions();
        if(test == 1){
            misc.addSpace();
            pvp.mainPlayerVersusPlayerGame(maxCharacter);

        }else if (test == 2){
            misc.addSpace();
            pve.mainPlayerVE();

        }else{
            misc.addSpace();
            System.out.println("Options/Settings : kill switch lol(insta kill bots EZ) && credits/groupMembers: ...");
            misc.displayDeathScreen();
        }
 
        //System.out.println("Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █  ─ «  » ╠ ╣ ║ ╦ ╩ ╬ ╗ ╝ ╔ ╚ ");
        
        /*Charset cp437 = Charset.forName("Cp437"); // DOS Extended ASCII
        for (int i = 0; i <= 255; i++) {
            byte[] b = { (byte) i };
            String s = new String(b, cp437);
            System.out.printf("%3d : %s%n", i, s);
        }*/
        

    }
}

