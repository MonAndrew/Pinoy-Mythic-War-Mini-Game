
import character.Miscellaneous;
import java.util.Scanner;
//import playerversusentity.Main;
//import java.nio.charset.Charset;

public class TurnBasedGame {
    @SuppressWarnings("ConvertToTryWithResources")
    public TurnBasedGame(){
        Scanner scan = new Scanner(System.in);
        int maxCharacter = 8;

        Miscellaneous misc = new Miscellaneous();
        PlayerVersusEntity pve = new PlayerVersusEntity();
        PlayerVersusPlayer pvp = new PlayerVersusPlayer();

        boolean confirmation;
        boolean isLeavingGame = false;
        misc.addSpace();
        misc.displayGameMainScreen();
        misc.addSpace();

        while(isLeavingGame == false){
            int test = misc.displayGamePlayOptions();
            switch(test) {
                case 1 -> {
                    do{
                    misc.addSpace();
                    pvp.mainPlayerVersusPlayerGame(maxCharacter);
                    System.out.print("Play Again?");
                    confirmation = misc.returnTrueOrFalseConfimation();
                    }while(confirmation == true);
                }
                case 2 -> { //PVE
                    do{
                    misc.addSpace();
                    pve.mainPlayerVersusAIGame(maxCharacter);
                    System.out.print("Play Again?");
                    confirmation = misc.returnTrueOrFalseConfimation();
                    }while(confirmation == true);
                }
                case 3 -> { //ARCADE MODE
                    do{
                    misc.addSpace();
                    pve.mainArcadeGameMode(maxCharacter);
                    System.out.print("Play Again?");
                    confirmation = misc.returnTrueOrFalseConfimation();
                    }while(confirmation == true);
                }
                case 4 -> {//options
                    misc.addSpace();
                    misc.displayOptions();
                }
                case 5 -> {//Quit Game
                    misc.addSpace();
                    System.out.print("Leaving Game");
                    misc.slowPrint("..........",120);
                    System.out.println();
                    misc.addSpace();
                    isLeavingGame = true;
                }
                default -> {
                    misc.addSpace();
                    System.out.println("Invalid input!");
                    misc.displayDeathScreen();
                }
            }

            if(test != 5){
            misc.addSpace();
            misc.displayGameMainScreen();
            scan.nextLine();
            misc.addSpace();
            }
        }
        scan.close();
        //System.out.println("Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █  ─ «  » ╠ ╣ ║ ╦ ╩ ╬ ╗ ╝ ╔ ╚ ");
        /*Charset cp437 = Charset.forName("Cp437"); // DOS Extended ASCII
        for (int i = 0; i <= 255; i++) {
        byte[] b = { (byte) i };
        String s = new String(b, cp437);
        System.out.printf("%3d : %s%n", i, s);
        }*/
        

    }
}

