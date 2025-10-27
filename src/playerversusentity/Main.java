/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playerversusentity;



import java.util.*;

/**
 *
 * @author junwe
 */


public class Main {
    
    
    public void mainPlayerVE(){
        
        Scanner scan = new Scanner(System.in);
        
        int battleType = 0;
        boolean stillGoing = true;
        boolean chooseBattleType = true;
        
        while(chooseBattleType){
            
            try{
                System.out.println("--- Choose Battle Type: ");
                System.out.println("1. P V P ");
                System.out.println("2. P V AI");
                System.out.print("Choose Battle Type: ");
                battleType = scan.nextInt();
                
                chooseBattleType = false;
                
            }catch(Exception e){
                System.out.println("Invalid Input! AT CHOOSEBATTLETYPE " + e);
                scan.next();
            }
        }
        
        if(battleType == 1){
            PVP_BattleSystem battle = new PVP_BattleSystem();
            battle.startBattle();
        }else if(battleType == 2){
            try{
                    int[] wasChoosen = new int[8];
                    int i= 0;
                    
                    //MAKE SURE ALL CHARACTERS START AS NOT CHOOSEN
                    for(i = 0; i < 8; i++){
                        wasChoosen[i] = 0;
                    }
                    AI_BattleSystem battle = new AI_BattleSystem();

                    System.out.println("Choose your character:");
                    System.out.println("1. Juncoco Maarti    5. Zak Rebirto");
                    System.out.println("2. Ruby Galapad      6. CynaMon");
                    System.out.println("3. Jhong Kenario       7. Zaldiko");
                    System.out.println("4. Manny Pacqyow       8. Johnder Ford");
                    System.out.print("Enter choice: ");
                    int choice = scan.nextInt();

                    CharacterStatsBase player = null;
                    CharacterStatsBase enemy;

                    
                //CHOOSING CHARACTER
                switch (choice) {
                    case 1:
                        player = new Juncoco_Maarti();
                        wasChoosen[0] = 1;
                        break;
                    case 2:
                        player = new Ruby_Galapad();
                        wasChoosen[1] = 1;
                        break;
                    case 3:
                        player = new Jhong_Kinario();
                        wasChoosen[2] = 1;
                        break;
                    case 4:
                        player = new Manny_Pacqyow();
                        wasChoosen[3] = 1;
                        break;
                    case 5:
                        player = new Zak_Rebirto();
                        wasChoosen[4] = 1;
                        break;
                    case 6:
                        player = new CynaMon();
                        wasChoosen[5] = 1;
                        break;
                    case 7:
                        player = new Zaldiko();
                        wasChoosen[6] = 1;
                        break;
                    case 8:
                        player = new Johnder_Ford();
                        wasChoosen[7] = 1;
                        break;
                    default:
                        break;
                    }
                    
                    
                    //CHECKING IF THE CHARACTER HAS BEEN CHOOSEN, IF NOT FIGHT THAT CHARACTER
                    if(wasChoosen[0] == 0) {
                        System.out.println();
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Juncoco_Maarti();
                        battle.startBattle(player, enemy);
                        wasChoosen[0] = 1;
                    }
                    if(wasChoosen[1] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Ruby_Galapad();
                        battle.startBattle(player, enemy);
                        wasChoosen[1] = 1;
                    }
                    if(wasChoosen[2] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Jhong_Kinario();
                        battle.startBattle(player, enemy);
                        wasChoosen[2] = 1;
                    }    
                    if(wasChoosen[3] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Manny_Pacqyow();   
                        battle.startBattle(player, enemy);
                        wasChoosen[3] = 1;
                    }
                    if(wasChoosen[4] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Zak_Rebirto();  
                        battle.startBattle(player, enemy);
                        wasChoosen[4] = 1;
                    }
                    if(wasChoosen[5] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new CynaMon();
                        battle.startBattle(player, enemy);
                        wasChoosen[5] = 1;
                    }
                    if(wasChoosen[6] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Zaldiko();
                        battle.startBattle(player, enemy);
                        wasChoosen[6] = 1;
                    }
                    if(wasChoosen[7] == 0){
                        System.out.println("------------------------------------");
                        System.out.println("New Battle Start!!");
                        player.currentHealth = 1500;
                        player.energy = 150;
                        enemy = new Johnder_Ford();
                        battle.startBattle(player, enemy);
                        wasChoosen[7] = 1;
                    }
  

                }catch(Exception e){
                    System.out.println("Invalid input! AT MAIN " + e);
                    scan.next();
            }
        }
        
        
        
       
        scan.close();
    }
}
