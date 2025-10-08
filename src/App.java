import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int maxCharacter = 2;

        CharacterStats characters = new CharacterStats(maxCharacter);
        int baseHP = 1000;
        int baseMana = 250;

        //name , health, mana, attackType, n
        //skill1 name, min, max, manaCost, 
        //skill2 name, min, max, manaCost,
        //supportSkillName, supportSkillType, n
        characters.setCharacterStats("Juncoco Maarti",baseHP,baseMana,2,0);
        characters.setSkills("Labas Dila sabay Putok", 130, 150, 140, "Tataposin na Kita", 175, 250, 215,"YEY HP",1, 0);

        characters.setCharacterStats("Jhong Kenario",baseHP,baseMana,1,1);
        characters.setSkills("Gagamboy", 110, 150, 75, "Backflip kick", 160, 200, 180,"BING BONG",2, 1);
        
        for(int i=0 ; i<maxCharacter; i++){
            characters.displayCharacterStats(i);
        }
        
        //character selection
        System.out.println("\n======================= PLAYER 1 =======================");
        int player1 = characters.characterSelection(maxCharacter);
        characters.displayCharacterStats(player1);

        System.out.println("\n======================= PLAYER 2 =======================");
        int player2 = characters.characterSelection(maxCharacter);
        characters.displayCharacterStats(player2);
        
        int round=1;
        //START BATTLE
        while(characters.getHealth(player1) >= 0 && characters.getHealth(player2) >= 0){

        System.out.println("\n======================= ROUND " + (round) + " ======================");
        round++;

        for(int i=0; i<10 && characters.getHealth(player1) >= 0 && characters.getHealth(player2) >= 0; i++){
        System.out.println("\n======================= TURN " + (i+1) + " =======================");
        
        if(i%2 == 0){
            System.out.println("\n\t\t Player 1's Turn");
            }
        else{
            System.out.println("\n\t\tPlayer 2's Turn");
        }

        if(i%2 == 0){
            characters.displayHealthAndMana(player1);
            characters.enterSkill(player1, player2);
        }else{
            characters.displayHealthAndMana(player2);
            characters.enterSkill(player2, player1);
        }

        }
        //end of battle
        }
        
        characters.displayCharacterStats(player1);
        characters.displayCharacterStats(player2);

        //end
        scan.close();
    }
}

