package character;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Miscellaneous {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    private String playerName_1;
    private String playerName_2;
    private final int maxHealth = 1000; 
    private final int maxMana = 500;
    //base
    private final int baseHealth = 1000; 
    private final int baseMana = 250;

    public Miscellaneous(){
        this.playerName_1 = "Player_1";
        this.playerName_2 = "Player_2";
    }

    public String confirmedCustomPlayerName(){
        boolean confirm = false;
        String playerName= "Anonymous";

         do{
        System.out.print("Enter Player Name: ");
        playerName = scan.nextLine();
        scan.next();

        System.out.println("Confirm Name?(Y/N)");
        char confirmName = scan.next().charAt(0);

        confirm = (Character.toUpperCase(confirmName) == 'Y') ? true: false;
        }while(!confirm);

        return playerName;
    }

    public void setPlayerName_1(){
        String playerName= "Anonymous " + 1;
        
        System.out.println("Do you want to set Player name?(Y/N)");
        char confirmName = scan.next().charAt(0);

        if(Character.toUpperCase(confirmName) == 'Y')
        playerName = confirmedCustomPlayerName();

            this.playerName_1 = playerName;
    }

    public void setPlayerName_2(){
        String playerName= "Anonymous "+ 2;

        System.out.println("Do you want to set Player name?(Y/N)");
        char confirmName = scan.next().charAt(0);
        
        if(Character.toUpperCase(confirmName) == 'Y')
        playerName = confirmedCustomPlayerName();

            this.playerName_2 = playerName;
    }

    public String getPlayerName_1(){
        System.out.println("?? worked?");
        return this.playerName_1;
    }
    public String getPlayerName_2(){
        return this.playerName_2;
    }

    /*public int getRNG(){
        //(max-min+1) + min
        return random.nextInt(2 - 10) + 1;
    }*/

    public int getMaxHealth(){
        return maxHealth;
    }
    public int getMaxMana(){
        return maxMana;
    }

    public int getBaseHealth(){
        return this.baseHealth;
    }
    public int getBaseMana(){
        return this.baseMana;
    }

    //user input
    public int characterSelectionTryCatch(int maxCharacter){

        int characterSelection = 0;
        boolean isValidSelection =false;

        do{

        try{
        System.out.print("Select Your Character: ");
        characterSelection = scan.nextInt();
        
        
        if(characterSelection < 0 || characterSelection > maxCharacter){
            System.out.println("Invalid Character Selection!");
            isValidSelection = false;
        }else{
            if(characterSelection == 0) characterSelection = random.nextInt(maxCharacter - 1) + 1;
            if(characterSelection >= 1 && characterSelection <= maxCharacter){
            System.out.println("You've Selected: Character #" + (characterSelection));
            isValidSelection = true;
            }
        }
           
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Character Selection!");
            isValidSelection = false;
        }catch(InputMismatchException e){
            System.out.println("Invalid Character Selection!");
            scan.next();
            isValidSelection = false;
        }     
         
    }while(isValidSelection != true);
    return characterSelection;
    }

    public int enterSkillTryCatch(){

        boolean isValidSelection =true;
        int skillNumber = 1;
        do{

        try{
            System.out.println("Enter Skill Number to Use: ");
            skillNumber = scan.nextInt();

            if(skillNumber < 1 || skillNumber > 3){
            System.out.println("Invalid Skill Number Selection!\n");
            isValidSelection = false;
            }
            else
            isValidSelection = true; 
        }catch(InputMismatchException e){
            System.out.println("Invalid Skill Number Selection!\n");
            scan.next();
            isValidSelection = false;
        }
           
    }while(isValidSelection != true);

    return skillNumber;
    } 
    // end of UserInput


    //battle design?? idk
    public void displayASCIIBars(int bar,int max){

        for(int i=0; i<=max ;i+=25){ 
            if(i == 0){  System.out.print("╓"); }
            
            System.out.print("─");
            
            if(i == max){ System.out.print("╖");
            }
        }

        System.out.println();
        for(int i=0; i<=max ;i+=25){ 
            if(i == 0){ System.out.print("║");}

            if(i<=bar && i != 0)System.out.print("█");
            else System.out.print(" ");
            
            if(i == max){ System.out.print("║"); }
        }

        System.out.println();
        for(int i=0; i<=max ;i+=25){ 
            if(i == 0){  System.out.print("╙"); }
            
            System.out.print("─");
            
            if(i == max){ System.out.print("╜");
            }
        }
    }

    public void addSpace(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    //conclusion battle
    public void displayEndBattle(int player1, int player2){

            System.out.println("██████████████████████████████████████████████████████████████");
            System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
            System.out.println("███▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███");    
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        if(player1>player2)
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░ PLAYER 1 WINS! ░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        else if(player1<player2)
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░ PLAYER 2 WINS! ░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        else
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░ T I E ! ░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");

            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
            System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
            System.out.println("███▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███");
            System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
            System.out.println("██████████████████████████████████████████████████████████████");
    }

    public String displayGameMainScreen(){
      //System.out.println(  "══════════════════════════════════════════════════════════");
        System.out.println("█████████████████████████████████████████████████████████████");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("");
        System.out.println("");
        System.out.println("                            TO DO:");
        System.out.println("                 Make Main Screen... idk :))");
        System.out.println("");
        System.out.println("                            press");
        System.out.println("                      » » » ENTER « « «");
        System.out.println("");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.print  ("██████████████████████████████████████████████████████████████");
        String iwantitEMPTY = scan.nextLine();
        return iwantitEMPTY;
    }
    public int displayGamePlayOptions(){
        
        boolean isValidSelection = false;
        int selection = 1;

    do{

        try{

        System.out.println("█████████████████████████████████████████████████████████████");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println();
        System.out.println();
        System.out.println("                    ╔══════════════════════╗");
        System.out.println("                    ║ 1:  PLAYER V PLAYER  ║");
        System.out.println("                    ╚══════════════════════╝");
        System.out.println("                    ╔══════════════════════╗");
        System.out.println("                    ║ 2:   ARCADE MODE     ║");
        System.out.println("                    ╚══════════════════════╝");
        System.out.println();
        System.out.println();
        System.out.println("");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.print  ("██████████████████████████████████████████████████████████████");
            
        selection = scan.nextInt();

            if(selection < 1 || selection > 2){
            displayInvalidScreen();
            isValidSelection = false;

            }
            else
            isValidSelection = true; 

        }catch(InputMismatchException e){
            displayInvalidScreen();
            scan.next();
            isValidSelection = false;
        }
           
    }while(isValidSelection != true);

        return selection;
    }

    public void displayInvalidScreen(){
        System.out.println("██████████████████████████████████████████████████████████████");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("███▓▓▓                                                  ▓▓▓███");             
        System.out.println("███▓▓▓                                                  ▓▓▓███");
        System.out.println("███▓▓▓                  ╔══════════════╗                ▓▓▓███");
        System.out.println("███▓▓▓                  ║   INVALID!   ║                ▓▓▓███");
        System.out.println("███▓▓▓                  ╚══════════════╝                ▓▓▓███");
        System.out.println("███▓▓▓                                                  ▓▓▓███");
        System.out.println("███▓▓▓                                                  ▓▓▓███");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("██████████████████████████████████████████████████████████████");
    }

    public void displayDeathScreen(){
        //Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █  ─ «  » ╠ ╣ ║ ╦ ╩ ╬ ╗ ╝ ╔ ╚ ═
        System.out.println("██████████████████████████████████████████████████████████████");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███");    
        System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");

        System.out.println("███▓▓▓▓▒▒▒░░░░░░  ╥ ╥ ╓─╖ ╥ ╥   ╥─╖ ╥ ╓── ╥─╖  ░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒░░░░░░  ╚╦╝ ║ ║ ║ ║   ║ ║ ║ ╠═  ║ ║  ░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒░░░░░░   ╨  ╙─╜ ╙─╜   ╨─╜ ╨ ╙── ╨─╜  ░░░░░▒▒▒▓▓▓▓███");

        System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("██████████████████████████████████████████████████████████████");
        
    }
    


}
