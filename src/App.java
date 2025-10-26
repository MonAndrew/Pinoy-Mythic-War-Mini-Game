
import character.Miscellaneous;
import java.nio.charset.Charset;

public class App {
    public static void main(String[] args){
        int maxCharacter = 8;

        Miscellaneous misc = new Miscellaneous();
        PlayerVersusPlayer pvp = new PlayerVersusPlayer();

        misc.displayGameMainScreen();
        misc.addSpace();
        if(misc.displayGamePlayOptions() == 1){
            misc.addSpace();
            pvp.mainPlayerVersusPlayerGame(maxCharacter);

        }else{
            misc.addSpace();
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

