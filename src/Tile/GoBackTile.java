package Tile;

import Player.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GoBackTile extends Tile{
    public GoBackTile() {
        super();
    }

    public void effect(ArrayList<Player> players, int index) {
        System.out.println("Uuuhh! Choose a player to go back to the beginning of the board (1, 2, ...): ");
        Scanner input = new Scanner(System.in);

        boolean validInput = false;
        int indexGoBackPlayer;
        while(!validInput) {
            try {
                indexGoBackPlayer = (input.nextInt() - 1);
                players.get(indexGoBackPlayer).setPosition(0);

                System.out.println("Looks like [" + players.get(indexGoBackPlayer).getColor() + "] is in deep trouble!");
                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Type only numbers.");
                input.nextLine();
            } catch (IndexOutOfBoundsException i) {
                System.out.println("Invalid input. Player not assigned. Try again.");
                input.nextLine();
            }
        }


        input.nextLine(); // consumindo o abençoado do buffer
    }
}
