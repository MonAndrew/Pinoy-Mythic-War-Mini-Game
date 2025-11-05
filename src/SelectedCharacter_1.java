public class SelectedCharacter_1 extends GameMechanics{
    private String characterName;
    private int health;
    private int mana;

    //status effect
    private int effectTurn;
    private boolean isPoisoned = false;
    private int poisonEffectTurn;
    private boolean isBleeding = false;
    private int bleedingEffectTurn;
    private boolean isIncreasedDamage = false;
    private int increaseDamageEffect;
    private boolean isDecreasedDamage = false;
    private int decreaseDamageEffect;

    //cooldown
    private int cooldown_1;
    public int cooldown_2;

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
        this.cooldown_1 = 0;
    }
    @Override
    public void setCharacterSkill_2(String skillName, int min,int max, int manaCost){
        this.skillName2 = skillName;
        this.minRangeSkill_2 = min;
        this.maxRangeSkill_2 = max;
        this.manaCost2 = manaCost;
        this.cooldown_2 = 0;
    }

    @Override
    public String getCharacterName(){ return this.characterName;
    }
    @Override
    public int getHealth(){ return this.health;
    }
    @Override
    public int getMana(){ return this.mana;
    }
    @Override
    public int getManaGain(){ return this.manaGain;
    }
    @Override
    public int getManaCost1(){ return this.manaCost1;
    }
    @Override
    public int getManaCost2(){ return this.manaCost2;
    }
    @Override
    public int getCooldown_1(){ return this.cooldown_1;
    }
    @Override
    public int getCooldown_2(){ return this.cooldown_2;
    }

    @Override
    public int getDamagefromNormalSkill(){
        System.out.println("("+this.characterName+") Used: "+this.normalSkillName);
        addMana(this.manaGain);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.normalSkillmaxRange - this.normalSkillminRange) + 1) + this.normalSkillminRange;
    }

    @Override
    public int getDamageFromSkill_1(){

        if(getMana() < getManaCost1()){
        System.out.println("Not enough Mana!");
        return getDamagefromNormalSkill();
        }

        if(cooldown_1 != 0){
        System.out.println("("+this.skillName1+") Cooldown: "+this.cooldown_1);
        return getDamagefromNormalSkill();
        }

        this.cooldown_2 = 1;
        System.out.println("("+this.characterName+") Used: "+this.skillName1);
        minusMana(this.manaCost1);
        checkHealthAndManaIfBelowZero();
        return random.nextInt((this.maxRangeSkill_1 - this.minRangeSkill_1) + 1) + this.minRangeSkill_1;
    }
    @Override
    public int getDamageFromSkill_2(){

        if(getMana() < getManaCost2()){
        System.out.println("Not enough Mana!");
        return getDamagefromNormalSkill();
        }

        if(cooldown_2 != 0){
        System.out.println("("+this.skillName2+") Cooldown: "+this.cooldown_2);
        return getDamagefromNormalSkill();
        }

        this.cooldown_2 = 4;
        System.out.println("("+this.characterName+") Used: "+this.skillName2+" Turn/s");
        minusMana(this.manaCost2);
        checkHealthAndManaIfBelowZero();
        //random effect
        System.out.println("Support Skill/ Passive: ");
        int effectType = misc.getRNG(2, 1);
        effectType_Buff(effectType);

        return random.nextInt((this.maxRangeSkill_2 - this.minRangeSkill_2) + 1) + this.minRangeSkill_2;
    }

   @Override
    public void displaySkillsAndIfAvailable(){

        System.out.print(misc.BOLD+"Normal: "+misc.RESET);
        System.out.println(misc.RED+normalSkillmaxRange+" - "+normalSkillminRange+misc.RESET+", "+misc.CYAN+"+"+this.manaGain+misc.RESET);

        System.out.print(misc.BOLD+"Skill 1: ("+skillName1+misc.RESET+") ");
        System.out.println(misc.RED+maxRangeSkill_1+" - "+minRangeSkill_1+misc.RESET+", "+misc.PURPLE+"-"+this.manaCost1+misc.RESET);

        System.out.print(misc.BOLD+"Skill 2: ("+skillName2+misc.RESET+") ");
        System.out.println(misc.RED+maxRangeSkill_2+" - "+minRangeSkill_2+misc.RESET+", "+misc.PURPLE+"-"+this.manaCost2+misc.RESET);

        System.out.println();
    }

  
    //in battle
     @Override
    public void checkHealthAndManaIfBelowZero(){
    
    if(getHealth() < 0) this.health = 0;
    if(getHealth() > misc.getMaxHealth()) this.health = misc.getMaxHealth();
    
    if(getMana() < 0) this.mana = 0;
    if(getMana() > misc.getMaxMana()) this.mana = misc.getMaxMana();

    }
    @Override
    public void addHealth(int health){
        System.out.println(misc.GREEN+misc.BOLD+" +"+health+" HP: "+misc.RESET+this.characterName);
        this.health += health;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void addMana(int mana){
        System.out.println(misc.CYAN+misc.BOLD+" +"+mana+" Mana: "+misc.RESET+this.characterName);
        this.mana += mana;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void minusHealth(int damage){
        System.out.println(misc.RED+misc.BOLD+" -"+damage+" HP: "+misc.RESET+this.characterName);
        this.health -= damage;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void minusMana(int manaCost){
        System.out.println(misc.PURPLE+misc.BOLD+" -"+manaCost+" Mana: "+misc.RESET+this.characterName);
        this.mana -= manaCost;
        checkHealthAndManaIfBelowZero();
    }
    @Override
    public void reduceCooldownAndEffectTurns(){
        this.effectTurn--;
        if(this.effectTurn <= 0){ 
            this.effectTurn = 0;
            //turn off effects
            //buff
            this.isIncreasedDamage = false;
            this.increaseDamageEffect = 1;
            //debuff
            this.isDecreasedDamage = false;
            this.decreaseDamageEffect = 1;
        }

        this.poisonEffectTurn--;
        if(this.poisonEffectTurn <= 0){ this.poisonEffectTurn = 0; this.isPoisoned = false;}

        this.bleedingEffectTurn--;
        if(this.bleedingEffectTurn <= 0){ this.bleedingEffectTurn = 0; this.isBleeding = false;}
        

        this.cooldown_1--;
        if(this.cooldown_1 <= 0) this.cooldown_1 = 0;

        this.cooldown_2--;
        if(this.cooldown_2 <= 0) this.cooldown_2 = 0;
    }

//statusEffects
    @Override
    public void effectType_Buff(int effectType){
        switch(effectType){
        //buff
            case 1 -> { addHealth(misc.getRNG(200, 50)); }
            case 2 -> { addMana(misc.getRNG(100, 25)); }
            //case 3 -> { System.out.println("Increase Damage 10% for 4 turns");}
        }

    }
    @Override
    public void effectType_Debuff(int effectType){
        switch(effectType){

            case 1 -> {System.out.println("poison Debuff");}
            case 2 -> {System.out.println("bleed Debuff");}
            case 3 -> {System.out.println("decrease dmg Debuff");}
        }
    }
    @Override
    public void setStatusEffect_On(int effectType){
        switch(effectType){

            case 1 -> {}
            case 2 -> {}
            case 3 -> {}
            case 4 -> { System.out.println("poison_on");this.poisonEffectTurn = 4; this.isPoisoned = true;}
            case 5 -> { System.out.println("bleed_on");this.bleedingEffectTurn = 4; this.isBleeding = true;}
            case 6 -> { System.out.println("decrease dmg_on");this.effectTurn = 4; this.isDecreasedDamage = true;}

        }
    }
    @Override
    public void displayCurrectStatusEffect(){
        
        System.out.print("Status: ");

        if(this.isPoisoned == true) System.out.println(misc.PURPLE+misc.BOLD+"POISONED"+misc.RESET);

        else if(this.isBleeding == true) System.out.println(misc.RED+misc.BOLD+"BLEEDING"+misc.RESET);

        else System.out.println("None");
    }
    @Override
    public void doStatusEffect(){

        if(this.isPoisoned == true){ 
            System.out.println(misc.PURPLE+misc.BOLD+"POISONED: "+misc.RESET);
            minusHealth(misc.getRNG(25, 5));
        }

        else if(this.isBleeding == true){
            System.out.println(misc.RED+misc.BOLD+"BLEEDING: "+misc.RESET);
            minusHealth(misc.getRNG(30, 1));
        }

    }

    @Override
    public void isPoisoned_Effects(){

    }
    @Override
    public void isBleeding_Effects(){

    }

}
