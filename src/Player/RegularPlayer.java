package Player;
import java.util.Random;

public class RegularPlayer extends Player{
    private String color;

    public RegularPlayer(String color) {
        super(color);
    }

    public int roll(){
        Random random = new Random();
        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;

        if (d1 == d2){
            System.out.println("Lucky roll! " + d1 + " and " + d2);
            return (d1 + d2) + roll();
        }
        else {
            System.out.println("Dice rolls: " + d1 + " and " + d2);
            return d1 + d2;
        }
    }



}
