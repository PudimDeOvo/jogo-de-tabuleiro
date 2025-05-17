package Tile;
import Player.Player;
import java.util.ArrayList;

public class NoNextMoveTile extends Tile {
    public NoNextMoveTile(){
        super();
    }

    public void effect(ArrayList<Player> players, int index){
        System.out.println("No next move tile! You lose your next turn!");
        players.get(index).setNextMove(false);
    }
}
