package strategy;
import model.Player;

import java.util.List;

public interface IPlayerPickingStrategy {
    int firstPlayer(List<Player> players);

    int pickNextPlayer(int currentPlayerIndex, List<Player> players);
}
