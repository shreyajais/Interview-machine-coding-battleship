package strategy;


import exceptions.InvalidInputException;
import model.Player;

import java.util.List;

public class RoundRobinPlayerPickingStrategy implements IPlayerPickingStrategy{
    @Override
    public int firstPlayer(List<Player> players) {
        if (players.size() == 0) {
            throw new InvalidInputException();
        }
        return 0;
    }

    @Override
    public int pickNextPlayer(int currentPlayerIndex, List<Player> players) {
        return (currentPlayerIndex + 1) % players.size();
    }
}
