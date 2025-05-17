package GameModes;

import Player.*;
import Gameboard.Gameboard;
import java.util.*;

public abstract class Game {
    protected final Gameboard gameboard = new Gameboard();

    public Game(){}

    public ArrayList<Player> defPlayers(ArrayList<String> colors, int numOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numOfPlayers; i++) {
            try {
                System.out.print("Choose the type of player " + (i+1) + " (1- Regular, 2- Lucky, 3- Unlucky): ");
                int playerType = input.nextInt();

                Player newPlayer = null;
                switch(playerType) {
                    case 1:
                        newPlayer = new RegularPlayer(colors.get(i), 0, true, 0);
                        break;
                    case 2:
                        newPlayer = new LuckyPlayer(colors.get(i), 0, true, 0);
                        break;
                    case 3:
                        newPlayer = new UnluckyPlayer(colors.get(i), 0, true, 0);
                        break;
                    default:
                        System.out.println("Invalid player type. Please choose again. \n");
                        i--;
                        break;
                }
                if (newPlayer != null) {
                    players.add(newPlayer);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again");
                input.nextLine();
                i--;
            }
        }

        return players;
    }

    public boolean isGameValid(ArrayList<Player> players){
        Set<String> playerTypes = new HashSet<>();

        for (Player player : players) {
            playerTypes.add(player.getPlayerType());

            if (playerTypes.size() >= 2) {
                return true;
            }
        }
        return false;
    }

    public void listPlayers(ArrayList<Player> players){
        System.out.println("\n-----[List of players]: \n");
        for (int i = 0; i < players.size(); i++){
            System.out.println("P" + (i+1) + ": " + players.get(i).getColor() + " - " + players.get(i).getPlayerType() + " - Position: " + players.get(i).getPosition());
        }
        System.out.print("\n");
    }

    // marcello disse: vou refinar essa buceta aqui depois. estou enlouquecendo. botar essa bct de funcao dentro de main
    // mds na vdd to enlouquecendo tambem!!!
    public void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard, Scanner input) {

        System.out.println("[Press any key to roll your dice!]");
        input.nextLine();

        int playerRoll = players.get(playerIndex).roll();

        if(players.get(playerIndex).getPosition() + playerRoll <= 40) {
            players.get(playerIndex).setPosition(
                    players.get(playerIndex).getPosition() + playerRoll
            );
            gameboard.getBoard().get(
                    players.get(playerIndex).getPosition()
            ).effect(players, playerIndex);
        } else {
            players.get(playerIndex).setPosition(40);
        }

        players.get(playerIndex).setCountPlays(
                players.get(playerIndex).getCountPlays() + 1
        );
    }


    public abstract void startGame(ArrayList<Player> players, Scanner input);

}
