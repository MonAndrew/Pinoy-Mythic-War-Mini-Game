package character;

public class Character_1 extends Miscellaneous implements CharacterStats{
Miscellaneous misc = new Miscellaneous();

    private String characterName;
    private int health;
    private int mana;
    //attacks
    private String skillName1;
    private int skill1minRange;
    private int skill1maxRange;
    private int manaCost1;
    //2
    private String skillName2;
    private int skill2minRange;
    private int skill2maxRange;
    private int manaCost2;
    //support skill
    private String supportSkillName;
    private double buff;
    private double debuff;

    @Override
    public void setCharacter(){
        setCharacterName("Juncoco Maarti");
        setCharacterStats(super.getBaseHealth(), super.getBaseMana());
        setCharacterSkill_1("Labas Dila sabay Putok", 130, 150, 140);
        setCharacterSkill_2("Tataposin na Kita", 175, 250, 250);
        setCharacterSupportSkill("YumYUmYum",0.17, 0.10);
    }
    @Override
    public void displayBackStory(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");

        System.out.println("("+getCharacterName()+") Backstory:");
        System.out.println("A great actor who loves to make movies, doing exclusive massage sessions, and Filipino Teleseryes. \nBeloved by all Filipinos for his strength in the film he portrays, and for being sweet in real life. \nHe is capable of inspiring the younger generations and is willing to work with other people, despite their gender or background. \nOne day, he thought of making a new horror movie where people are being hunted down by something unexplainable, when suddenly \na mist of clouds suddenly appeared, and he was never seen again.");

        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }

    @Override
    public void displayCharacterStats(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                     STATS: ");

        displayCharacterNameHealthAndMana();

        System.out.println("                                     SKILLS: ");
        System.out.println("(" + this.skillName1+"): Damage: "+this.skill1minRange+"-"+this.skill1maxRange+", Mana Cost: "+this.manaCost1);
        System.out.println("(" + this.skillName2+"): Damage: "+this.skill2minRange+"-"+this.skill2maxRange+", Mana Cost: "+this.manaCost2);
        System.out.println("(" + this.supportSkillName+"): ???");

        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
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

    //setters
    @Override
    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }
    @Override
    public void setCharacterStats(int health, int mana){
        this.health = health;
        this.mana = mana;
    }
    @Override
    public void setCharacterSkill_1(String skillName, int min,int max, int manaCost){
        this.skillName1 = skillName;
        this.skill1minRange = min;
        this.skill1maxRange = max;
        this.manaCost1 = manaCost;
    }
    @Override
    public void setCharacterSkill_2(String skillName, int min,int max, int manaCost){
        this.skillName2 = skillName;
        this.skill2minRange = min;
        this.skill2maxRange = max;
        this.manaCost2 = manaCost;
    }
    @Override
    public void setCharacterSupportSkill(String skillName,double buff, double debuff){
         this.supportSkillName = skillName;
         this.buff = buff;
         this.debuff = debuff;
    }

    //gets
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
    public int getManaCost1(){
        return this.manaCost1;
    }
    @Override
    public int getManaCost2(){
        return this.manaCost2;
    }
    @Override
    public int getSkill_1(){
        minusMana(manaCost1);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.skill1maxRange - this.skill1minRange) + 1) + this.skill1minRange;
    }
    @Override
    public int getSkill_2(){
        minusMana(manaCost2);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.skill2maxRange - this.skill2minRange) + 1) + this.skill2minRange;
    }
    @Override
    public int getBuff(){
        return (int)this.buff;
    }
    @Override
    public int getDebuff(){
        return (int)this.debuff;
    }

    //in battle
    @Override
    public void useSupportSkill(){

    }
    @Override
    public void checkHealthAndManaIfBelowZero(){
    
    if(getHealth() < 0) this.health = 0;
    
    if(getMana() < 0) this.mana = 0;
    
    }
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

