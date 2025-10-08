import java.util.Random;

public class Miscellaneous {

    Random random = new Random();
    int maxHealth = 1000; 
    int maxMana = 500;

    public int getRNG(){
        //(max-min+1) + min
        return random.nextInt(2 - 1) + 1;
    }

    public int getMaxHealth(){
        return maxHealth;
    }
    public int getMaxMana(){
        return maxMana;
    }
    
}
