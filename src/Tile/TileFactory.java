package Tile;

public class TileFactory {
    private TileFactory(){
        //Sem necessidade de inicialização.
    }

    public static Tile getTile(String tileType){
        tileType = tileType.toLowerCase();

        return switch (tileType) {
            case "goback" -> new GoBackTile();
            case "lucky" -> new LuckyTile();
            case "magic" -> new MagicTile();
            case "nonextmove" -> new NoNextMoveTile();
            case "regular" -> new RegularTile();
            case "surprise" -> new SurpriseTile();
            default -> null;
        };
    }
}
