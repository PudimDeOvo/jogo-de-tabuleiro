package GameModes;

import Player.*;
import Gameboard.Gameboard;
import Tile.Tile;
import Tile.TileFactory;

import java.util.*;

public abstract class Game {
    Scanner input = new Scanner(System.in);

    protected final Gameboard gameboard = Gameboard.getInstance();
    ArrayList<String> colors = new ArrayList<>() {{
        add("Blue");
        add("Red");
        add("Green");
        add("Yellow");
        add("Pink");
        add("Purple");
    }};


    public Game(){}

    public void setupGameboard(int numOfTiles){
        for(int i = 0; i<numOfTiles; i++){
            System.out.print("Choose type for tile " + (i+1) + " (regular, goback, lucky, magic, nonextmove or surprise): ");
            String TileType = input.next();

            Tile tile = TileFactory.getTile(TileType);
            if (tile == null){
                System.out.println("Invalid input. Try again");
                i--;
            } else {
                gameboard.getBoard().add(tile);
            }
        }
    }

    private boolean isGameValid(){
        Set<String> playerTypes = new HashSet<>();
        for (Player player : gameboard.getPlayers()){
            playerTypes.add(player.getPlayerType());

            if (playerTypes.size() >= 2){
                return true;
            }
        }
        return false;
    }

    public void defPlayers(int numOfPlayers) {
        while(!isGameValid()){
            gameboard.getPlayers().clear();
            for (int i = 0; i < numOfPlayers; i++) {
                try {
                    System.out.print("Choose the type of player " + (i+1) + " (1- Regular, 2- Lucky, 3- Unlucky): ");
                    int playerType = input.nextInt();

                    Player newPlayer = PlayerFactory.getPlayer(playerType, colors.get(i));
                    if (newPlayer != null) {
                        gameboard.getPlayers().add(newPlayer);
                    } else {
                        System.out.println("Invalid player type. Please choose again.");
                        i--;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Try again");
                    input.nextLine();
                    i--;
                }
            }

            if (isGameValid()){
                System.out.println("\n----- All set! -----");
                gameboard.listPlayers();
                System.out.println("Booting up board game...\n");
            } else {
                System.out.println("Invalid player configuration: Should have at least two different types.\n");
            }
        }
    }


    public abstract void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard, Scanner input);

    public void startGame(Scanner input){
        int turn = 1;
        boolean haveWinner = false;

        while (!haveWinner) {
            for (int i = 0; i < gameboard.getPlayers().size(); i++) {
                System.out.println("-----[TURN " + turn + "]-----");

                if (gameboard.getPlayers().get(i).getNextMove()) {
                    System.out.println("Current player: P" + (i + 1) + " - " + gameboard.getPlayers().get(i).getColor() + "\n");
                    playerTurn(gameboard.getPlayers(), i, gameboard, input);

                    if (gameboard.getPlayers().get(i).getPosition() >= gameboard.getBoard().size()) {
                        System.out.println("Player " + gameboard.getPlayers().get(i).getColor() + " wins! \n");
                        haveWinner = true;
                        break;
                    }

                    gameboard.listPlayers();

                } else {
                    System.out.println("Player " + gameboard.getPlayers().get(i).getColor() + " is skipping this turn.\n");
                    gameboard.getPlayers().get(i).setNextMove(true);
                }

                System.out.println("[Press any key to proceed]");
                input.nextLine();
            }
        }


        System.out.println("----- We have a winner! ----- \n");
        System.out.println("List of players and the count of each one's plays: \n");

        for (Player player : gameboard.getPlayers()) {
            System.out.println("[Player: " + player.getColor() +
                    " in position: " + player.getPosition() +
                    " - Total plays: " + player.getCountPlays() + "]\n");
        }
    }

}
