package strategy;

import exceptions.InvalidInputException;
import inpOut.Input.IInputProvider;
import inpOut.Input.PlayerInput;
import model.Coordinate;
import model.Player;
import model.PlayerChanceTarget;

import java.io.IOException;
import java.util.List;

public class LocalChanceGeneration implements IChanceGenerationStrategy{
    private final IInputProvider inputProvider;

    public LocalChanceGeneration(IInputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) throws IOException { // correct this method
        final PlayerInput playerInput = inputProvider.takeInput();
        Player targetPlayer = null;
        for (Player player: opponents) {
            if (player.getId() == playerInput.getPlayerNum()) {
                targetPlayer = player;
            }
        }

        if (targetPlayer == null) {
            throw new InvalidInputException();
        }
        return new PlayerChanceTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
    }
}
