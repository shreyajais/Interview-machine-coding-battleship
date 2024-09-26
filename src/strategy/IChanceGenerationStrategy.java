package strategy;
import model.Player;
import model.PlayerChanceTarget;

import java.io.IOException;
import java.util.List;

public interface IChanceGenerationStrategy {
    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) throws IOException;
}
