/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playerversusentity;

/**
 *
 * @author junwe
 */
public abstract class CharacterStatsBase implements CharacterAction{
    
    protected String name;
    
    protected int maxHealth;
    protected int currentHealth;
    protected int attack;
    
    protected int energy;
    protected int maxEnergy = 500;
    
    protected boolean isAlive = true;
    
    
    
    
    public CharacterStatsBase(String name, int maxHealth, int attack){
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.attack = attack;
        this.energy = 150;
    }
    
    public void gainEnergy(int amount){
        energy += amount;
                
        if(energy >= maxEnergy){
            energy = maxEnergy;
        }
        
        System.out.println(name + " gains " + amount + " energy (" + energy + "/" + maxEnergy + ")" );
    }
    
    public boolean consumeEnergy(int amount){
        if(energy >= amount){
            energy -= amount;
            System.out.println(name + " used " + amount + " energy (" + energy + "/" + maxEnergy + ")" );
            return true;
        }else{
            System.out.println(name + " does not have any energy!");
            return false;
        }
    }
    
    public boolean canSkill(){
        if(energy > 115){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean canBurst(){
        if(energy > 275){
            return true;
        }else{
            return false;
        }
    }
    
    
    @Override
    public void takeDamage(int damage){
        currentHealth -= damage;
        if (currentHealth <= 0) {
            currentHealth = 0;
            isAlive = false;
        }
        System.out.println(name + " now has " + currentHealth + " left!");
    }
    
    @Override
    public abstract void attack(CharacterStatsBase target);
    
    @Override
    public abstract void supportSkill();
    
    @Override
    public abstract void burstSkill(CharacterStatsBase target);

   
    
    @Override
    public boolean isAlive(){
        return isAlive;
    }


    @Override
    public void showStatus(){
        System.out.println(name + " — HP: " + currentHealth + "/" + maxHealth + " | ATK: " + attack + " | Energy: " + energy + " | Alive: " + isAlive);
    }

    public String getName(){
        return name;
    }

    public int getAttack(){
        return attack;
    }
    
    public int getHealth(){
        return currentHealth;
    }
    
    
    
}
