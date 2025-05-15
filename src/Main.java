import java.util.Scanner;
import MyException.*;
import Player.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Welcome to the game! -----");
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Choose how many players would you like to play with: (1-6)");
            int numPlayers = input.nextInt();
            if (numPlayers < 1 || numPlayers > 6) {
                throw new numPlayersInvalid("Number of players must be between 1 and 6");
            }
            System.out.println("You have chosen " + numPlayers + " players.");
            System.out.println("Please choose the type of players you want to play with: ");
            for(int i = 1; i <= numPlayers; i++){
                System.out.println("Choose the type of player " + i + ": (1- Regular, 2- Lucky, 3- Unlucky)");
                int playerType = input.nextInt();
                switch(playerType){
                    case 1:
                        System.out.println("Player " + i + " is a Regular player.");
                        break;
                    case 2:
                        System.out.println("Player " + i + " is a Lucky player.");
                        break;
                    case 3:
                        System.out.println("Player " + i + " is an Unlucky player.");
                        break;
                    default:
                        System.out.println("Invalid player type. Please choose again.");
                        i--;
                        break;
                }
                System.out.println("Choose the color of the player " + i + ": (1- Red, 2- Blue, 3- Green, 4- Yellow, 5 - Orange, 6- Purple)");
                int playerColor = input.nextInt();
                switch(playerColor){
                    case 1:
                        System.out.println("Player " + i + " is Red.");
                        break;
                    case 2:
                        System.out.println("Player " + i + " is Blue.");
                        break;
                    case 3:
                        System.out.println("Player " + i + " is Green.");
                        break;
                    case 4:
                        System.out.println("Player " + i + " is Yellow.");
                        break;
                    case 5:
                        System.out.println("Player " + i + " is Orange.");
                        break;
                    case 6:
                        System.out.println("Player " + i + " is Purple.");
                        break;
                    default:
                        System.out.println("Invalid player color. Please choose again.");
                        i--;
                        break;
                }
            }

        }
        catch(numPlayersInvalid e){
            System.out.println("Invalid input.");
        }
        finally{
            input.close();
        }
        System.out.println("----- All players set! Let's start the game! -----");
        //iniciarJogo() ?
    }
}
