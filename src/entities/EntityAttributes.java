package entities;

public class EntityAttributes {
    private int level;
    private String name;
    private String description;

    private int attackPower;
    private int defense;

    public EntityAttributes(
        int level, String name, String description,
        int attackPower, int defense
    ){
        this.level = level;
        this.name =  name;
        this.description = description;

        //stats
        this.attackPower = attackPower;
        this.defense = defense;
    }

    //getters
    public int getLevel(){    return this.level;}
    public String getName(){    return this.name;}
    public String getDescription(){    return this.description;}

    public int getAttackPower(){    return this.attackPower;}
    public int getDefense(){    return this.defense;}

    //public int skill();

}
