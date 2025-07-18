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
        for(int i = 0; i < this.players.size(); i++){
            System.out.println(formatPlayerInfo(this.players.get(i)));
        }
        System.out.print("\n");
    }

    private String formatPlayerInfo(Player player) {
        return "P" + (players.indexOf(player) + 1) + ": " + player.getColor() + " - " + player.getPlayerType() + " - Position: " + player.getPosition();
    }

    public ArrayList<Tile> getBoard() {
        return board;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

}
