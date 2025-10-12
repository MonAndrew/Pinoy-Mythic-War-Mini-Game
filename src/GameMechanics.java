//import character.CharacterStats;
//import character.Character_1;
//import character.Character_2;
import character.Miscellaneous;

public abstract class GameMechanics{
    Miscellaneous misc = new Miscellaneous();

    abstract public void setPlayerSelectedCharacter(String name,int health, int mana);
    abstract public String getCharacterName();
    abstract public int getHealth();
    abstract public int getMana();
    abstract public void displayCharacterNameHealthAndMana();
//battles
    abstract public void minusHealth(int damage);
    abstract public void minusMana(int manaCost);
    abstract public void addHealth(int health);
    abstract public void addMana(int mana);

}
class SelectedCharacter_1 extends GameMechanics{
    private String characterName;
    private int health;
    private int mana;

    @Override
    public void setPlayerSelectedCharacter(String name,int health, int mana){
        this.characterName = name;
        this.health = health;
        this.mana = mana;
    }
    @Override
    public void displayCharacterNameHealthAndMana(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Name: " +getCharacterName());

        for(int i=1; i<=getHealth() ;i+=50){
            System.out.print("█ ");
        }
        System.out.println("\nHealth: ("+getHealth()+"/"+misc.getMaxHealth()+")\n");

        for(int i=1; i<=getMana() ;i+=50){
            System.out.print("█ ");
        }
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

    //in battle
    @Override
    public void addHealth(int health){
        System.out.println(" +"+health+" HP ");
        this.health += health;
    }
    @Override
    public void addMana(int mana){
        System.out.println(" -"+mana+" Mana ");
        this.mana += mana;
    }
    @Override
    public void minusHealth(int damage){
        System.out.println(" -"+damage+" HP ");
        this.health -= damage;
    }
    @Override
    public void minusMana(int manaCost){
        System.out.println(" -"+manaCost+" Mana");
        this.mana -= manaCost;
    }

}
class SelectedCharacter_2 extends GameMechanics{
    private String characterName;
    private int health;
    private int mana;

    @Override
    public void setPlayerSelectedCharacter(String name,int health, int mana){
        this.characterName = name;
        this.health = health;
        this.mana = mana;
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

    //in battle
    @Override
    public void addHealth(int health){
        System.out.println(" +"+health+" HP ");
        this.health += health;
    }
    @Override
    public void addMana(int mana){
        System.out.println(" -"+mana+" Mana ");
        this.mana += mana;
    }
    @Override
    public void minusHealth(int damage){
        System.out.println(" -"+damage+" HP ");
        this.health -= damage;
    }
    @Override
    public void minusMana(int manaCost){
        System.out.println(" -"+manaCost+" Mana");
        this.mana -= manaCost;
    }

}