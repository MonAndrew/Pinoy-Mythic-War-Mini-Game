/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PinoyMythicWars_2;

/**
 *
 * @author junwe
 */
public class Ruby_Galapad extends CharacterStatsBase{
    
    
    public Ruby_Galapad(){
        super("Ruby Galapad", 1500, 300);
    }

    @Override
    public void attack(CharacterStatsBase target) {
        System.out.println(name + " attacks " + target.getName() + " for " + attack + " damage!");
        target.takeDamage(attack);
    }
}
