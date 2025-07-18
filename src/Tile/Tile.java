package Tile;

import Player.Player;
import java.util.ArrayList;

public abstract class Tile {
    protected Tile(){
        //Sem necessidade de inicialização.
    }
    public abstract void effect(ArrayList<Player> players, int index);
}
