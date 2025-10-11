import character.CharacterStats;
import character.Character_1;
import character.Character_2;
import character.Miscellaneous;

public abstract class GameMechanics{
    Miscellaneous misc = new Miscellaneous();

    abstract void setPlayerSelectedCharacter(String name,int health, int mana);
    abstract String getCharacterName();
    abstract int getHealth();
    abstract int getMana();
    abstract void displayCharacterNameHealthAndMana();

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

}