package Tile;

import Player.Player;

import java.util.ArrayList;

public class RegularTile extends Tile{
    public RegularTile(){
        // Sem necessidade de inicialização.
    }

    public void effect(ArrayList<Player> players, int index){
        System.out.println("Regular tile. Nothing special.");
    }
}
