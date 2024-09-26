package inpOut.Output;

import model.Player;

import java.util.List;

public interface IOutputProvider {
    void printMsg(String msg);
    void printWinner(Player player);
    void printSelfBoard(Player player);
    void printOpponentBoard(List<Player> allPlayers, Player currentPlayer);
}
