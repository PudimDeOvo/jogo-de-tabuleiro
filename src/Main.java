import java.util.ArrayList;
import java.util.Scanner;
import MyException.*;
import Player.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game();

        ArrayList<String> colors = new ArrayList<>() {{
            add("Blue");
            add("Red");
            add("Green");
            add("Yellow");
            add("Pink");
            add("Purple");
        }};


        System.out.println("----- Welcome to the game! -----\n");
        System.out.println("----- Let's start by getting to know our competitors -----\n");

        int numPlayers = 0;
        boolean validInput = false;
        while (!validInput) {
            try{
                System.out.println("How many players will there be? (2-6)\n");
                numPlayers = input.nextInt();

                if (numPlayers < 2 || numPlayers > 6) {
                    throw new numPlayersInvalid("Number of players must be between 2 and 6\n");
                }
                validInput = true;
            }
            catch (numPlayersInvalid e){
                System.out.println("Invalid input. Try again.\n");
            }
        }

        ArrayList<Player> players = new ArrayList<>();
        while (!game.isGameValid(players)){
            players = game.defPlayers(colors, numPlayers);

            if (game.isGameValid(players)){
                System.out.println("All set!");
                game.listPlayers(players);
                System.out.println("Booting up board game...\n");
            } else {
                System.out.println("Invalid player configuration: Should have at least two different types.\n");
            }
        }

        input.close();
        //System.out.println("----- Game is starting! -----\n");
        //game.startGame(players, 0);
    }
}
