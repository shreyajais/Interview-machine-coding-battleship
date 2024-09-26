
import exceptions.CoordinateOutOfBoundaryException;
import inpOut.Output.IOutputProvider;
import model.Coordinate;
import model.Player;
import model.PlayerChanceTarget;
import model.boundary.RectangularBoundary;
import strategy.IPlayerPickingStrategy;
import strategy.IWinnerStrategy;

import java.io.IOException;
import java.util.List;

public class GameLoop {

    private final List<Player> players;
    private final IWinnerStrategy winnerStrategy;
    private final IOutputProvider printer;
    private final IPlayerPickingStrategy nextPlayerStrategy;


    public GameLoop(List<Player> players, IWinnerStrategy winnerStrategy, IOutputProvider printer, IPlayerPickingStrategy nextPlayerStrategy) {
        this.players = players;
        this.winnerStrategy = winnerStrategy;
        this.printer = printer;
        this.nextPlayerStrategy = nextPlayerStrategy;
    }



    public void start() throws IOException {
        int currentPlayerIndex = nextPlayerStrategy.firstPlayer(this.players);
        printer.printMsg("Starting game!");
        while (true) {
            final Player currentPlayer = players.get(currentPlayerIndex);
            printer.printMsg("\n\nPlayer: " + currentPlayer.getId() + " chance:");
            final PlayerChanceTarget playerChanceTarget = currentPlayer.takeChance(this.players);

            try {
                playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());
            } catch (CoordinateOutOfBoundaryException exception) {
                printer.printMsg("Hit was out of bounds.");
            }

            printer.printSelfBoard(currentPlayer);
            printer.printOpponentBoard(players, currentPlayer);

            final Player winner = winnerStrategy.getWinner(players);
            if (winner != null) {
                printer.printWinner(winner);
                break;
            }
            currentPlayerIndex = nextPlayerStrategy.pickNextPlayer(currentPlayerIndex, this.players);
        }
    }


}
