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
        String playerName= "Anonymous";

        System.out.println("Do you want to set Player name?(Y/N)");
        char confirmName = scan.next().charAt(0);

        if(Character.toUpperCase(confirmName) == 'Y')
        playerName = confirmedCustomPlayerName();

        this.playerName_1 = playerName;
    }

    public void setPlayerName_2(){
        String playerName= "Anonymous";

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

    public int getRNG(){
        //(max-min+1) + min
        return random.nextInt(2 - 1) + 1;
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

    public void displayASCIIBars(int bar){
        for(int i=1; i<=bar ;i+=50){
            System.out.print("█ ");
        }
    }

    //user input
    public int characterSelectionTryCatch(int maxCharacter){

        int characterSelection = -1;
        boolean isValidSelection =false;

        do{

        try{
        System.out.print("Select Your Character: ");
        characterSelection = scan.nextInt();
        
        
        if(characterSelection < 1 || characterSelection > maxCharacter){
            throw new ArrayIndexOutOfBoundsException();
            }
           
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Character Selection!");
            isValidSelection = true;
        }catch(InputMismatchException e){
            System.out.println("Invalid Character Selection!");
            scan.nextLine();
            isValidSelection = true;
        }
        if(characterSelection >= 0 && characterSelection < maxCharacter){
        System.out.println("You've Selected: Character #" + (characterSelection));
        isValidSelection = false;
        }     
         
    }while(isValidSelection != false);
    return characterSelection;
    }

    public int enterSkillTryCatch(int from, int to){

        boolean isValidSelection =true;
        int skillNumber = 0;
        do{

        try{
            System.out.println("Enter Skill Number to Use: ");
            skillNumber = scan.nextInt();

            if(skillNumber < 1 || skillNumber > 3){
            throw new ArrayIndexOutOfBoundsException();
            }
            isValidSelection = true; 
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Character Selection!\n");
            isValidSelection = false;
        }catch(InputMismatchException e){
            System.out.println("Invalid Character Selection!\n");
            scan.nextLine();
            isValidSelection = false;
        }
           
    }while(isValidSelection != true);

    return skillNumber;
    } 
    // end of UserInput

    
}
