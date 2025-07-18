package GameModes;

import Gameboard.Gameboard;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class RegularMode extends Game{
    public RegularMode(){
        super();
    }

    public void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard, Scanner input){

        System.out.println("[Press any key to roll your dice!]");
        input.nextLine();

        int playerRoll = players.get(playerIndex).roll();

        if(players.get(playerIndex).getPosition() + playerRoll <= gameboard.getBoard().size()) {
            players.get(playerIndex).setPosition(
                    players.get(playerIndex).getPosition() + playerRoll
            );
            gameboard.getBoard().get(
                    players.get(playerIndex).getPosition()
            ).effect(players, playerIndex);
        } else {
            players.get(playerIndex).setPosition(gameboard.getBoard().size());
        }

        players.get(playerIndex).setCountPlays(
                players.get(playerIndex).getCountPlays() + 1
        );
    }

}
