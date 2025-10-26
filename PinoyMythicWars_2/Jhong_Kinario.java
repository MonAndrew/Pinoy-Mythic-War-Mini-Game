/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PinoyMythicWars_2;

/**
 *
 * @author junwe
 */
public class Jhong_Kinario extends CharacterStatsBase{
    
    public Jhong_Kinario(){
        super("Jhong Kinario", 1500, 300);
    }

    @Override
    public void attack(CharacterStatsBase target) {
        System.out.println(name + " attacks " + target.getName() + " for " + attack + " damage!");
        target.takeDamage(attack);
    }
}
