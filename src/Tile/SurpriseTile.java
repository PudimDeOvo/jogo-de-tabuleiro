package Tile;

import Player.*;
import java.util.ArrayList;
import java.util.Random;


public class SurpriseTile extends Tile{
    public SurpriseTile(){
        super();
    }

    public void effect(ArrayList<Player> players, int index){
        Random random = new Random();
        int card = random.nextInt(3) + 1;

        if (card == 1){
            Player player = new RegularPlayer(players.get(index).getColor(), players.get(index).getPosition(), true, players.get(index).getCountPlays());
            players.set(index, player);
        }
        else if (card == 2){
            Player player = new UnluckyPlayer(players.get(index).getColor(), players.get(index).getPosition(), true, players.get(index).getCountPlays());
            players.set(index, player);
        }
        else {
            Player player = new LuckyPlayer(players.get(index).getColor(), players.get(index).getPosition(), true, players.get(index).getCountPlays());
            players.set(index, player);
        }
    }
}
