package MainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

import GameModes.*;
import MyException.*;

public class Main {
    private static final String invalidInputMessage = "Invalid input. Try again.";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game;

        System.out.println("----- Welcome to the game! -----\n");
        System.out.println("[Press any key to proceed]");
        String initialKey = input.nextLine();

        if (initialKey.equals("88224646")){
            game = new DebugMode();
        } else {
            game = new RegularMode();
        }
        System.out.println("----- Let's start by getting to know our gameboard -----");
        System.out.println("----- How many tiles will there be? -----");

        int numTiles = 0;
        boolean validInput = false;

        while (!validInput){
            try{
                numTiles = input.nextInt();

                if (numTiles > 0){
                    validInput = true;
                } else {
                    System.out.println(invalidInputMessage);
                }

            } catch (InputMismatchException e) {
                System.out.println(invalidInputMessage);
                input.nextLine();
            }
        }

        game.setupGameboard(numTiles);


        System.out.println("----- And how about our competitors? -----\n");

        int numPlayers = 0;
        validInput = false;
        while (!validInput) {
            try{
                System.out.print("How many players will there be? (2-6): ");
                numPlayers = input.nextInt();

                if (numPlayers < 2 || numPlayers > 6) {
                    throw new NumPlayersInvalid("Number of players must be between 2 and 6\n");
                }
                else{
                    validInput = true;
                }
            }
            catch (NumPlayersInvalid | InputMismatchException e){
                System.out.println(invalidInputMessage);
                input.nextLine();
            }
        }
        game.defPlayers(numPlayers);

        System.out.println("----- Get ready! The game is starting! -----\n");
        input.nextLine(); // Lendo buffer

        game.startGame(input);

        input.close();
    }
}