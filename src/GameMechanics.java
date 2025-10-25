import character.CharacterStats;
import character.Character_1;
import character.Character_2;
import character.Character_3;
import character.Character_4;
import character.Character_5;
import character.Character_6;
import character.Character_7;
import character.Character_8; 
import character.Miscellaneous;
import java.util.Random;

public abstract class GameMechanics{
    Miscellaneous misc = new Miscellaneous();
    Random random = new Random();
    CharacterStats character_1 = new Character_1();
    CharacterStats character_2 = new Character_2();
    CharacterStats character_3 = new Character_3();
    CharacterStats character_4 = new Character_4();
    CharacterStats character_5 = new Character_5();
    CharacterStats character_6 = new Character_6();
    CharacterStats character_7 = new Character_7();
    CharacterStats character_8 = new Character_8();
//setters
    abstract public void setPlayerSelectedCharacter(String name,int health, int mana);
    abstract public void setCharacterNormalSkill(String skillName, int min, int max, int manaGain);
    abstract public void setCharacterSkill_1(String skillName, int min,int max, int manaCost);
    abstract public void setCharacterSkill_2(String skillName, int min,int max, int manaCost);

    abstract public void displayCharacterNameHealthAndMana();

    abstract public String getCharacterName();
    abstract public int getHealth();
    abstract public int getMana();
    abstract public int getDamageFromNormaSkill();
    abstract public int getDamageFromSkill_1();
    abstract public int getDamageFromSkill_2();
//battles
    abstract public void minusHealth(int damage);
    abstract public void minusMana(int manaCost);
    abstract public void addHealth(int health);
    abstract public void addMana(int mana);

    
    abstract public void checkHealthAndManaIfBelowZero();

}
class SelectedCharacter_1 extends GameMechanics{
    private String characterName;
    private int health;
    private int mana;

    //attacks
    //normal skill
    private String normalSkillName;
    private int normalSkillminRange;
    private int normalSkillmaxRange;
    private int manaGain;
    //1
    private String skillName1;
    private int minRangeSkill_1;
    private int maxRangeSkill_1;
    private int manaCost1;
    //2
    private String skillName2;
    private int minRangeSkill_2;
    private int maxRangeSkill_2;
    private int manaCost2;

    @Override
    public void setPlayerSelectedCharacter(String name,int health, int mana){
        this.characterName = name;
        this.health = health;
        this.mana = mana;
    }
    @Override
    public void setCharacterNormalSkill(String skillName, int min, int max, int manaGain){
        this.normalSkillName = skillName;
        this.normalSkillminRange = min;
        this.normalSkillmaxRange = max;
        this.manaGain = manaGain;
    }
    @Override
    public void setCharacterSkill_1(String skillName, int min,int max, int manaCost){
        this.skillName1 = skillName;
        this.minRangeSkill_1 = min;
        this.maxRangeSkill_1 = max;
        this.manaCost1 = manaCost;
    }
    @Override
    public void setCharacterSkill_2(String skillName, int min,int max, int manaCost){
        this.skillName2 = skillName;
        this.minRangeSkill_2 = min;
        this.maxRangeSkill_2 = max;
        this.manaCost2 = manaCost;
    }
    @Override
    public void displayCharacterNameHealthAndMana(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Name: " +getCharacterName());

        misc.displayASCIIBars(getHealth());
        System.out.println("\nHealth: ("+getHealth()+"/"+misc.getMaxHealth()+")\n");

        misc.displayASCIIBars(getMana());
        System.out.println("\nMana: ("+getMana()+"/"+misc.getMaxMana()+")");

        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }

    @Override
    public String getCharacterName(){
        return this.characterName;
    }
    @Override
    public int getHealth(){
        return this.health;
    }
    @Override
    public int getMana(){
        return this.mana;
    }
    @Override
    public int getDamageFromNormaSkill(){
        System.out.println("("+this.characterName+") Used: "+this.normalSkillName);
        minusMana(this.manaGain);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.normalSkillminRange - this.normalSkillmaxRange) + 1) + this.normalSkillminRange;
    }
    @Override
    public int getDamageFromSkill_1(){
        System.out.println("("+this.characterName+") Used: "+this.skillName1);
        minusMana(this.manaCost1);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_1 - this.minRangeSkill_1) + 1) + this.minRangeSkill_1;
    }
    @Override
    public int getDamageFromSkill_2(){
        System.out.println("("+this.characterName+") Used: "+this.skillName2);
        minusMana(this.manaCost2);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_2 - this.minRangeSkill_2) + 1) + this.minRangeSkill_2;
    }
  
    //in battle
     @Override
    public void checkHealthAndManaIfBelowZero(){
    
    if(getHealth() < 0) this.health = 0;
    if(getHealth() > misc.getMaxHealth()) this.health = misc.getMaxHealth();
    
    if(getMana() < 0) this.mana = 0;
    if(getMana() > misc.getMaxMana()) this.health = misc.getMaxMana();

    }
    @Override
    public void addHealth(int health){
        System.out.println(" +"+health+" HP: "+this.characterName);
        this.health += health;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void addMana(int mana){
        System.out.println(" +"+mana+" Mana: "+this.characterName);
        this.mana += mana;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void minusHealth(int damage){
        System.out.println(" -"+damage+" HP: "+this.characterName);
        this.health -= damage;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void minusMana(int manaCost){
        System.out.println(" -"+manaCost+" Mana: "+this.characterName);
        this.mana -= manaCost;
        checkHealthAndManaIfBelowZero();
    }

}

/*
 * 
 */

class SelectedCharacter_2 extends GameMechanics{
    private String characterName;
    private int health;
    private int mana;

    //attacks
    //normal skill
    private String normalSkillName;
    private int normalSkillminRange;
    private int normalSkillmaxRange;
    private int manaGain;
    //1
    private String skillName1;
    private int minRangeSkill_1;
    private int maxRangeSkill_1;
    private int manaCost1;
    //2
    private String skillName2;
    private int minRangeSkill_2;
    private int maxRangeSkill_2;
    private int manaCost2;

    @Override
    public void setPlayerSelectedCharacter(String name,int health, int mana){
        this.characterName = name;
        this.health = health;
        this.mana = mana;
    }
    @Override
    public void setCharacterNormalSkill(String skillName, int min, int max, int manaGain){
        this.normalSkillName = skillName;
        this.normalSkillminRange = min;
        this.normalSkillmaxRange = max;
        this.manaGain = manaGain;
    }
    @Override
    public void setCharacterSkill_1(String skillName, int min,int max, int manaCost){
        this.skillName1 = skillName;
        this.minRangeSkill_1 = min;
        this.maxRangeSkill_1 = max;
        this.manaCost1 = manaCost;
    }
    @Override
    public void setCharacterSkill_2(String skillName, int min,int max, int manaCost){
        this.skillName2 = skillName;
        this.minRangeSkill_2 = min;
        this.maxRangeSkill_2 = max;
        this.manaCost2 = manaCost;
    }
    @Override
    public void displayCharacterNameHealthAndMana(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Name: " +getCharacterName());

        misc.displayASCIIBars(getHealth());
        System.out.println("\nHealth: ("+getHealth()+"/"+misc.getMaxHealth()+")\n");

        misc.displayASCIIBars(getMana());
        System.out.println("\nMana: ("+getMana()+"/"+misc.getMaxMana()+")");

        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }

    @Override
    public String getCharacterName(){
        return this.characterName;
    }
    @Override
    public int getHealth(){
        return this.health;
    }
    @Override
    public int getMana(){
        return this.mana;
    }
    @Override
    public int getDamageFromNormaSkill(){
        System.out.println("("+this.characterName+") Used: "+this.normalSkillName);
        minusMana(this.manaGain);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.normalSkillminRange - this.normalSkillmaxRange) + 1) + this.normalSkillminRange;
    }
    @Override
    public int getDamageFromSkill_1(){
        System.out.println("("+this.characterName+") Used: "+this.skillName1);
        minusMana(this.manaCost1);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_1 - this.minRangeSkill_1) + 1) + this.minRangeSkill_1;
    }
    @Override
    public int getDamageFromSkill_2(){
        System.out.println("("+this.characterName+") Used: "+this.skillName2);
        minusMana(this.manaCost2);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_2 - this.minRangeSkill_2) + 1) + this.minRangeSkill_2;
    }
  
    //in battle
     @Override
    public void checkHealthAndManaIfBelowZero(){
    
    if(getHealth() < 0) this.health = 0;
    if(getHealth() > misc.getMaxHealth()) this.health = misc.getMaxHealth();
    
    if(getMana() < 0) this.mana = 0;
    if(getMana() > misc.getMaxMana()) this.health = misc.getMaxMana();

    }
    @Override
    public void addHealth(int health){
        System.out.println(" +"+health+" HP: "+this.characterName);
        this.health += health;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void addMana(int mana){
        System.out.println(" +"+mana+" Mana: "+this.characterName);
        this.mana += mana;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void minusHealth(int damage){
        System.out.println(" -"+damage+" HP: "+this.characterName);
        this.health -= damage;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void minusMana(int manaCost){
        System.out.println(" -"+manaCost+" Mana: "+this.characterName);
        this.mana -= manaCost;
        checkHealthAndManaIfBelowZero();
    }

}
