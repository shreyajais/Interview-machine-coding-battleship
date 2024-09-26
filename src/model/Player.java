package model;

import strategy.IChanceGenerationStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Board board;
    private final int id;
    private final IChanceGenerationStrategy chanceGenerationStrategy;

    public Player(Board board, int id, IChanceGenerationStrategy chanceGenerationStrategy) {
        this.board = board;
        this.id = id;
        this.chanceGenerationStrategy = chanceGenerationStrategy;
    }

    public int getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public PlayerChanceTarget takeChance(List<Player> allPlayers) throws IOException {
        List<Player> opponents = new ArrayList<>();
        for (Player player: allPlayers) {
            if (player.getId() != getId()) {
                opponents.add(player);
            }
        }
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }

    public void takeHit(final Coordinate coordinate) { // check for null
        board.takeHit(coordinate);
    }
}
