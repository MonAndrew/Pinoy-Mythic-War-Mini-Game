package character;

public class Character_3 extends Miscellaneous implements CharacterStats{
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
        setCharacterName("Jhong Kenario");
        setCharacterStats(super.getBaseHealth(),super.getBaseMana()); //HP[1000] && Mana[250]
        setCharacterNormalSkill("Normal", 75, 80, 25);
        setCharacterSkill_1("Gagambay", 130, 150, 150);
        setCharacterSkill_2("Budots", 175, 250, 250);
        setCharacterSupportSkill("Backflip kick",0.17, 0.10);
    }
    @Override
    public void displayBackStory(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");

        System.out.println("("+getCharacterName()+") Backstory:");
        System.out.println("Jhong Kenario was just like any other guy in town. Started out as one of the OG Streetboys, he quickly earned a reputation as the only dancer who could moonwalk while eating pares on the side. He quickly changed from being on the dance floors to straight up battlefield. His secret talent was to out dance the bullets and enemies until they surrender. His dancing was so powerful that even Juncoco Maarti paused mid-shootout to clap. Legends say, “Wag mo yang galawin, baka biglang mag-backflip ");
        
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

        misc.displayASCIIBars(getHealth(),misc.getMaxHealth());
        System.out.println("\nHealth: ("+getHealth()+"/"+misc.getMaxHealth()+")\n");

        misc.displayASCIIBars(getMana(),misc.getMaxMana());
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

}
