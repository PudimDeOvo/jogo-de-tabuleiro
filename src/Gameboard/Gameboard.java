package Gameboard;

import Player.Player;
import Tile.*;

import java.util.ArrayList;


public class Gameboard {
    private static Gameboard instance;
    private final ArrayList<Tile> board;
    private final ArrayList<Player> players;

    protected Gameboard(){
        this.board = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public static Gameboard getInstance(){
        if (instance == null){
            instance = new Gameboard();
        }
        return instance;
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
