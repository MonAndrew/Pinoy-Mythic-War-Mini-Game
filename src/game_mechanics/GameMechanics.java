package game_mechanics;
import character.CharacterStats;
import character.Character_1;
import character.Character_2;
import character.Character_3;
import character.Character_4;
import character.Character_5;
import character.Character_6;
import character.Character_7;
import character.Character_8; 
import character.Miscellaneous;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public abstract class GameMechanics{
    Scanner scan = new Scanner(System.in);
    Miscellaneous misc = new Miscellaneous();
    Random random = new Random();
//setters
    abstract public void setPlayerSelectedCharacter(String name,int health, int mana);
    abstract  public void setBuffAndDebuff(String SupportSkillName,int buff,int debuff);
    abstract public void setCharacterNormalSkill(String skillName, int min, int max, int manaGain);
    abstract public void setCharacterSkill_1(String skillName, int min,int max, int manaCost);
    abstract public void setCharacterSkill_2(String skillName, int min,int max, int manaCost);
    abstract public void setBlockedToTrue();
    abstract public void setBlockedToFalse();

    abstract public void displaySkillsAndIfAvailable();
    abstract public String getCharacterName();
    abstract public int getHealth();
    abstract public int getMana();
    abstract public int getManaGain();
    abstract public int getManaCost1();
    abstract public int getManaCost2();
    abstract public int getCooldown_1();
    abstract public int getCooldown_2();
    abstract public int getBlockedCooldown();
    abstract public int getDamagefromNormalSkill();
    abstract public int getDamageFromSkill_1();
    abstract public int getDamageFromSkill_2();
    abstract public void useBlockOrProtect();
    abstract public boolean getIsBlocked();
    abstract public String getSupportSkillName();
    abstract public int getBuff();
    abstract public int getDebuff();
//battles
    abstract public void minusHealth(int damage);
    abstract public void minusMana(int manaCost);
    abstract public void addHealth(int health);
    abstract public void addMana(int mana);
    abstract public void reduceCooldownAndEffectTurns();
    abstract public void clearCooldownsAndEffectTurns();
//effects
    abstract public void effectType_Buff(int effectType);
    abstract public void setStatusEffect_On(int effectType);
    abstract public void displayCurrectStatusEffect();
    abstract public void doStatusEffect();
    //debuff
    abstract public void isPoisoned_Effects();
    abstract public void isBleeding_Effects();
    abstract public void isThorned_Effects();
    abstract public void isBurned_Effects();
    abstract public boolean isParalyzed_TrueOrFalse();

    abstract public void checkHealthAndManaIfBelowZero();

    public void missedAttacksAfterEffect(int skillNum){
        switch(skillNum){
            case 1 ->{addMana(misc.getRNG(75, getManaGain()));}
            case 2 ->{minusMana(getManaCost1());}
            case 3 ->{minusMana(getManaCost2());}
        }
    }

    public int enterSkill(){
        boolean isValid = false;
        int skillNum = 0;

        while(isValid == false){
            try{
                System.out.print("Enter Skill Number: ");
                skillNum = scan.nextInt();

                if(skillNum >= 1 || skillNum <= 4){
                    switch(skillNum){

                        case 1 -> {
                            isValid = true;
                            //return skillNum;
                        }
                        case 2 -> {
                            if(getMana() < getManaCost1()){System.out.println("Not Enough Mana!");}
                            else if(getCooldown_1() != 0){ System.out.println("Skill in Cooldown for "+getCooldown_1()+" Turn/s");}
                            else{isValid = true;}
                        }
                        case 3 -> {
                            if(getMana() < getManaCost2()){System.out.println("Not Enough Mana!");}
                            else if(getCooldown_2() != 0){ System.out.println("Skill in Cooldown for "+getCooldown_2()+" Turn/s");}
                            else{isValid = true;}
                        }
                        case 4 -> {
                            if(getBlockedCooldown() != 0){ System.out.println("Skill in Cooldown for "+getBlockedCooldown()+" Turn/s");}
                            else{isValid = true;}
                        }

                        default -> {System.out.println("Invalid Skill Number!");}
                    }
                }

            }catch(InputMismatchException e){
                System.out.println("Invalid Input!");
                scan.next();
            }
        }

        return skillNum;
    }

    public int enterSkillForBots(int max,int min){
        boolean isValid = false;
        int skillNum = 0;

        while(isValid == false){
            try{
                skillNum = misc.getRNG(max, min);

                int chance;
                if(getMana() >= getManaCost2()){
                    chance = misc.getRNG(100, 1);
                    if(chance > 80){//20% chance, no
                        switch(misc.getRNG(3,1)){
                            case 1 -> {skillNum = 1;}
                            case 2 -> {skillNum = 2;}
                            case 3 -> {skillNum = 4;}//block
                        }
                    }
                    else{ skillNum = 3;}//yess

                }
                if(getMana() >= getManaCost1()){
                    chance = misc.getRNG(100, 1);
                    if(chance > 60){//40% chance, no
                        skillNum = (misc.getFifthyFifhtyChance() == 1) ? 1 : 4;}
                    else{ skillNum = 2;}//yes

                }

                if(skillNum >= 1 || skillNum <= 4){
                    switch(skillNum){

                        case 1 -> {
                            isValid = true;
                        }
                        case 2 -> {
                            if(getMana() < getManaCost1()){}
                            else if(getCooldown_1() != 0){ }
                            else{
                                if(misc.getFifthyFifhtyChance() == 1){skillNum = 1;isValid = true;}
                                else{isValid = true;}
                            }
                        }
                        case 3 -> {
                            if(getMana() < getManaCost2()){}
                            else if(getCooldown_2() != 0){}
                            else{
                                if(misc.getFifthyFifhtyChance() == 1){skillNum = 1;isValid = true;}
                                else{isValid = true;}
                            }
                        }
                        case 4 -> {
                            if(getBlockedCooldown() != 0){}
                            else{
                                if(misc.getFifthyFifhtyChance() == 1){skillNum = 1;isValid = true;}
                                else{isValid = true;}
                            }
                        }

                        default -> {System.out.println("Invalid Skill Number!");}
                    }
                }

            }catch(InputMismatchException e){
                System.out.println("Invalid Input!");
                scan.next();
            }
        }

        return skillNum;
    }
}

@SuppressWarnings("unused")
class GameMechanics_2{
    Miscellaneous misc = new Miscellaneous();
    CharacterStats character_1 = new Character_1();
    CharacterStats character_2 = new Character_2();
    CharacterStats character_3 = new Character_3();
    CharacterStats character_4 = new Character_4();
    CharacterStats character_5 = new Character_5();
    CharacterStats character_6 = new Character_6();
    CharacterStats character_7 = new Character_7();
    CharacterStats character_8 = new Character_8();
    
    GameMechanics selectedCharacter_1 = new SelectedCharacter_1();
    GameMechanics selectedCharacter_2 = new SelectedCharacter_2();

    
    public void setCharacters(){
        character_1.setCharacter();
        character_2.setCharacter();
        character_3.setCharacter();
        character_4.setCharacter();
        character_5.setCharacter();
        character_6.setCharacter();
        character_7.setCharacter();
        character_8.setCharacter();
    }

     
    public int characterSelection_1(int num){
        //setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_1.getNormalSkillName(), character_1.getMinRangeNormalSkill(), character_1.getMaxRangeNormalSkill(), character_1.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_1.getSkillName_1(), character_1.getMinRangeSkill_1(), character_1.getMaxRangeSkill_1(), character_1.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_1.getSkillName_2(), character_1.getMinRangeSkill_2(), character_1.getMaxRangeSkill_2(), character_1.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_1.getSupportSkillName(),character_1.getBuff(), character_1.getDebuff());
            return 1;}

            case 2 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_2.getNormalSkillName(), character_2.getMinRangeNormalSkill(), character_2.getMaxRangeNormalSkill(), character_2.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_2.getSkillName_1(), character_2.getMinRangeSkill_1(), character_2.getMaxRangeSkill_1(), character_2.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_2.getSkillName_2(), character_2.getMinRangeSkill_2(), character_2.getMaxRangeSkill_2(), character_2.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_2.getSupportSkillName(),character_2.getBuff(), character_2.getDebuff());
            return 2;}

            case 3 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_3.getCharacterName(), character_3.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_3.getNormalSkillName(), character_3.getMinRangeNormalSkill(), character_3.getMaxRangeNormalSkill(), character_3.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_3.getSkillName_1(), character_3.getMinRangeSkill_1(), character_3.getMaxRangeSkill_1(), character_3.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_3.getSkillName_2(), character_3.getMinRangeSkill_2(), character_3.getMaxRangeSkill_2(), character_3.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_3.getSupportSkillName(),character_3.getBuff(), character_3.getDebuff());
            return 3;}

            case 4 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_4.getCharacterName(), character_4.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_4.getNormalSkillName(), character_4.getMinRangeNormalSkill(), character_4.getMaxRangeNormalSkill(), character_4.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_4.getSkillName_1(), character_4.getMinRangeSkill_1(), character_4.getMaxRangeSkill_1(), character_4.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_4.getSkillName_2(), character_4.getMinRangeSkill_2(), character_4.getMaxRangeSkill_2(), character_4.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_4.getSupportSkillName(),character_4.getBuff(), character_4.getDebuff());
            return 4;}

            case 5 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_5.getCharacterName(), character_5.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_5.getNormalSkillName(), character_5.getMinRangeNormalSkill(), character_5.getMaxRangeNormalSkill(), character_5.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_5.getSkillName_1(), character_5.getMinRangeSkill_1(), character_5.getMaxRangeSkill_1(), character_5.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_5.getSkillName_2(), character_5.getMinRangeSkill_2(), character_5.getMaxRangeSkill_2(), character_5.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_5.getSupportSkillName(),character_5.getBuff(), character_5.getDebuff());
            return 5;}

            case 6 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_6.getCharacterName(), character_6.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_6.getNormalSkillName(), character_6.getMinRangeNormalSkill(), character_6.getMaxRangeNormalSkill(), character_6.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_6.getSkillName_1(), character_6.getMinRangeSkill_1(), character_6.getMaxRangeSkill_1(), character_6.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_6.getSkillName_2(), character_6.getMinRangeSkill_2(), character_6.getMaxRangeSkill_2(), character_6.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_6.getSupportSkillName(),character_6.getBuff(), character_6.getDebuff());
            return 6;}

            case 7 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_7.getCharacterName(), character_7.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_7.getNormalSkillName(), character_7.getMinRangeNormalSkill(), character_7.getMaxRangeNormalSkill(), character_7.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_7.getSkillName_1(), character_7.getMinRangeSkill_1(), character_7.getMaxRangeSkill_1(), character_7.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_7.getSkillName_2(), character_7.getMinRangeSkill_2(), character_7.getMaxRangeSkill_2(), character_7.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_7.getSupportSkillName(),character_7.getBuff(), character_7.getDebuff());
            return 7;}

            case 8 -> {
            selectedCharacter_1.setPlayerSelectedCharacter(character_8.getCharacterName(), character_8.getHealth(), misc.getBaseMana());
            selectedCharacter_1.setCharacterNormalSkill(character_8.getNormalSkillName(), character_8.getMinRangeNormalSkill(), character_8.getMaxRangeNormalSkill(), character_8.getManaGain());
            selectedCharacter_1.setCharacterSkill_1(character_8.getSkillName_1(), character_8.getMinRangeSkill_1(), character_8.getMaxRangeSkill_1(), character_8.getManaCost1());
            selectedCharacter_1.setCharacterSkill_2(character_8.getSkillName_2(), character_8.getMinRangeSkill_2(), character_8.getMaxRangeSkill_2(), character_8.getManaCost2());
            selectedCharacter_1.setBuffAndDebuff(character_8.getSupportSkillName(),character_8.getBuff(), character_8.getDebuff());
            return 8;}

        }
        return 0;
    }

    public int characterSelection_2(int num){
        //setCharacters();
        switch(num){

            case 1 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_1.getCharacterName(), character_1.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_1.getNormalSkillName(), character_1.getMinRangeNormalSkill(), character_1.getMaxRangeNormalSkill(), character_1.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_1.getSkillName_1(), character_1.getMinRangeSkill_1(), character_1.getMaxRangeSkill_1(), character_1.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_1.getSkillName_2(), character_1.getMinRangeSkill_2(), character_1.getMaxRangeSkill_2(), character_1.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_1.getSupportSkillName(),character_1.getBuff(), character_1.getDebuff());
            return 1;}

            case 2 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_2.getCharacterName(), character_2.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_2.getNormalSkillName(), character_2.getMinRangeNormalSkill(), character_2.getMaxRangeNormalSkill(), character_2.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_2.getSkillName_1(), character_2.getMinRangeSkill_1(), character_2.getMaxRangeSkill_1(), character_2.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_2.getSkillName_2(), character_2.getMinRangeSkill_2(), character_2.getMaxRangeSkill_2(), character_2.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_2.getSupportSkillName(),character_2.getBuff(), character_2.getDebuff());
            return 2;}

            case 3 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_3.getCharacterName(), character_3.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_3.getNormalSkillName(), character_3.getMinRangeNormalSkill(), character_3.getMaxRangeNormalSkill(), character_3.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_3.getSkillName_1(), character_3.getMinRangeSkill_1(), character_3.getMaxRangeSkill_1(), character_3.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_3.getSkillName_2(), character_3.getMinRangeSkill_2(), character_3.getMaxRangeSkill_2(), character_3.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_3.getSupportSkillName(),character_3.getBuff(), character_3.getDebuff());
            return 3;}

            case 4 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_4.getCharacterName(), character_4.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_4.getNormalSkillName(), character_4.getMinRangeNormalSkill(), character_4.getMaxRangeNormalSkill(), character_4.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_4.getSkillName_1(), character_4.getMinRangeSkill_1(), character_4.getMaxRangeSkill_1(), character_4.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_4.getSkillName_2(), character_4.getMinRangeSkill_2(), character_4.getMaxRangeSkill_2(), character_4.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_4.getSupportSkillName(),character_4.getBuff(), character_4.getDebuff());
            return 4;}

            case 5 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_5.getCharacterName(), character_5.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_5.getNormalSkillName(), character_5.getMinRangeNormalSkill(), character_5.getMaxRangeNormalSkill(), character_5.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_5.getSkillName_1(), character_5.getMinRangeSkill_1(), character_5.getMaxRangeSkill_1(), character_5.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_5.getSkillName_2(), character_5.getMinRangeSkill_2(), character_5.getMaxRangeSkill_2(), character_5.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_5.getSupportSkillName(),character_5.getBuff(), character_5.getDebuff());
            return 5;}

            case 6 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_6.getCharacterName(), character_6.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_6.getNormalSkillName(), character_6.getMinRangeNormalSkill(), character_6.getMaxRangeNormalSkill(), character_6.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_6.getSkillName_1(), character_6.getMinRangeSkill_1(), character_6.getMaxRangeSkill_1(), character_6.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_6.getSkillName_2(), character_6.getMinRangeSkill_2(), character_6.getMaxRangeSkill_2(), character_6.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_6.getSupportSkillName(),character_6.getBuff(), character_6.getDebuff());
            return 6;}

            case 7 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_7.getCharacterName(), character_7.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_7.getNormalSkillName(), character_7.getMinRangeNormalSkill(), character_7.getMaxRangeNormalSkill(), character_7.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_7.getSkillName_1(), character_7.getMinRangeSkill_1(), character_7.getMaxRangeSkill_1(), character_7.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_7.getSkillName_2(), character_7.getMinRangeSkill_2(), character_7.getMaxRangeSkill_2(), character_7.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_7.getSupportSkillName(),character_7.getBuff(), character_7.getDebuff());
            return 7;}

            case 8 -> {
            selectedCharacter_2.setPlayerSelectedCharacter(character_8.getCharacterName(), character_8.getHealth(), misc.getBaseMana());
            selectedCharacter_2.setCharacterNormalSkill(character_8.getNormalSkillName(), character_8.getMinRangeNormalSkill(), character_8.getMaxRangeNormalSkill(), character_8.getManaGain());
            selectedCharacter_2.setCharacterSkill_1(character_8.getSkillName_1(), character_8.getMinRangeSkill_1(), character_8.getMaxRangeSkill_1(), character_8.getManaCost1());
            selectedCharacter_2.setCharacterSkill_2(character_8.getSkillName_2(), character_8.getMinRangeSkill_2(), character_8.getMaxRangeSkill_2(), character_8.getManaCost2());
            selectedCharacter_2.setBuffAndDebuff(character_8.getSupportSkillName(),character_8.getBuff(), character_8.getDebuff());
            return 8;}

        }
        return 0;
    }

    public void displayBackStory(int playerNum){
        switch(playerNum)
        {
        case 1 -> character_1.displayBackStory();
        case 2 -> character_2.displayBackStory();
        case 3 -> character_3.displayBackStory();
        case 4->  character_4.displayBackStory();
        case 5 -> character_5.displayBackStory();
        case 6 -> character_6.displayBackStory();
        case 7 -> character_7.displayBackStory();
        case 8 -> character_8.displayBackStory();
    }
    }
    public void displayCharacterStats(int playerNum){
        switch(playerNum)
        {
        case 1 -> character_1.displayCharacterStats();
        case 2 -> character_2.displayCharacterStats();
        case 3 -> character_3.displayCharacterStats();
        case 4->  character_4.displayCharacterStats();
        case 5 -> character_5.displayCharacterStats();
        case 6 -> character_6.displayCharacterStats();
        case 7 -> character_7.displayCharacterStats();
        case 8 -> character_8.displayCharacterStats();
    }
    }
    
    //System.out.println("Ç ñ │ ║ © ® π ♥ ♦ ░ ▒ ▓ █  ─ «  » ╠ ╣ ║ ╦ ╩ ╬ ╗ ╝ ╔ ╚ ");
    public void displayCharacters(){
        System.out.println("                            ╔══════════════════════╗");
        System.out.println("                            ║   SELECT CHARACTER:  ║");
        System.out.println("                            ╚══════════════════════╝");
        System.out.println("         ╔══════════════════╦══════════════════════╦══════════════════╗");

        System.out.println("         ║ 0:   RANDOM      ║ 1: "+character_1.getCharacterName()+"    ║ 2: "+ character_2.getCharacterName()+"   ║");
        System.out.println("         ╠══════════════════╬══════════════════════╬══════════════════╣");
        System.out.println("         ║ 3: "+character_3.getCharacterName()+" ║ 4: "+character_4.getCharacterName()+"      ║ 5: "+ character_5.getCharacterName()+" ║");
        System.out.println("         ╠══════════════════╬══════════════════════╬══════════════════╣");
        System.out.println("         ║ 6: "+character_6.getCharacterName()+"  ║ 7: "+character_7.getCharacterName()+"  ║ 8: "+ character_8.getCharacterName()+"  ║");

        System.out.println("         ╚══════════════════╩══════════════════════╩══════════════════╝");
        System.out.println("\n\n\n\n");
    } 

    
    public int skillNumberForSelectedCharacter_1(int skillnum){
     
    int dmg = 0;
     
    switch(skillnum){
     
    case 1 -> { dmg  = selectedCharacter_1.getDamagefromNormalSkill(); } 
    case 2 -> { dmg  = selectedCharacter_1.getDamageFromSkill_1(); }
    case 3 -> {
        dmg  = selectedCharacter_1.getDamageFromSkill_2();
        selectedCharacter_2.setStatusEffect_On(selectedCharacter_1.getDebuff());//turns on
        selectedCharacter_1.setBuffAndDebuff(selectedCharacter_1.getSupportSkillName(),0,0);

    }

    }
    if(selectedCharacter_2.getIsBlocked() ==  true){dmg = 0;
        System.out.println(misc.BOLD+"** "+selectedCharacter_2.getCharacterName()+" is protected! **"+misc.RESET);
        selectedCharacter_2.setBlockedToFalse();}
    if(misc.killSwitch == true){dmg = 10000;}

    return dmg = 100;
    }

    public int skillNumberForSelectedCharacter_2(int skillnum){
     
    int dmg = 0;
    
    switch(skillnum){
     
    case 1 -> { dmg  = selectedCharacter_2.getDamagefromNormalSkill(); } 
    case 2 -> { dmg  = selectedCharacter_2.getDamageFromSkill_1(); }
    case 3 -> { 
        if((selectedCharacter_2.getMana() >= selectedCharacter_2.getManaCost2()) && selectedCharacter_2.getCooldown_2() <= 0){
        //can be bypassed with kill switch
        if(misc.killSwitch == true){
            selectedCharacter_1.setStatusEffect_On(1);
            selectedCharacter_1.setStatusEffect_On(2);
            selectedCharacter_1.setStatusEffect_On(3);
            selectedCharacter_1.setStatusEffect_On(4);
            selectedCharacter_1.setStatusEffect_On(5);
            selectedCharacter_1.setStatusEffect_On(6);
            }
        }

        dmg  = selectedCharacter_2.getDamageFromSkill_2();
        selectedCharacter_1.setStatusEffect_On(selectedCharacter_2.getDebuff());//turns on
        selectedCharacter_2.setBuffAndDebuff(selectedCharacter_2.getSupportSkillName(),0,0);
    }

    }
    if(selectedCharacter_1.getIsBlocked() ==  true){dmg = 0;
        System.out.println(misc.BOLD+"** "+selectedCharacter_1.getCharacterName()+" is protected! **"+misc.RESET);
        selectedCharacter_1.setBlockedToFalse();}   

    return dmg = 100;
    }
    
    public void dealDamageCharacter_1ToCharacter_2(int skillnum){
        // add 30% chance to miss :))
        if(skillnum == 4){
            selectedCharacter_1.useBlockOrProtect();
            return;
        }
        if(selectedCharacter_1.isParalyzed_TrueOrFalse() == true){ 
            if(misc.getRNG(3, 1) ==  1){
            System.out.println(misc.YELLOW+misc.BOLD+"PARALYZED: "+misc.RESET);
            System.out.println(misc.BOLD+"** "+misc.YELLOW+selectedCharacter_1.getCharacterName()+" is Paralyzed, can't move."+misc.WHITE+" **"+misc.RESET);
            return ;
            }
        }

        int missChance = misc.getRNG(100, 1);
        if(missChance <= 30){
            System.out.println(misc.BOLD+misc.RED+" ** "+misc.WHITE+selectedCharacter_1.getCharacterName()+" Attacks Missed!"+misc.RED+" ** "+misc.RESET+"\n");
            selectedCharacter_1.missedAttacksAfterEffect(skillnum);
            return;
        }
        int dmg = skillNumberForSelectedCharacter_1(skillnum);
        // to <- from
        selectedCharacter_2.minusHealth( misc.additionalCritDamage(misc.getRNG(100, 50),50,dmg) );

    }

    public void dealDamageCharacter_2ToCharacter_1(int skillnum){

        if(skillnum == 4){
            selectedCharacter_2.useBlockOrProtect();
            return;
        }
        if(selectedCharacter_2.isParalyzed_TrueOrFalse() == true){ 
            if(misc.getRNG(3, 1) ==  1){
            System.out.println(misc.YELLOW+misc.BOLD+"PARALYZED: "+misc.RESET);
            System.out.println(misc.BOLD+"** "+misc.YELLOW+selectedCharacter_2.getCharacterName()+" is Paralyzed, can't move."+misc.WHITE+" **"+misc.RESET);
            return;
            }
        }

        int missChance = misc.getRNG(100, 1);
        if(missChance <= 30){
            System.out.println(misc.BOLD+misc.RED+" ** "+misc.WHITE+selectedCharacter_2.getCharacterName()+" Attacks Missed!"+misc.RED+" ** "+misc.RESET+"\n");
            selectedCharacter_2.missedAttacksAfterEffect(skillnum);
            return;
        }
        int dmg = skillNumberForSelectedCharacter_2(skillnum);
        // to <- from
        selectedCharacter_1.minusHealth( misc.additionalCritDamage(misc.getRNG(100, 50),50,dmg) );
    }
    
}

