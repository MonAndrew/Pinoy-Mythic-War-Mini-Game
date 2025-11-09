public class SelectedCharacter_1 extends GameMechanics{
    private String characterName;
    private int health;
    private int mana;

    //status effect
    private int buff;
    private int debuff;

    private int effectTurn;
    private boolean isPoisoned = false;
    private int poisonEffectTurn;
    private boolean isBleeding = false;
    private int bleedingEffectTurn;
    private boolean isThorned = false;
    private int thornedEffectTurn;
    private boolean isParalyzed = false;
    private int paralyzedEffectTurn;
    private boolean isBurned = false;
    private int burnedEffectTurn;

    private boolean isIncreasedDamage = false;
    private int increaseDamageEffectTurn;
    private int increaseDamageEffect;
    private boolean isDecreasedDamage = false;
    private int decreaseDamageEffectTurn;
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
    //block
    public boolean isBlocked = false;
    private int blockCooldown;

    @Override
    public void setPlayerSelectedCharacter(String name,int health, int mana){
        this.characterName = name;
        this.health = health;
        this.mana = mana;
    }
    @Override
    public void setBuffAndDebuff(int buff,int debuff){
        this.buff = buff;
        this.debuff = debuff;
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
    public void setBlockedTrueOrFalse(){
        this.isBlocked = getIsBlocked() != true;
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
    public int getBuff(){ return this.buff; 
    }
    @Override
    public int getDebuff(){ return this.debuff; 
    }
    @Override
    public int getBlockedCooldown(){ return this.blockCooldown;
    }

    @Override
    public int getDamagefromNormalSkill(){
        //paralyzed
        if(this.isParalyzed == true){ 
            if(misc.getRNG(3, 1) ==  1){
            System.out.println(misc.YELLOW+misc.BOLD+"PARALYZED: "+misc.RESET);
            System.out.println(misc.BOLD+"** "+misc.YELLOW+getCharacterName()+" is Paralyzed, can't move."+misc.WHITE+" **"+misc.RESET);
            return 0;
            }
        }

        int dmg = random.nextInt((this.normalSkillmaxRange - this.normalSkillminRange) + 1) + this.normalSkillminRange;
        
        if(this.isIncreasedDamage == true){ 
            int increase = (int)((double)dmg * (double)((double)this.increaseDamageEffect/(double)100));
            dmg += increase;
            System.out.println(misc.CYAN+misc.BOLD+"Increased Damage: (+"+increase+")"+misc.RESET);
        }

        if(this.isDecreasedDamage == true){ 
            int decrease = (int)((double)dmg * (double)((double)this.decreaseDamageEffect/(double)100));
            dmg -= decrease;
            System.out.println(misc.BLUE+misc.BOLD+"Decreased Damage: (-"+decrease+")"+misc.RESET);
        }

        System.out.println("("+this.characterName+") Used: "+this.normalSkillName);
        addMana(this.manaGain);
        checkHealthAndManaIfBelowZero();

        return dmg;
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

        if(this.isParalyzed == true){ 
            if(misc.getRNG(3, 1) ==  1){
            System.out.println(misc.YELLOW+misc.BOLD+"PARALYZED: "+misc.RESET);
            System.out.println(misc.BOLD+"** "+misc.YELLOW+getCharacterName()+" is Paralyzed, can't move."+misc.WHITE+" **"+misc.RESET);
            return 0;
            }
        }


        
        this.cooldown_1 = 2;
        int dmg = random.nextInt((this.maxRangeSkill_1 - this.minRangeSkill_1) + 1) + this.minRangeSkill_1;

        if(this.isIncreasedDamage == true){ 
            int increase = (int)((double)dmg * (double)((double)this.increaseDamageEffect/(double)100));
            dmg += increase;
            System.out.println(misc.CYAN+misc.BOLD+"Increased Damage: (+"+increase+")"+misc.RESET);
        }

        if(this.isDecreasedDamage == true){ 
            int decrease = (int)((double)dmg * (double)((double)this.decreaseDamageEffect/(double)100));
            dmg -= decrease;
            System.out.println(misc.BLUE+misc.BOLD+"Decreased Damage: (-"+decrease+")"+misc.RESET);
        }

        System.out.println("("+this.characterName+") Used: "+this.skillName1);
        minusMana(this.manaCost1);
        checkHealthAndManaIfBelowZero();

        return dmg;
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

        if(this.isParalyzed == true){ 
            if(misc.getRNG(3, 1) ==  1){
            System.out.println(misc.YELLOW+misc.BOLD+"PARALYZED: "+misc.RESET);
            System.out.println(misc.BOLD+"** "+misc.YELLOW+getCharacterName()+" is Paralyzed, can't move."+misc.WHITE+" **"+misc.RESET);
            return 0;
            }
        }

        this.cooldown_2 = 9;
        int dmg = random.nextInt((this.maxRangeSkill_2 - this.minRangeSkill_2) + 1) + this.minRangeSkill_2;

        if(this.isIncreasedDamage == true){ 
            int increase = (int)((double)dmg * (double)((double)this.increaseDamageEffect/(double)100));
            dmg += increase;
            System.out.println(misc.CYAN+misc.BOLD+"Increased Damage: (+"+increase+")"+misc.RESET);
        }

        if(this.isDecreasedDamage == true){ 
            int decrease = (int)((double)dmg * (double)((double)this.decreaseDamageEffect/(double)100));
            dmg -= decrease;
            System.out.println(misc.BLUE+misc.BOLD+"Decreased Damage: (-"+decrease+")"+misc.RESET);
        }

        System.out.println("("+this.characterName+") Used: "+this.skillName2);
        minusMana(this.manaCost2);
        checkHealthAndManaIfBelowZero();

        //random effect
        System.out.println("Support Skill/ Passive: ");
        effectType_Buff(misc.getRNG(3, 1));

        return dmg;
    }
    @Override
    public void useBlockOrProtect(){
        if(getBlockedCooldown() != 0){
            System.out.println(misc.BOLD+getCharacterName()+" Failed To use Block "+misc.RESET);
            System.out.println("(Block) Cooldown: "+getBlockedCooldown());
            this.isBlocked = false;
            return;
        }

        System.out.println(misc.BOLD+getCharacterName()+" Block "+misc.RESET);
        setBlockedTrueOrFalse();
        this.blockCooldown = 5;
    }
    @Override
    public boolean getIsBlocked(){
        return this.isBlocked;
    }

   @Override
    public void displaySkillsAndIfAvailable(){

        System.out.print(misc.BOLD+"Skill 1: (Normal) "+misc.RESET);
        System.out.println(misc.RED+normalSkillmaxRange+" - "+normalSkillminRange+misc.RESET+", "+misc.CYAN+"+"+this.manaGain+misc.RESET);

        System.out.print(misc.BOLD+"Skill 2: ("+skillName1+") "+misc.RESET);
        System.out.println(misc.RED+maxRangeSkill_1+" - "+minRangeSkill_1+misc.RESET+", "+misc.PURPLE+"-"+this.manaCost1+misc.RESET);

        System.out.print(misc.BOLD+"Skill 3: ("+skillName2+") "+misc.RESET);
        System.out.println(misc.RED+maxRangeSkill_2+" - "+minRangeSkill_2+misc.RESET+", "+misc.PURPLE+"-"+this.manaCost2+misc.RESET);

        System.out.print(misc.BOLD+"Skill 4: (Block) "+misc.RESET);
        System.out.println("Blocks/Protected by any dmg in the Opponent's Turn");

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
        if(this.effectTurn <= 0){ this.effectTurn = 0;}
        
        this.increaseDamageEffectTurn--;
        if(this.increaseDamageEffectTurn <= 0){
        this.increaseDamageEffectTurn = 0;
        this.isIncreasedDamage = false;
        this.increaseDamageEffect = 1;}
        
        this.decreaseDamageEffectTurn--;
        if(this.decreaseDamageEffectTurn <= 0){
        this.decreaseDamageEffectTurn = 0;
        this.isDecreasedDamage = false;
        this.decreaseDamageEffect = 1;}

        this.poisonEffectTurn--;
        if(this.poisonEffectTurn <= 0){ this.poisonEffectTurn = 0; this.isPoisoned = false;}

        this.bleedingEffectTurn--;
        if(this.bleedingEffectTurn <= 0){ this.bleedingEffectTurn = 0; this.isBleeding = false;}
        
        this.thornedEffectTurn--;
        if(this.thornedEffectTurn <= 0){ this.thornedEffectTurn = 0; this.isThorned = false;}

        this.paralyzedEffectTurn--;
        if(this.paralyzedEffectTurn <= 0){ this.paralyzedEffectTurn = 0; this.isParalyzed = false;}

        this.burnedEffectTurn--;
        if(this.burnedEffectTurn <= 0){ this.burnedEffectTurn = 0; this.isBurned = false;}

        this.cooldown_1--;
        if(this.cooldown_1 <= 0) this.cooldown_1 = 0;

        this.cooldown_2--;
        if(this.cooldown_2 <= 0) this.cooldown_2 = 0;

        this.blockCooldown--;
        if(this.blockCooldown <= 0){this.blockCooldown = 0; this.isBlocked = false;}
    }
    @Override
    public void clearCooldownsAndEffectTurns(){

    this.effectTurn = 0;
        
    this.increaseDamageEffectTurn = 0;
    this.isIncreasedDamage = false;
    this.increaseDamageEffect = 1;
        
    this.decreaseDamageEffectTurn = 0;
    this.isDecreasedDamage = false;
    this.decreaseDamageEffect = 1;

    this.poisonEffectTurn = 0; 
    this.isPoisoned = false;

    this.bleedingEffectTurn = 0; 
    this.isBleeding = false;
        
    this.thornedEffectTurn = 0; 
    this.isThorned = false;

    this.paralyzedEffectTurn = 0; 
    this.isParalyzed = false;

    this.burnedEffectTurn = 0; 
    this.isBurned = false;

    this.cooldown_1 = 0;
    this.cooldown_2 = 0;

    }

//statusEffects
//just a reminder for effectTurns, it is automatically minus 1, like set to 5, it deducts 1 right after use

    @Override
    public void effectType_Buff(int effectType){
        switch(effectType){
        //buff
            case 1 -> { addHealth(misc.getRNG(200, 50)); }
            case 2 -> { addMana(misc.getRNG(100, 25)); }
            case 3 -> { System.out.println("Increase Damage 10% for 4 turns");
                    this.increaseDamageEffectTurn = 5;
                    this.isIncreasedDamage = true;
                    this.increaseDamageEffect = 10;
                }
            
            default -> {}//just catch the 0, empty, no ability
        }

    }
    @Override
    public void setStatusEffect_On(int effectType){
        switch(effectType){
            case 1 -> { System.out.println("poison_on");this.poisonEffectTurn = 6; this.isPoisoned = true;}
            case 2 -> { System.out.println("bleed_on");this.bleedingEffectTurn = 6; this.isBleeding = true;}
            case 3 -> { System.out.println("thorn_on");this.thornedEffectTurn = 6; this.isThorned = true;}
            case 4 -> { System.out.println("paralyzed_on");this.paralyzedEffectTurn = 8; this.isParalyzed = true;}
            case 5 -> { System.out.println("Burned_on");this.burnedEffectTurn = 3; this.isBurned = true;}
            case 6 -> { System.out.println("decrease dmg_on");
            this.decreaseDamageEffectTurn = 5; 
            this.isDecreasedDamage = true;
            this.decreaseDamageEffect = 10;
            }

            default -> {}//just catch the 0, empty
        }
    }

    @Override
    public void displayCurrectStatusEffect(){
        
        System.out.print("Status: ");

        if(this.isPoisoned == true) System.out.println(misc.PURPLE+misc.BOLD+"POISONED"+misc.RESET);
        if(this.isBleeding == true) System.out.println(misc.RED+misc.BOLD+"BLEEDING"+misc.RESET);
        if(this.isThorned == true) System.out.println(misc.GREEN+misc.BOLD+"THORNED"+misc.RESET);
        if(this.isParalyzed == true) System.out.println(misc.YELLOW+misc.BOLD+"PARALYZED"+misc.RESET);
        if(this.isBurned == true) System.out.println(misc.YELLOW+misc.BOLD+"BURNING"+misc.RESET);

        if(this.isIncreasedDamage == true) System.out.println(misc.CYAN+misc.BOLD+"INCREASE DMG"+misc.RESET);
        if(this.isDecreasedDamage == true) System.out.println(misc.BLUE+misc.BOLD+"DECREASE DMG"+misc.RESET);

        if(this.isPoisoned == false && this.isBleeding == false && this.isThorned == false && this.isParalyzed == false && this.isIncreasedDamage == false && this.isDecreasedDamage == false)
        System.out.println("None");
    }

    @Override
    public void doStatusEffect(){

        if(this.isPoisoned == true){ 
            isPoisoned_Effects();
        }

        if(this.isBleeding == true){
            isBleeding_Effects();
        }
        if(this.isThorned == true){ 
            isThorned_Effects();
        }
        if(this.isBurned == true){ 
            isBurned_Effects();
        }
        //paralyzed is set in every attacks
        // increase and decrease too

    }

    @Override
    public void isPoisoned_Effects(){
        System.out.println(misc.PURPLE+misc.BOLD+"POISONED: "+misc.RESET);
        minusHealth(misc.getRNG(25, 5));
    }
    
    @Override
    public void isBleeding_Effects(){
        System.out.println(misc.RED+misc.BOLD+"BLEEDING: "+misc.RESET);
        minusHealth(misc.getRNG(40, 1));
    }
    @Override
    public void isThorned_Effects(){
        System.out.println(misc.GREEN+misc.BOLD+"THORNED: "+misc.RESET);
        minusHealth(misc.getRNG(30, 5));
    }
    @Override
    public void isBurned_Effects(){
        System.out.println(misc.YELLOW+misc.BOLD+"BURNING: "+misc.RESET);
        minusHealth(misc.getRNG(150, 40));
    }

}
