import Player.Player;
import Tile.*;

import java.util.ArrayList;

public class Gameboard {
    private ArrayList<Tile> board = new ArrayList<>();

    public Gameboard(){

        for (int i = 0; i < 40; i++){
            if (i == 10 || i == 25 || i == 38){
                NoNextMoveTile tile = new NoNextMoveTile();
                board.add(tile);
            }
            else if (i == 13){
                SurpriseTile tile = new SurpriseTile();
                board.add(tile);
            }
            else if (i == 5 || i == 15 || i == 30){
                LuckyTile tile = new LuckyTile();
                board.add(tile);
            }
            else if (i == 17 || i == 27){
                GoBackTile tile = new GoBackTile();
                board.add(tile);
            }
            else if (i == 20 || i == 35){
                MagicTile tile = new MagicTile();
                board.add(tile);
            }
            else {
                RegularTile tile = new RegularTile();
                board.add(tile);
            }
        }
    }

    public ArrayList<Tile> getBoard() {
        return board;
    }

}
