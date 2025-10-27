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
 public class AI_BattleSystem{
    
    public void startBattle(CharacterStatsBase player, CharacterStatsBase enemy) {

        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("\n--- BATTLE START ---");
        player.showStatus();
        enemy.showStatus();
        System.out.println("--------------------\n");

        while (player.isAlive() && enemy.isAlive()){
            boolean choose = false;
            
            while(!choose){
                try{
                    System.out.println("Choose an action:");
                    System.out.println("1. Attack");
                    System.out.println("2. Support skill -> Cost 115");
                    System.out.println("3. Burst Attack -> Cost 275");
                    System.out.print("Your choice: ");
                    
                    int choice = scan.nextInt();
                    
                    if(choice == 1) {
                        player.attack(enemy);
                        choose = true;
                    }else if(choice == 2){
                        if(player.consumeEnergy(115)){
                            player.supportSkill();
                            choose = true;
                        }
                    }else if(choice == 3){
                        if(player.consumeEnergy(275)){
                            player.burstSkill(enemy);
                            choose = true;  
                        }
                    }else{
                        choose = false;
                    }
                    
                }catch(Exception e){
                    System.out.println();
                    scan.next();
                }
            }
            
            choose = false;
            

            if (!enemy.isAlive()){
                break;
            }
            
            // Enemy's turn
            Random ranNum = new Random();
            
            while(!choose){
                try{
                    int enemyChoice = ranNum.nextInt(3) + 1;
                    
                    if(enemyChoice == 1) {
                        enemy.attack(player);
                        enemy.energy += 75;
                        System.out.println(enemy.getName() + " enery go up by 75");
                        choose = true;
                    }else if(enemyChoice == 2){
                        if(enemy.consumeEnergy(115)){
                            enemy.supportSkill();
                            choose = true;
                        }else{
                            System.out.println(enemy.getName() + " bro tried to use support skill! But running low so bro just attack instead");
                            enemy.attack(player);
                            enemy.energy += 75;
                            System.out.println(enemy.getName() + " gains 75 energy (" + enemy.energy + "/" + "500)");
                            choose = true;
                        }
                    }else if(enemyChoice == 3){
                        if(enemy.consumeEnergy(275)){
                            enemy.burstSkill(player);
                            choose = true;  
                        }else{
                            System.out.println(enemy.getName() + " bro tried to use burst skill! But running low so bro just attack instead");
                            enemy.attack(player);
                            enemy.energy += 75;
                            System.out.println(enemy.getName() + " gains 75 energy (" + enemy.energy + "/" + "500)");
                            choose = true;
                        }
                    }else{
                        choose = false;
                    }
                    
                }catch(Exception e){
                    System.out.println();
                    scan.next();
                }
            }
            
            
            
            System.out.println();

            player.showStatus();
            enemy.showStatus();
            System.out.println();
        }
        
        
        
        System.out.println();
        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }
        
        System.out.println("END OF BATTLE!");
    }
    
}
