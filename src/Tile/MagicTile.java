package Tile;
import Player.Player;
import java.util.ArrayList;

public class MagicTile extends Tile{
    public MagicTile() {
        super();
    }

    public void effect(ArrayList<Player> players, int index) {
        System.out.println("Magic tile! Now, you're switching positions with the player most behind: ");
        int indexSwapPlayer = 1;
        for(int i = 0; i < players.size(); i++){
            if (players.get(i).getPosition() < players.get(indexSwapPlayer).getPosition()){
                indexSwapPlayer = i;
            }
        }
        String chosenPlayer = players.get(index).getColor();
        String swappedPlayer = players.get(indexSwapPlayer).getColor();
        System.out.println("Woooohh! Swapping positions between player "+ chosenPlayer + " and player " + swappedPlayer + "!");

        int temp1 = players.get(index).getPosition();
        int temp2 = players.get(indexSwapPlayer).getPosition();
        players.get(index).setPosition(temp2);
        players.get(indexSwapPlayer).setPosition(temp1);
    }
}
