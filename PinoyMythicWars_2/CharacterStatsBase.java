/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PinoyMythicWars_2;

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
    protected boolean isAlive = true;
    
    
    
    public CharacterStatsBase(String name, int maxHealth, int attack){
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.attack = attack;
    }
    
    
    
    @Override
    public void takeDamage(int damage) {
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
    public boolean isAlive(){
        return isAlive;
    }


    @Override
    public void showStatus() {
        System.out.println(name + " — HP: " + currentHealth + "/" + maxHealth + " | ATK: " + attack + " | Alive: " + isAlive);
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
    
    
    
}
