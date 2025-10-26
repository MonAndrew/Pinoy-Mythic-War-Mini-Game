/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PinoyMythicWars_2;

/**
 *
 * @author junwe
 */
public class Juncoco_Maarti extends CharacterStatsBase{
    
    public Juncoco_Maarti(){
        super("Juncoco Maarti", 1500, 300);
    }
    
    @Override
    public void attack(CharacterStatsBase target) {
        System.out.println(getName() + " attacks " + target.getName() + " for " + attack + " damage!");
        target.takeDamage(attack);
    }
}
