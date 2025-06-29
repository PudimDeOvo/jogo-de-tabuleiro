package Player;

public class PlayerFactory {
    private PlayerFactory(){
        //Sem necessidade de inicialização.
    }

    public static Player getPlayer(int playerType, String color){
        return switch (playerType) {
            case 1 -> new RegularPlayer(color, 0, true, 0);
            case 2 -> new LuckyPlayer(color, 0, true, 0);
            case 3 -> new UnluckyPlayer(color, 0, true, 0);
            default -> null;
        };
    }
}
