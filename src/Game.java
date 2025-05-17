import Player.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Game {
    private int turn = 1;
    private final Gameboard gameboard = new Gameboard();

    public Game(){}

    public ArrayList<Player> defPlayers(ArrayList<String> colors, int numOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Choose the type of player " + (i+1) + ": (1- Regular, 2- Lucky, 3- Unlucky)\n");
            int playerType = input.nextInt();

            Player newPlayer = null;
            switch(playerType){
                case 1:
                    newPlayer = new RegularPlayer(colors.get(i), 0, true);
                    break;
                case 2:
                    newPlayer = new LuckyPlayer(colors.get(i), 0, true);
                    break;
                case 3:
                    newPlayer = new UnluckyPlayer(colors.get(i), 0, true);
                    break;
                default:
                    System.out.println("Invalid player type. Please choose again. \n");
                    i--;
                    break;
            }

            if(newPlayer != null){
                players.add(newPlayer);
            }
        }

        return players;
    }

    public boolean isGameValid(ArrayList<Player> players){
        Set<String> playerTypes = new HashSet<>();

        for (Player player : players) {
            playerTypes.add(player.getPlayerType());

            if (playerTypes.size() >= 2) {
                return true;
            }
        }
        return false;
    }

    public void listPlayers(ArrayList<Player> players){
        System.out.println("List of players: \n");
        for (int i = 0; i < players.size(); i++){
            System.out.println("P" + (i+1) + ": " + players.get(i).getColor() + " - " + players.get(i).getPlayerType() + "\n");
        }
    }

    // marcello disse: vou refinar essa buceta aqui depois. estou enlouquecendo. botar essa bct de funcao dentro de main
    // mas falta oq? ta bom ne nao
    public void playerTurn(ArrayList<Player> players, int playerIndex, Gameboard gameboard){
        int playerRoll = players.get(playerIndex).roll();

        players.get(playerIndex).setPosition(
                players.get(playerIndex).getPosition() + playerRoll
        );

        gameboard.getBoard().get(
                players.get(playerIndex).getPosition()
        ).effect(players, playerIndex);
    }

    public void startGame(ArrayList<Player> players, int playerIndex){
        while (true) {
            System.out.println("Turn " + turn + "\n");
            if(players.get(playerIndex).getNextMove()){
                System.out.println("Current player: " + players.get(playerIndex).getColor() + "\n");
                playerTurn(players, playerIndex, gameboard);
                listPlayers(players);
            }
            else{
                System.out.println("Player " + players.get(playerIndex).getColor() + " is skipping this turn.\n");
                players.get(playerIndex).setNextMove(true);
            }

            if (players.get(playerIndex).getPosition() >= 40) {
                System.out.println("Player " + players.get(playerIndex).getColor() + " wins! \n");
                break;
            }

            playerIndex += 1;
            turn++;
        }
        // ganhou ai mostra a lista dos jogador e o vencedor edepois reinicia o jogo
        System.out.println("Game over! \n");
        System.out.println("List of players and the count of each one's plays: \n");
        listPlayers(players);
        // nao pensei em como contar as jogadas
        // se pa criando uma lista de contadores mesmo? dai o index representa o jogador
        // exceto que quando dois jogadores trocarem de lugar tem que trocar o index dos contadores tambem ???
        // pensando...
    }

}
