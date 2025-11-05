package character;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Miscellaneous {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();


    // Text colors
    public final String RESET = "\u001B[0m";
    public final String RED = "\u001B[31m";
    public final String GREEN = "\u001B[32m";
    public final String YELLOW = "\u001B[33m";
    public final String BLUE = "\u001B[34m";
    public final String PURPLE = "\u001B[35m";
    public final String CYAN = "\u001B[36m";
    public final String WHITE = "\u001B[37m";
    public final String BOLD = "\u001B[1m";

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
    public boolean returnTrueOrFalseConfimation(){
        boolean isValidSelection = false;
        boolean confirmation = true;

        while(isValidSelection == false){
            try{
                System.out.print("(Y/N)");
                char c = scan.next().charAt(0);

                switch(Character.toUpperCase(c)){
                    case 'Y' -> {confirmation = true; isValidSelection = true;}
                    case 'N' -> {confirmation = false; isValidSelection = true;}
                    default -> {
                        System.out.println("Invalid Input");
                        isValidSelection = false;
                    }
                }
            }catch(InputMismatchException e){
                displayInvalidScreen();
                scan.next();
            }
        }

        return confirmation;
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
                Thread.sleep(10);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        
        if(c == ' ' || c == '.')nextline++;
        if(nextline == 10){System.out.println(); nextline = 0;}
        }
    }
    public void displayCharacterNameHealthAndMana(String name,int currentHp,int maxHp,int currentMana,int maxMana){
        System.out.println();
        //System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Name: " +name);

        displayASCIIBars(currentHp,maxHp);
        System.out.println(BOLD+RED+"\nHealth: ("+currentHp+"/"+maxHp+")\n"+RESET);

        displayASCIIBars(currentMana,maxMana);
        System.out.println(BOLD+BLUE+"\nMana: ("+currentMana+"/"+maxMana+")"+RESET);

        //System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }

    public int additionalCritDamage(int critChance, double critDamageIncrease,int damage){

        int chance = random.nextInt((100 - critChance) + 1) + critChance;
        if(chance <= critChance) {
            int increase = (int)((double)damage*(critDamageIncrease/100));
            damage += increase;
            System.out.println(BOLD+RED+"**"+YELLOW+" CRITICAL DAMAGE +"+increase+RED+" **"+RESET);
        }
        return damage;
    }

    //user input
    public int characterSelectionTryCatch(int maxCharacter){

        int characterSelection = 0;
        boolean isValidSelection =false;
        boolean isConfirm = false;

        do{
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

        isValidSelection = false;

        while(!isValidSelection){
            try{
                System.out.print("Confirm Character selected?(Y/N)");
                char c = scan.next().charAt(0);

                switch(Character.toUpperCase(c)){
                    case 'Y' -> {isConfirm = true; isValidSelection = true;}
                    case 'N' -> 
                    {isConfirm = false; isValidSelection = true;}
                    default -> {
                        System.out.println("Invalid Input");
                        isConfirm = false; isValidSelection = false;
                    }
                }
            }catch(InputMismatchException e){
                displayInvalidScreen();
                scan.next();
            }
        }
       
    }while(isConfirm == false);

    System.out.println("You've Selected: Character #" + (characterSelection));
    return characterSelection;
    }

    public int enterSkillTryCatch(){

        boolean isValidSelection = true;
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
    public int startButton(){
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ "+RED+"PRESS ENTER TO START "+RESET+"║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println();
        scan.nextLine();
        scan.nextLine();
        return 0;
    }

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
            else if(i<=bar && i != 0){

                if(bar > (max*0.5))System.out.print(GREEN+"█"+RESET);
                else if(bar > (max*0.25))System.out.print(YELLOW+"█"+RESET);
                else System.out.print(RED+"█"+RESET);
            }
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
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 1:  PLAYER V PLAYER  ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 2:  PLAYER V ENTITY  ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 3:   ARCADE MODE     ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 4:    SETTINGS       ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("                         ╔══════════════════════╗");
        System.out.println("                         ║ 5:    QUIT GAME      ║");
        System.out.println("                         ╚══════════════════════╝");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.print  ("█████████████████████████████████████████████████████████████████████████");
            
        selection = scan.nextInt();

            if(selection < 1 || selection > 5){
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
