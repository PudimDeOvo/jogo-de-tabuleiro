package GameModes;

import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class RegularMode extends Game{
    public RegularMode(){super();};

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
