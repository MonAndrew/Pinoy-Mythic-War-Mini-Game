/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PinoyMythicWars_2;

/**
 *
 * @author junwe
 */
public class CynaMon extends CharacterStatsBase{
    
    public CynaMon(){
        super("CynaMon", 1500, 300);
    }

    @Override
    public void attack(CharacterStatsBase target) {
        System.out.println(name + " attacks " + target.getName() + " for " + attack + " damage!");
        target.takeDamage(attack);
    }
}
