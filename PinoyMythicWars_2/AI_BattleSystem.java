/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PinoyMythicWars_2;
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
            System.out.println("Choose an action:");
            System.out.println("1. Attack");
            System.out.print("Your choice: ");
            int choice = scan.nextInt();

            if (choice == 1) {
                player.attack(enemy);
            } else{
                System.out.println(player.getName() + " hesitated...");
            }

            if (!enemy.isAlive()) break;

            // Enemy's turn
            enemy.attack(player);
            System.out.println();

            player.showStatus();
            enemy.showStatus();
            System.out.println();
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }
    }
    
}
