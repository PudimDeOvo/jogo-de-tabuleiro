package Player;
import java.util.Random;

public class UnluckyPlayer extends Player{
    private String color;

    public UnluckyPlayer(String color, int position, boolean nextMove, int countPlays) {
        super(color, position, "Unlucky", nextMove, countPlays);
    }

    @Override
    public int roll(){
        Random random = new Random();
        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;

        if (d1 + d2 > 6 ) {
            return roll();
        }
        else if (d1 == d2){
            System.out.println("Lucky roll! " + d1 + " and " + d2 + "\n");
            return (d1 + d2) + roll();
        }
        else {
            System.out.println("Dice rolls: " + d1 + " and " + d2 + "\n");
            return d1 + d2;
        }
    }


}
