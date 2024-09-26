package strategy;

import model.Player;

import java.util.ArrayList;
import java.util.List;

public class DefaultWinnerStrategy implements IWinnerStrategy{
    @Override
    public Player getWinner(List<Player> players) {
        final List<Player> alivePlayers = new ArrayList<>();
        for (Player player : players) {
            if (!player.areAllShipsKilled()) {
                alivePlayers.add(player);
            }
        }
        if (alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }
        return null;
    }
}
