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

        int numPlayers = 0;
        boolean validInput = false;

        while (!validInput) {
            try{
                System.out.println("Choose how many players would you like to play with: (2-6)");
                numPlayers = input.nextInt();

                if (numPlayers < 2 || numPlayers > 6) {
                    throw new numPlayersInvalid("Number of players must be between 2 and 6");
                }

                validInput = true;
            }
            catch (numPlayersInvalid e){
                System.out.println("Invalid input. Try again.\n");
            }
        }

        game.setupGame(colors, numPlayers);

        input.close();
    }
}
