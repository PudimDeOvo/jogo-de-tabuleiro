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


    public abstract void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard, Scanner input);

    public void startGame(ArrayList<Player> players, Scanner input){
        int turn = 1;
        boolean haveWinner = false;

        while (!haveWinner) {
            for (int i = 0; i < players.size(); i++) {
                System.out.println("-----[TURN " + turn + "]-----");

                if (players.get(i).getNextMove()) {
                    System.out.println("Current player: P" + (i + 1) + " - " + players.get(i).getColor() + "\n");
                    playerTurn(players, i, gameboard, input);

                    if (players.get(i).getPosition() >= 40) {
                        System.out.println("Player " + players.get(i).getColor() + " wins! \n");
                        haveWinner = true;
                        break;
                    }

                    listPlayers(players);

                } else {
                    System.out.println("Player " + players.get(i).getColor() + " is skipping this turn.\n");
                    players.get(i).setNextMove(true);
                }

                System.out.println("[Press any key to proceed]");
                input.nextLine();
            }
        }


        System.out.println("----- We have a winner! ----- \n");
        System.out.println("List of players and the count of each one's plays: \n");

        for (Player player : players) {
            System.out.println("[Player: " + player.getColor() +
                    " in position: " + player.getPosition() +
                    " - Total plays: " + player.getCountPlays() + "]\n");
        }
    }

}
