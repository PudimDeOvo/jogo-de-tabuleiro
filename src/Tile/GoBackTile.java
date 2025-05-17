package Tile;

import Player.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GoBackTile extends Tile{
    public GoBackTile() {
        super();
    }

    public void effect(ArrayList<Player> players, int index) {
        System.out.println("Uuuhh! Choose a player to go back to the beginning of the board: ");
        Scanner input = new Scanner(System.in);
        int indexGoBackPlayer = input.nextInt();
        System.out.println("Haha! You're in trouble");
        players.get(indexGoBackPlayer).setPosition(0);
        
    }
}
