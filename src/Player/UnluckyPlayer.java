package Player;
import java.util.Random;

public class UnluckyPlayer extends Player{
    Random random = new Random();

    private static final int diceSides = 6;
    private static final int minDiceValue = 1;

    public UnluckyPlayer(String color, int position, boolean nextMove, int countPlays) {
        super(color, position, "Unlucky", nextMove, countPlays);
    }

    @Override
    public int roll(){
        int d1 = this.random.nextInt(diceSides) + minDiceValue;
        int d2 = this.random.nextInt(diceSides) + minDiceValue;

        if (d1 + d2 > diceSides ) {
            return roll();
        }
        else if (d1 == d2){
            System.out.println("Lucky roll! " + d1 + " and " + d2);
            return (d1 + d2) + roll();
        }
        else {
            System.out.println("Dice rolls: " + d1 + " and " + d2 + "\n");
            return d1 + d2;
        }
    }


}
