import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterStats extends Miscellaneous{
    Scanner scan = new Scanner(System.in);
   //basic stats
    private final String Charactername[];
    private final int health[];
    private final int mana[];
    //attacks
    private final int attackType[];
    private final String attackName1[];
    private final int skill1minRange[];
    private final int skill1maxRange[];
    private final int manaCost1[];
    //2
    private final String attackName2[];
    private final int skill2minRange[];
    private final int skill2maxRange[];
    private final int manaCost2[];
    //support skill
    private final String supportSkillName[];
    private final int supportSkillType[];

    public CharacterStats(int n){
        //basic stats
        this.Charactername = new String[n];
        this.health = new int[n];
        this.mana = new int[n];
        //attacks
        this.attackType = new int[n];
        //skill1
        this.attackName1 = new String[n];
        this.skill1minRange = new int[n];
        this.skill1maxRange = new int[n];
        this.manaCost1 = new int[n];
        //skill2
        this.attackName2 = new String[n];
        this.skill2minRange = new int[n];
        this.skill2maxRange = new int[n];
        this.manaCost2 = new int[n];
        //support skill
        this.supportSkillName = new String[n];
        this.supportSkillType = new int[n];
        
    }

    public void setCharacterStats(String Charactername,int health,int mana,int attackType,int n){
        this.Charactername[n] = Charactername;
        this.health[n] = health;
        this.mana[n] = mana;
        this.attackType[n] = attackType;
    }
    public void setSkills(String attackName1, int min1, int max1,int manaCost1,String attackName2, int min2, int max2,int manaCost2,String supportSkillName, int supportSkillType, int n){
        //skill 1
        this.attackName1[n] = attackName1;
        this.skill1minRange[n] = min1;
        this.skill1maxRange[n] = max1;
        this.manaCost1[n] = manaCost1;
        //skill 2
        this.attackName2[n] = attackName2;
        this.skill2minRange[n] = min2;
        this.skill2maxRange[n] = max2;
        this.manaCost2[n] = manaCost2;
        //support skill
        this.supportSkillName[n] = supportSkillName;
        this.supportSkillType[n] = supportSkillType;
    }
    
    public void displayCharacterStats(int n){
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("\t\t\t  CHARACTER: " + (n+1));
        System.out.println("Name: " + this.Charactername[n]);

        for(int i=1; i<=this.health[n]; i+=50){
            System.out.print("\u2610");
        }

        System.out.println("\nHealth: "+this.health[n]);

        for(int i=1; i<=this.mana[n]; i+=50){
            System.out.print("\u2610");
        }

        System.out.println("\nMana: "+this.mana[n]);
        System.out.println("\t\t\t SKILLS:");
        System.out.println("(" + this.attackName1[n]+"): Damage: "+this.skill1minRange[n]+"-"+this.skill1maxRange[n]+", Mana Cost: "+this.manaCost1[n]);
        System.out.println("(" + this.attackName2[n]+"): Damage: "+this.skill2minRange[n]+"-"+this.skill2maxRange[n]+", Mana Cost: "+this.manaCost2[n]);
        System.out.println("(" + this.supportSkillName[n]+"): ???");

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    public void setHealthToFixedValue(int n,int health){
        this.health[n] = health;
    }
    public void setManaToFixedValue(int n,int mana){
        this.mana[n] = mana;
    }
    public String getCharacterName(int n){
        return this.Charactername[n];
    }
    public int getHealth(int n){
        return this.health[n];
    }
    public int getMana(int n){
        return this.mana[n];
    }
    public int getSkill1MinRange(int n){
        return this.skill1minRange[n];
    }
    public int getSkill1MaxRange(int n){
        return this.skill1maxRange[n];
    }
    public int getManaCost1(int n){
        return this.manaCost1[n];
    }
    public int getSkill2MinRange(int n){
        return this.skill2minRange[n];
    }
    public int getSkill2MaxRange(int n){
        return this.skill2maxRange[n];
    }
    public int getManaCost2(int n){
        return this.manaCost2[n];
    }
    public int getSupportSkillType(int n){
        return this.supportSkillType[n];
    }

    public int getDamage(int n,int skillnumber){
        int damage = returnDamage(n, skillnumber);
        return damage;
    }
    //add and minus

    public void addHealth(int n, int addHealth){
        this.health[n]+= addHealth;
    }
    public void addMana(int n,int addMana){
        this.mana[n]+= addMana;
    }

    public void minusHealth(int n, int minusHealth){
        this.health[n]-= minusHealth;
    }
    public void minusMana(int n,int minusMana){
        this.mana[n]-= minusMana;
    }

    /*
     * 
     */
    //I guess u could call below of this are the mechanics
    //check and display
    public void checkHealth(int n){
        if(getHealth(n) < 0)
            setHealthToFixedValue(n, 0);
        
        if(getHealth(n) > getMaxHealth()){
            System.out.println("Health is Full!");
            setHealthToFixedValue(n, getMaxHealth());//1000
            }
    }

    public void checkMana(int n){
        if(getMana(n) < 0)
            setManaToFixedValue(n, 0);
            
        if(getMana(n)>getMaxMana()){
            setManaToFixedValue(n, getMaxMana());//500
            System.out.println("Mana is Full!");
            }
    }

    public boolean isEnoughMana(int skillNumber, int n){
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        if(skillNumber == 1){
            if(getMana(n) >= getManaCost1(n))
                return true;
            else{
                System.out.println(" Not Enough Mana!");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                return false;
                }
        }else{
            if(getMana(n) >= getManaCost2(n))
                return true;
            else{
                System.out.println(" Not Enough Mana!");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                return false;
                }
        }
        
    }
    
    public void displayHealth(int n){
        System.out.println("\n"+getCharacterName(n)+ "'s Health: "+getHealth(n));

        if(getHealth(n) <= 0){
            System.out.println(getCharacterName(n) + " has been defeated!");
        }
    }

    public void displayMana(int n){
        checkMana(n);
        if(getMana(n) <= 0){
            System.out.println(getCharacterName(n) + " is Out of Mana!");
        }
        System.out.println("\n"+getCharacterName(n) + "'s Mana: "+getMana(n));
    }
    /* 
    public void displayHealthAndMana(int n){
        System.out.println("HP: "+getHealth(n)+"/"+getMaxHealth());
        System.out.println("Mana: "+getMana(n)+"/"+getMaxMana());
    }*/

    public void displayEndBattle(int player1, int player2){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n\n");
        if(getHealth(player1)>getHealth(player2))
            System.out.println("\t\t PLAYER 1 WINS!");
        else if(getHealth(player1)<getHealth(player2))
            System.out.println("\t\t PLAYER 2 WINS!");
        else
            System.out.println("\t\t\t TIE!");
        System.out.println("\n\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    
    public void displaySkillTypeNameUsed(int skillNumber,int n){
        System.out.print(this.Charactername[n] + " Used: ");
        switch(skillNumber) {
            case 1 -> System.out.println(this.attackName1[n]);
            case 2 -> System.out.println(this.attackName2[n]);
            case 3 -> System.out.println(this.supportSkillName[n]);
            default -> System.out.println("You broke something dude, its supposed to try catch");
        }
    }

    public int returnDamage(int skillNumber, int n){
        //int damage = 0;

        if(skillNumber == 1){
            return random.nextInt((getSkill1MaxRange(n) - getSkill1MinRange(n)) + 1) + getSkill1MinRange(n);
            //return damage; 
        }else{
            return random.nextInt((getSkill2MaxRange(n) - getSkill2MinRange(n)) + 1) + getSkill2MinRange(n);
            //return damage;
        }
    }

    public void reduceMana(int skillNumber, int n){
        if(skillNumber == 1)
            minusMana(n, getManaCost1(n));
        else
            minusMana(n, getManaCost2(n));
    }

    //testing support skill
    public void recoverMana(int n){
        System.out.println("Mana Recovered by 50");
        addMana(n, 50);
        checkMana(n);
    }
    //attack
    public void dealDamage(int skillNumber,int from, int to){
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        int damage = returnDamage(skillNumber, from);
        
        displaySkillTypeNameUsed(skillNumber, from);

        System.out.println(""+getCharacterName(from) + " dealt " + damage + " damage to " + getCharacterName(to));
        //System.out.println("Deducting " + damage +" from "+this.name[to]+" HP!");
        
        //deal damage
        this.health[to] -= damage;
        checkHealth(to);
        displayHealth(to);

        //mana from dealer
        reduceMana(skillNumber, from);
        //checkMana(from);
        displayMana(from);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public void getSupportSkill(int n,int skillNumber){

        int tempDamage = returnDamage(skillNumber, n);
        /*to get attack 
         * call returnDamage()get the 15% or so 
         * return the 15%
         * BUUTTTT???? how to do i return damage if it is void?
         * we i mean me and my head make function that calls for damage
         * like addDamage(n,skillnumber){
         * temp = returnDamage(skillnumber,n)
         * return temp+(temp*0.15);
         * }
         */

        switch(n){
            case 1 -> {addHealth(n,(int)(getMaxHealth() * 0.05)); addMana(n, (int)(getMaxMana()*0.10));}//HP 5% up && Energy 10% up 
            case 2 -> {addHealth(n,(int)(getMaxHealth() * 0.15)); minusMana(n, (int)(getMaxMana()*0.17));}//HP 15% up && Energy 10% up
            case 3 ->{}//ATK 15%up && HP 17%down
            case 4 ->{}//HP 15%up && ATK 17%down
        }
    }

    public void skillUsed(int skillNumber,int from, int to){
        switch (skillNumber) {
            case 1,2 ->{
            if(isEnoughMana(skillNumber, from))
                dealDamage(skillNumber, from, to);
            }
            case 3 -> {getSupportSkill(from,skillNumber); checkHealth(from);}//recoverMana(from);

            default -> System.out.println("You broke something dude, its supposed to try catch");
        }
    }

    //user input
    public int characterSelection(int maxCharacter){

        int characterSelection = -1;
        boolean isValidSelection =false;

        do{

        try{
        System.out.print("Select Your Character: ");
        characterSelection = scan.nextInt();
        characterSelection -= 1;
        
        if(characterSelection < 0 || characterSelection >= maxCharacter){
            throw new ArrayIndexOutOfBoundsException();
            }
           
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Character Selection!");
            isValidSelection = true;
        }catch(InputMismatchException e){
            System.out.println("Invalid Character Selection!");
            scan.nextLine();
            isValidSelection = true;
        }
        if(characterSelection >= 0 && characterSelection < maxCharacter){
        System.out.println("You've Selected: Character #" + (characterSelection + 1));
        isValidSelection = false;
        }     
         
    }while(isValidSelection != false);
    return characterSelection;
    }

    public void enterSkill(int from, int to){

        boolean isValidSelection =true;
        do{

        try{
            System.out.println("Enter Skill Number to Use: ");
            int skillNumber = scan.nextInt();

            if(skillNumber < 1 || skillNumber > 3){
            throw new ArrayIndexOutOfBoundsException();
            }

            displaySkillTypeNameUsed(skillNumber, from);
            skillUsed(skillNumber, from, to);
            isValidSelection = true;

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Character Selection!\n");
            isValidSelection = false;
        }catch(InputMismatchException e){
            System.out.println("Invalid Character Selection!\n");
            scan.nextLine();
            isValidSelection = false;
        }
           
         
    }while(isValidSelection != true);
    }

}

