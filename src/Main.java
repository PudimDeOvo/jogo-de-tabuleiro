import Player.LuckyPlayer;
import Player.RegularPlayer;
import Player.UnluckyPlayer;

public class Main {
    public static void main(String[] args) {

        RegularPlayer player = new RegularPlayer("azul");
        System.out.print(player.roll());
    }
}