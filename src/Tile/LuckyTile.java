package Tile;
import Player.Player;
import Player.UnluckyPlayer;
import java.util.ArrayList;

public class LuckyTile extends Tile{
    public LuckyTile(){
        super();
    }

    private static final int walkThree = 3;

    public void effect(ArrayList<Player> players, int index){
        if (!(players.get(index) instanceof UnluckyPlayer)){

            System.out.println("Lucky tile! Walking three more tiles!");
            players.get(index).setPosition(
                    players.get(index).getPosition() + walkThree
            );
        }
        else {
            System.out.println("Lucky tile! Too bad you're unlucky!");
        }
    }
}
