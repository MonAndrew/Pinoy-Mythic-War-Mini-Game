public class PlayerVersusPlayer extends CharacterStats {

    private final String playerName[];
    private int health[];
    private int mana[];

    public PlayerVersusPlayer(int n){
        super(n);
        this.playerName = new String[n];
        this.health = new int[n];
        this.mana = new int[n];
    }
    
    public void setCharacterHealthAndMana(int health,int mana,int n){
        this.health[n] = health;
        this.mana[n] = mana;
    }

    public int getPlayerHealth(int n){
        return health[n];
    }
    public int getPlayerMana(int n){
        return mana[n];
    }

    public void displayHealthAndMana(int n){
        System.out.println("HP: "+getPlayerHealth(n)+"/"+getMaxHealth());
        System.out.println("Mana: "+getPlayerMana(n)+"/"+getMaxMana());
    }

}
