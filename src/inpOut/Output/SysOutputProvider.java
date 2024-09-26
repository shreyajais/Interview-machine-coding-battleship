package inpOut.Output;



import model.Player;

import java.util.List;

public class SysOutputProvider implements IOutputProvider{
    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printWinner(Player player) {
        System.out.println("Game Finished!");
        System.out.println("Player: " + player.getId() + " won");
    }

    private void printPlayerInfo(Player player) {
        printMsg("Player: " + player.getId());
    }

    @Override
    public void printSelfBoard(Player player) {
        printMsg("Your board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Ships: " + player.getBoard().getShips());
        printMsg("Hit locations: " + player.getBoard().hitLocations());
        printMsg("Missed locations: " + player.getBoard().missLocations());
    }

    private void printOpponentBoard(Player player) {
        printMsg("\nOpponent board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Hit locations: " + player.getBoard().hitLocations());
        printMsg("Missed locations: " + player.getBoard().missLocations());
    }


    @Override
    public void printOpponentBoard(List<Player> allPlayers, Player currentPlayer) {
        for (Player player : allPlayers) {
            if (player.getId() != currentPlayer.getId()) {
                printOpponentBoard(player);
            }
        }
    }
}
