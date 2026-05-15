import entities.EntityInformation;

public class Game {

    public static void game(){
        EntityInformation character_Junwel = new EntityInformation();
        EntityInformation character_JohnEricRibo = new EntityInformation();

        System.out.println(character_Junwel.en_CharJunwel.getName());
        System.out.println(character_Junwel.en_CharJunwel.getDescription());

        System.out.println(character_JohnEricRibo.en_CharJohnEricRibo.getName());
        System.out.println(character_JohnEricRibo.en_CharJohnEricRibo.getDescription());
    }
    
}
