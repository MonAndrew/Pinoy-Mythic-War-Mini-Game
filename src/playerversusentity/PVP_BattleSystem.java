/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playerversusentity;
import java.util.*;
/**
 *
 * @author junwe
 */
public class PVP_BattleSystem {
    
    public void startBattle(){
        Scanner scan = new Scanner(System.in);
        Random ranNum = new Random();
        boolean chooseHT = true;
        
        
        CharacterStatsBase player1 = new Juncoco_Maarti();
        CharacterStatsBase player2 = new Juncoco_Maarti();
        
        try{
            int[] wasChoosen = new int[8];
            int i= 0;

            //MAKE SURE ALL CHARACTERS START AS NOT CHOOSEN
            for(i = 0; i < 8; i++){
                wasChoosen[i] = 0;
            }


            System.out.println("Player 1 -> Choose your character:");
            System.out.println("1. Juncoco Maarti    5. Zak Rebirto");
            System.out.println("2. Ruby Galapad      6. CynaMon");
            System.out.println("3. Jhong Kenario     7. Zaldiko");
            System.out.println("4. Manny Pacqyow     8. Johnder Ford");
            System.out.print("Enter choice: ");
            int input = scan.nextInt();
            
            switch(input){
                case 1:
                        player1 = new Juncoco_Maarti();
                        wasChoosen[0] = 1;
                        break;
                    case 2:
                        player1 = new Ruby_Galapad();
                        wasChoosen[1] = 1;
                        break;
                    case 3:
                        player1 = new Jhong_Kinario();
                        wasChoosen[2] = 1;
                        break;
                    case 4:
                        player1 = new Manny_Pacqyow();
                        wasChoosen[3] = 1;
                        break;
                    case 5:
                        player1 = new Zak_Rebirto();
                        wasChoosen[4] = 1;
                        break;
                    case 6:
                        player1 = new CynaMon();
                        wasChoosen[5] = 1;
                        break;
                    case 7:
                        player1 = new Zaldiko();
                        wasChoosen[6] = 1;
                        break;
                    case 8:
                        player1 = new Johnder_Ford();
                        wasChoosen[7] = 1;
                        break;
                    default:
                        break;
                    }
        }catch(Exception e){
            System.out.println("AT PVP BATTLE SYSTEM! CHOOSE CHARACTER");
            scan.next();
        }
        
        
        
        while(player1.isAlive() && player2.isAlive()){
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void ifAvail(int x){
        if(x == 0){
            System.out.println("Available");
        }else{
            System.out.println("Not available");
        }
    }
    
    
    
    
}
