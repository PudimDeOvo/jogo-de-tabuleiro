package GameModes;

import Player.*;
import Gameboard.Gameboard;
import Tile.Tile;
import Tile.TileFactory;

import java.util.*;

public abstract class Game {
    Scanner input = new Scanner(System.in);
    private static final String invalidInputMessage = "Invalid input. Try again.";

    protected final Gameboard gameboard = Gameboard.getInstance();
    protected final List<String> colors = new ArrayList<>(Arrays.asList(
            "Red", "Blue", "Green", "Yellow", "Purple", "Orange", "Pink", "Cyan"
    ));


    protected Game(){
        //Sem necessidade de inicialização.
    }

    public void setupGameboard(int numOfTiles){
        for(int i = 0; i<numOfTiles; i++){
            System.out.print("Choose type for tile " + (i+1) + " (regular, goback, lucky, magic, nonextmove or surprise): ");
            String tileType = input.next();

            Tile tile = TileFactory.getTile(tileType);
            if (tile == null){
                System.out.println(invalidInputMessage);
                i--;
            } else {
                gameboard.getBoard().add(tile);
            }
        }
    }

    private final static int validNumberPlayers = 2;

    private boolean isGameValid(){
        Set<String> playerTypes = new HashSet<>();
        for (Player player : gameboard.getPlayers()){
            playerTypes.add(player.getPlayerType());

            if (playerTypes.size() >= validNumberPlayers){
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
                        System.out.println(invalidInputMessage);
                        i--;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(invalidInputMessage);
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

    private String formatPlayerInfo(Player player) {
        return "[Player: " + player.getColor() +
                " - Position: " + player.getPosition() +
                " - Total plays: " + player.getCountPlays() + "]";
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
            System.out.println(formatPlayerInfo(player));
        }
    }

}
