package Tile;
import Player.Player;
import Player.UnluckyPlayer;
import java.util.ArrayList;

public class LuckyTile extends Tile{
    public LuckyTile(){
        super();
    }

    public void effect(ArrayList<Player> players, int index){
        if (!(players.get(index) instanceof UnluckyPlayer)){

            System.out.println("Lucky tile! Walking three more tiles!");
            players.get(index).setPosition(
                    players.get(index).getPosition() + 3
            );
        }
        else {
            System.out.println("Lucky tile! Too bad you're unlucky!");
        }
    }
}
