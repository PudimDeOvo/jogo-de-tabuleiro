package Tile;

public class TileFactory {
    public static Tile getTile(String TileType){
        TileType = TileType.toLowerCase();

        return switch (TileType) {
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
