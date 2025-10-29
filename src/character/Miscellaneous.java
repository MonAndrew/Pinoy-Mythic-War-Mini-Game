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
    private final int maxMana = 600;
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

    public int getRNG(int max,int min){
        //((max-min)+1) + min
        return random.nextInt((max - min) + 1) + min;
    }

    public int getFifthyFifhtyChance(){
        //((max-min)+1) + min
        return random.nextInt(2);
    }

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

    public void slowPrint(String text){
        int nextline = 0;
        for(char c : text.toCharArray()){
            System.out.print(c);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        
        if(c == ' ' || c == '.')nextline++;
        if(nextline == 10){System.out.println(); nextline = 0;}
        }
    }

    public int additionalCritDamage(int critChance, double critDamageIncrease,int damage){

        int chance = random.nextInt((100 - critChance) + 1) + critChance;
        if(chance <= critChance) {
            int increase = (int)((double)damage*(critDamageIncrease/100));
            damage += increase;
            System.out.println("☁ CRITICAL DAMAGE +"+increase+" ☁");
        }
        return damage;
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
            else if(i == max){ System.out.print("─╖");}
            else
            System.out.print("─");
            
            
            
        }

        System.out.println();
        for(int i=0; i<=max ;i+=25){ 
            if(i == 0){ System.out.print("║");}
            else if(i<=bar && i != 0)System.out.print("█");
            else System.out.print(" ");
            
            if(i == max){ System.out.print("║"); }
        }

        System.out.println();
        for(int i=0; i<=max ;i+=25){ 
            if(i == 0){  System.out.print("╙"); }
            else if(i == max){ System.out.print("─╜");}
            else
            System.out.print("─");
            
            
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

    public int displayGameMainScreen(){
        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░║");
        System.out.println("║                                                                       ║");
        System.out.println("║              █▀█ █ █▄░█ █▀█ █▄█  █▀▄▀█ █▄█ ▀█▀ █_█ █ █▀▀              ║");
        System.out.println("║              █▀  █ █░▀█ █▄█ ░█░  █░▀░█ ░█░  █ ░█░█ █ █▄▄              ║");
        System.out.println("║                                                                       ║");
        System.out.println("║              ▓▓ ██╗    ██╗  █████╗  ██████╗  ███████╗ ▓▓              ║");
        System.out.println("║              ▓▓ ██║    ██║ ██╔══██╗ ██╔══██╗ ██╔════╝ ▓▓              ║");
        System.out.println("║              ▓▓ ██║ █╗ ██║ ███████║ ██████╔╝ ██████╗  ▓▓              ║");
        System.out.println("║              ▓▓ ██║███╗██║ ██╔══██║ ██╔══██╗ ╔══╝ ██  ▓▓              ║");
        System.out.println("║              ▓▓ ╚███╔███╔╝ ██║  ██║ ██║  ██║ ███████╗ ▓▓              ║");
        System.out.println("║              ▓▓  ╚══╝╚══╝  ╚═╝  ╚═╝ ╚═╝  ╚═╝ ╚══════╝ ▓▓              ║");
        System.out.println("║                                                                       ║");
        System.out.println("║░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║    «  From the depths of myth and blood... the war begins anew.  »    ║");
        System.out.println("║          «  A Clash of Gods, Heroes, and COCO MARTIN?!  »             ║");
        System.out.println("║                                                                       ║");
        System.out.println("║               » » »  PRESS  ENTER  TO  BEGIN  « « «                   ║");
        System.out.println("║                                                                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        scan.nextLine();
        return 0;
    }
 
    public int displayGamePlayOptions(){
        
        boolean isValidSelection = false;
        int selection = 1;

    do{

        try{
        
        System.out.println("█████████████████████████████████████████████████████████████████████████");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println();
        System.out.println();
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 1:  PLAYER V PLAYER  ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 2:   ARCADE MODE     ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 3:    SETTINGS       ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println();
        System.out.println("");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println("█████████████████████████████████████████████████████████████████████████");
            
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
        System.out.println("█████████████████████████████████████████████████████████████████████████");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("███▓▓▓                                                             ▓▓▓███");             
        System.out.println("███▓▓▓                                                             ▓▓▓███");
        System.out.println("███▓▓▓                      ╔══════════════╗                       ▓▓▓███");
        System.out.println("███▓▓▓                      ║   INVALID!   ║                       ▓▓▓███");
        System.out.println("███▓▓▓                      ╚══════════════╝                       ▓▓▓███");
        System.out.println("███▓▓▓                                                             ▓▓▓███");
        System.out.println("███▓▓▓                                                             ▓▓▓███");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("█████████████████████████████████████████████████████████████████████████");
    }

    public void displayDeathScreen(){
        //Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █  ─ «  » ╠ ╣ ║ ╦ ╩ ╬ ╗ ╝ ╔ ╚ ═
        System.out.println("█████████████████████████████████████████████████████████████████████████");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███");    
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");

        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░  ╥ ╥ ╓─╖ ╥ ╥   ╥─╖ ╥ ╓── ╥─╖  ░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░  ╚╦╝ ║ ║ ║ ║   ║ ║ ║ ╠═  ║ ║  ░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░   ╨  ╙─╜ ╙─╜   ╨─╜ ╨ ╙── ╨─╜  ░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");

        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███");
        System.out.println("███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███");
        System.out.println("█████████████████████████████████████████████████████████████████████████");
        
    }
    


}
