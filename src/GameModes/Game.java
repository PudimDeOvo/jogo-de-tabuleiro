package GameModes;

import Player.*;
import Gameboard.Gameboard;
import Tile.Tile;
import Tile.TileFactory;

import java.util.*;

public abstract class Game {
    Scanner input = new Scanner(System.in);

    protected final Gameboard gameboard = new Gameboard();
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
        //ADICIONAR TRATAMENTO DE EXCEÇÃO
        for(int i = 0; i<numOfTiles; i++){
            System.out.print("Choose type for tile " + (i+1) + " (regular, goback, lucky, magic, nonextmove or surprise): ");
            String TileType = input.next();

            Tile tile = TileFactory.getTile(TileType);
            if (tile == null){
                System.out.println("Invalid input. Try again");
                i++;
            } else {
                gameboard.getBoard().add(tile);
            }
        }
    }

    public void defPlayers(int numOfPlayers) {
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
                    gameboard.getPlayers().add(newPlayer);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again");
                input.nextLine();
                i--;
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

                    if (gameboard.getPlayers().get(i).getPosition() >= 40) {
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
