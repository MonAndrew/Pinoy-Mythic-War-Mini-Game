package character;

public class Character_2 extends Miscellaneous implements CharacterStats{
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
    private int buff;
    private int debuff;

    //change for Character
    @Override
    public void setCharacter(){
        setCharacterName("Zak Riberto");
        setCharacterStats(super.getMaxHealth(),super.getMaxMana());//HP[1000] && Mana[250]
        setCharacterNormalSkill("Normal", 75, 80, 25);
        setCharacterSkill_1("Abs Smash", 130, 150, 150);
        setCharacterSkill_2("Kaldag kaldag", 175, 250, 250);
        setCharacterSupportSkill("Anti-selos Barrier",0, 0);
    }
    @Override
    public void displayBackStory(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");

        System.out.println("("+getCharacterName()+") Backstory:");
        System.out.println();
        String text = "He was a drama actor who makes a living by debuting popular teleserye series and gaining more popularity through showing his abs on the internet. Zak Riberto later on became Anti-Selos after numerous guys showed interest in his girlfriend named Wally Forteza. Despite having an Anti-selos barrier, his overwhelming jealousy consumed him which gave the entity an opportunity to take him away to Realm.";
        misc.slowPrint(text,10);
        System.out.println("\n═════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }

    @Override
    public void displayCharacterStats(){
        System.out.println();
        System.out.println("═════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                ╔═════════╗");
        System.out.println("                                ║"+misc.BOLD+misc.YELLOW+"  STATS: "+misc.RESET+"║");
        System.out.println("                                ╚═════════╝");

        misc. displayCharacterNameHealthAndMana(getCharacterName(),misc.getMaxHealth(),misc.getMaxHealth(),misc.getMaxMana(),misc.getMaxMana());

        System.out.println("                                ╔═════════╗");
        System.out.println("                                ║"+misc.BOLD+misc.YELLOW+" SKILLS: "+misc.RESET+"║");
        System.out.println("                                ╚═════════╝");
        int maxManaGain = 75;
        System.out.println("(" + this.normalSkillName+"): Damage: "+misc.BOLD+misc.RED+this.normalSkillminRange+"-"+this.normalSkillmaxRange+misc.RESET+", Mana Gain: "+misc.BOLD+misc.CYAN+this.manaGain+"-"+maxManaGain+misc.RESET);
        System.out.println("(" + this.skillName1+"): Damage: "+misc.BOLD+misc.RED+this.minRangeSkill_1+"-"+this.maxRangeSkill_1+misc.RESET+", Mana Cost: "+misc.BOLD+misc.PURPLE+this.manaCost1+misc.RESET);
        System.out.println("(" + this.skillName2+"): Damage: "+misc.BOLD+misc.RED+this.minRangeSkill_2+"-"+this.maxRangeSkill_2+misc.RESET+", Mana Cost: "+misc.BOLD+misc.PURPLE+this.manaCost2+misc.RESET);
        System.out.print("(" + this.supportSkillName+"): ");misc.displaySupportSkillTypesFromBuffAndDebuff(this.buff, this.debuff);
        
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
    public void setCharacterSupportSkill(String skillName,int buff, int debuff){
         this.supportSkillName = skillName;
         this.buff = buff;
         this.debuff = debuff;
    }

    //gets
    @Override
    public String getCharacterName(){ return this.characterName;}
    @Override
    public int getHealth(){ return this.health; }
    @Override
    public int getMana(){ return this.mana; }
    @Override
    public int getManaGain(){ return this.manaGain; }
    @Override
    public int getManaCost1(){ return this.manaCost1; }
    @Override
    public int getManaCost2(){ return this.manaCost2; }

    //get skills min - max
    @Override
    public String getNormalSkillName(){ return this.normalSkillName; }
    @Override
    public String getSkillName_1(){ return this.skillName1; }
    @Override
    public String getSkillName_2(){ return this.skillName2; }
    @Override
    public int getMinRangeNormalSkill(){ return this.normalSkillminRange; }
    @Override
    public int getMaxRangeNormalSkill(){ return this.normalSkillmaxRange; }
    @Override
    public int getMinRangeSkill_1(){ return this.minRangeSkill_1; }
    @Override
    public int getMaxRangeSkill_1(){ return this.maxRangeSkill_1; }
    @Override
    public int getMinRangeSkill_2(){ return this.minRangeSkill_2; }
    @Override
    public int getMaxRangeSkill_2(){ return this.maxRangeSkill_2; }

    //support skill
    @Override
    public String getSupportSkillName(){ return this.supportSkillName; }
    @Override
    public int getBuff(){ return this.buff; }
    @Override
    public int getDebuff(){ return this.debuff; }

}

