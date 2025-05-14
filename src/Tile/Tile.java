package Tile;

import Player.Player;
import java.util.ArrayList;

public abstract class Tile {
    public Tile(){};
    public abstract void effect(ArrayList<Player> players, int index);
}
