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

        ArrayList<String> colors = new ArrayList<>() {{
            add("Blue");
            add("Red");
            add("Green");
            add("Yellow");
            add("Pink");
            add("Purple");
        }};

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


        ArrayList<Player> players = new ArrayList<>();
        while (!game.isGameValid(players)){
            players = game.defPlayers(colors, numPlayers);

            if (game.isGameValid(players)){
                System.out.println("\n----- All set! -----");
                game.listPlayers(players);
                System.out.println("Booting up board game...\n");
            } else {
                System.out.println("Invalid player configuration: Should have at least two different types.\n");
            }
        }

        System.out.println("----- Get ready! The game is starting! -----\n");
        input.nextLine(); // Lendo buffer

        game.startGame(players, input);

        input.close();
    }
}
