import Player.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public Game(){}

    public ArrayList<Player> defPlayers(ArrayList<String> colors, int numOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Choose the type of player " + (i+1) + ": (1- Regular, 2- Lucky, 3- Unlucky)");
            int playerType = input.nextInt();

            Player newPlayer = null;
            switch(playerType){
                case 1:
                    newPlayer = new RegularPlayer(colors.get(i), 0);
                    break;
                case 2:
                    newPlayer = new LuckyPlayer(colors.get(i), 0);
                    break;
                case 3:
                    newPlayer = new UnluckyPlayer(colors.get(i), 0);
                    break;
                default:
                    System.out.println("Invalid player type. Please choose again.");
                    i--;
                    break;
            }

            if(newPlayer != null){
                players.add(newPlayer);
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
        System.out.println("List of players: ");
        for (int i = 0; i < players.size(); i++){
            System.out.println("P" + (i+1) + ": " + players.get(i).getColor() + " - " + players.get(i).getPlayerType());
        }
    }


    // vou refinar essa merda depois. eu to enlouquecendo aqui ja
    // botar essa buceta de função dentro de um for na main
    public void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard){
        int playerRoll = players.get(playerIndex).roll();

        players.get(playerIndex).setPosition(
                players.get(playerIndex).getPosition() + playerRoll
        );

        gameboard.getBoard().get(
                players.get(playerIndex).getPosition()
        ).effect(players, playerIndex);
    }

}
