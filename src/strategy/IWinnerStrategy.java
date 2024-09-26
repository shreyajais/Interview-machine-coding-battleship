package strategy;

import model.Player;

import java.util.List;

public interface IWinnerStrategy {
    Player getWinner(List<Player> players);
}
