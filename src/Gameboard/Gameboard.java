package Gameboard;

import Player.Player;
import Tile.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Gameboard {
    private ArrayList<Tile> board;
    private ArrayList<Player> players;

    public Gameboard(){
        this.board = new ArrayList<>();
    }


    public boolean isGameValid(){
        Set<String> playerTypes = new HashSet<>();

        for (Player player : this.players) {
            playerTypes.add(player.getPlayerType());

            if (playerTypes.size() >= 2) {
                return true;
            }
        }
        return false;
    }

    public void listPlayers(){
        System.out.println("\n-----[List of players]: \n");
        for (int i = 0; i < this.players.size(); i++){
            System.out.println("P" + (i+1) + ": " + this.players.get(i).getColor() + " - " + this.players.get(i).getPlayerType() + " - Position: " + this.players.get(i).getPosition());
        }
        System.out.print("\n");
    }

    public ArrayList<Tile> getBoard() {
        return board;
    }
    public ArrayList<Player> getPlayers() { return players; }

}
