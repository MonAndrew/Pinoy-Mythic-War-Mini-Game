package character;

public interface CharacterStats {
    
    //Character ItSelf
    public void setCharacter();
    public void displayBackStory();
    public void displayCharacterStats();
    public void setCharacterName(String characterName);
    public void setCharacterStats(int health, int mana);
    public void setCharacterNormalSkill(String skillName, int min, int max, int manaGain);
    public void setCharacterSkill_1(String skillName, int min,int max, int manaCost);
    public void setCharacterSkill_2(String skillName, int min,int max, int manaCost);
    public void setCharacterSupportSkill(String skillName,double buff, double debuff);
    //just gets
    public String getCharacterName();
    public int getHealth();
    public int getMana();
    public int getManaGain();
    public int getManaCost1();
    public int getManaCost2();
    //normal skill
    public String getNormalSkillName();
    public int getMinRangeNormalSkill();
    public int getMaxRangeNormalSkill();
    //skill 1
    public String getSkillName_1();
    public int getMinRangeSkill_1();
    public int getMaxRangeSkill_1();
    //skill 2
    public String getSkillName_2();
    public int getMinRangeSkill_2();
    public int getMaxRangeSkill_2();
    public int getBuff();
    public int getDebuff();

}
