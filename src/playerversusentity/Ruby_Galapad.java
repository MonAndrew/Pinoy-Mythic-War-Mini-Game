/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playerversusentity;

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
    
    @Override
    public void supportSkill(){
        int cost = 115;
        int healAmount = 200;

        currentHealth += healAmount;
        
        System.out.println(name + " used Ako si Ruby and healed for " + healAmount + " HP!" + "| Updated HP: " + currentHealth);
        
        
    }
    
    @Override
    public void burstSkill(CharacterStatsBase target){
        int cost = 275;
     
        int damage = (int)(attack * 2.5);
        System.out.println(name + " unleashes Final Judgement for " + damage + " damage!");
        target.takeDamage(damage);
    }
}
