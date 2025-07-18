package Tile;

import Player.*;
import java.util.ArrayList;
import java.util.Random;

public class SurpriseTile extends Tile{
    Random random = new Random();

    private static final int numCard = 3;
    private static final int minCardValue = 1;

    public SurpriseTile(){
        super();
    }

    public void effect(ArrayList<Player> players, int index){
        int card = this.random.nextInt(numCard) + minCardValue;

        if (card == 1){
            Player player = new RegularPlayer(players.get(index).getColor(), players.get(index).getPosition(), true, players.get(index).getCountPlays());
            players.set(index, player);
            System.out.println("Player P" + (index + 1) + " became " + players.get(index).getPlayerType());
        }
        else if (card == 2){
            Player player = new UnluckyPlayer(players.get(index).getColor(), players.get(index).getPosition(), true, players.get(index).getCountPlays());
            players.set(index, player);
            System.out.println("Player P" + (index + 1) + " became " + players.get(index).getPlayerType());
        }
        else {
            Player player = new LuckyPlayer(players.get(index).getColor(), players.get(index).getPosition(), true, players.get(index).getCountPlays());
            players.set(index, player);
            System.out.println("Player P" + (index + 1) + " became " + players.get(index).getPlayerType());
        }
    }
}
