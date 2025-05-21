package GameModes;

import Gameboard.Gameboard;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class DebugMode extends Game{

    public DebugMode(){
        super();
        System.out.println("-----[WARNING: DEBUG MODE ACTIVE]-----");
    }

    public void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard, Scanner input){
        System.out.println("How much should P" + (playerIndex+1) + " move?");
        int playerRoll = input.nextInt();

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

}
