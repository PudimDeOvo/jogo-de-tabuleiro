import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import GameModes.*;
import MyException.*;
import Player.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = null;

        System.out.println("----- Welcome to the game! -----\n");
        System.out.println("[Press any key to proceed]");
        String initialKey = input.nextLine();

        if (initialKey.equals("88224646")){
            game = new DebugMode();
        } else {
            game = new RegularMode();
        }
        System.out.println("----- Let's start by getting to know our competitors -----\n");
        int numPlayers = 0;
        boolean validInput = false;
        while (!validInput) {
            try{
                System.out.print("How many players will there be? (2-6): ");
                numPlayers = input.nextInt();

                if (numPlayers < 2 || numPlayers > 6) {
                    throw new numPlayersInvalid("Number of players must be between 2 and 6\n");
                }
                else{
                    validInput = true;
                }
            }
            catch (numPlayersInvalid | InputMismatchException e){
                System.out.println("Invalid input. Try again.");
                input.nextLine();
            }
        }



        System.out.println("----- Get ready! The game is starting! -----\n");
        input.nextLine(); // Lendo buffer

        game.startGame(input);

        input.close();
    }
}
