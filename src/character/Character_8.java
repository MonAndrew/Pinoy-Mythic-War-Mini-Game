
package character;

public class Character_8 extends Miscellaneous implements CharacterStats{
Miscellaneous misc = new Miscellaneous();

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
    //support skill
    private String supportSkillName;
    private double buff;
    private double debuff;

    //change for Character
    @Override
    public void setCharacter(){
        setCharacterName("Zaldivy Coco");
        setCharacterStats(super.getBaseHealth(),super.getBaseMana()); //HP[1000] && Mana[250]
        setCharacterNormalSkill("Normal", 75, 80, 25);
        setCharacterSkill_1("Croco", 130, 150, 150);
        setCharacterSkill_2("Spain Vaccation!", 175, 250, 250);
        setCharacterSupportSkill("Ghostly Project",0.17, 0.10);
    }
    @Override
    public void displayBackStory(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");

        System.out.println("("+getCharacterName()+") Backstory:");
        System.out.println("Zaldivy Coco was a notorious politician that has the ability to turn ghost projects into real money. He was born from a family of crocodilio bombardinos where you gain more power the more you steal. One day while having a public hearing of his case he suddenly disappeared as the entity itself felt pure greed from Zaldivy Coco.");
        
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
        System.out.println("(" + this.normalSkillName+"): Damage: "+this.normalSkillminRange+"-"+this.normalSkillmaxRange+", Mana Gain: "+this.manaGain);
        System.out.println("(" + this.skillName1+"): Damage: "+this.minRangeSkill_1+"-"+this.maxRangeSkill_1+", Mana Cost: "+this.manaCost1);
        System.out.println("(" + this.skillName2+"): Damage: "+this.minRangeSkill_2+"-"+this.maxRangeSkill_2+", Mana Cost: "+this.manaCost2);
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
        System.out.println("\nMana: ("+getMana()+"/"+super.getMaxMana()+")");

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
    public String getNormalSkillName(){ return this.normalSkillName; }
    @Override
    public String getSkillName_1(){ return this.skillName1; }
    @Override
    public String getSkillName_2(){ return this.skillName2; }

    @Override
    public int getHealth(){
        return this.health;
    }
    @Override
    public int getMana(){
        return this.mana;
    }
    @Override
    public int getManaGain(){
        return this.manaGain;
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
    public int getNormalSkill(){
        //addMana(manaGain);
        //checkHealthAndManaIfBelowZero();
        return random.nextInt((this.normalSkillminRange - this.normalSkillmaxRange) + 1) + this.normalSkillminRange;
    }
    @Override
    public int getSkill_1(){
        //minusMana(manaCost1);
        //checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_1 - this.minRangeSkill_1) + 1) + this.minRangeSkill_1;
    }
    @Override
    public int getSkill_2(){
        //minusMana(manaCost2);
        //checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_2 - this.minRangeSkill_2) + 1) + this.minRangeSkill_2;
    }
    //get skills min - max
    @Override
    public int getMinRangeNormalSkill(){
        return this.normalSkillminRange;
    }
    @Override
    public int getMaxRangeNormalSkill(){
        return this.normalSkillmaxRange;
    }
    @Override
    public int getMinRangeSkill_1(){
        return this.minRangeSkill_1;
    }
    @Override
    public int getMaxRangeSkill_1(){
        return this.maxRangeSkill_1;
    }
    @Override
    public int getMinRangeSkill_2(){
        return this.minRangeSkill_2;
    }
    @Override
    public int getMaxRangeSkill_2(){
        return this.maxRangeSkill_2;
    }

    //
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

