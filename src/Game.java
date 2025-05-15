import Player.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public Game(){}

    public void setupGame(ArrayList<String> colors, int numOfPlayers) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Choose the type of player " + (i+1) + ": (1- Regular, 2- Lucky, 3- Unlucky)");
            int playerType = input.nextInt();

            Player newPlayer = null;
            switch(playerType){
                case 1:
                    newPlayer = new RegularPlayer(colors.get(i), 0);
                    break;
                case 2:
                    newPlayer = new LuckyPlayer(colors.get(i), 0);
                    break;
                case 3:
                    newPlayer = new UnluckyPlayer(colors.get(i), 0);
                    break;
                default:
                    System.out.println("Invalid player type. Please choose again.");
                    i--;
                    break;
            }

            if(newPlayer != null){
                players.add(newPlayer);
            }
        }

        // ADICIONAR EXCEÇÃO PRA QUANDO NÃO HOUVER MAIS DE UM TIPO DE JOGADOR

        System.out.println("List of players: ");
        for (int i = 0; i < players.size(); i++){
            System.out.println("P" + (i+1) + ": " + colors.get(i) + " - " + players.get(i).getPlayerType());
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
