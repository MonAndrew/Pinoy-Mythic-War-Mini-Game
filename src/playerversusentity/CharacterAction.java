/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playerversusentity;

/**
 *
 * @author junwe
 */
public interface CharacterAction {
    
    public void attack(CharacterStatsBase target);
    public void supportSkill();
    public void burstSkill(CharacterStatsBase target);
    public void takeDamage(int damage);
    public boolean isAlive();
    public void showStatus();
    
}
