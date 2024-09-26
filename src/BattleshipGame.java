import exceptions.AlreadyOccupiedException;
import inpOut.Input.IInputProvider;
import inpOut.Input.ItemInput;
import inpOut.Input.SysInputProvider;
import inpOut.Output.SysOutputProvider;
import model.Board;
import model.BoardItem;
import model.Coordinate;
import model.Player;
import model.boundary.IBoundary;
import model.boundary.RectangularBoundary;
import strategy.DefaultWinnerStrategy;
import strategy.LocalChanceGeneration;
import strategy.RoundRobinPlayerPickingStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleshipGame {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello BattleshipGame");
        final IInputProvider inputProvider = new SysInputProvider();
        final int battleFieldSize = inputProvider.takeBoardSizeInput();
        String[][] battleFieldView = new String[battleFieldSize][battleFieldSize];
        final int numberOfShips = inputProvider.takeNumberOfItemInput();
        ArrayList<Player> players = initGame(battleFieldSize, numberOfShips, inputProvider, battleFieldView);
        GameLoop gameLoop = new GameLoop(
                players,
                new DefaultWinnerStrategy(),
                new SysOutputProvider(),
                new RoundRobinPlayerPickingStrategy());
        gameLoop.start();
    }

    public static ArrayList<Player> initGame(int battleFieldSize, int numberOfShips, IInputProvider inputProvider, String[][] battleFieldView) throws IOException {
        for(int i =0; i<battleFieldSize; i++){
            for(int j = 0; j<battleFieldSize; j++) {
                battleFieldView[i][j] = ";";
            }
        }
        final IBoundary boardBoundaryPlayerA = new RectangularBoundary(new Coordinate(0, battleFieldSize), new Coordinate(battleFieldSize/2-1, 0));
        final IBoundary boardBoundaryPlayerB = new RectangularBoundary(new Coordinate(battleFieldSize/2, battleFieldSize), new Coordinate(0, battleFieldSize-1));
        ArrayList<BoardItem> shipsA = new ArrayList<>();
        ArrayList<BoardItem> shipsB = new ArrayList<>();
        for(int i =0; i<numberOfShips; i++){
            ItemInput itemInput = inputProvider.takeItemInput();
            addShip(i, itemInput.getSize(), itemInput.getXA(),itemInput.getXB(),itemInput.getYA(), itemInput.getYB(), shipsA, shipsB, battleFieldView);
        }
        Board boardA = new Board(shipsA, boardBoundaryPlayerA);
        Player playerA =  new Player(boardA, 1, new LocalChanceGeneration(inputProvider));
        Board boardB = new Board(shipsB, boardBoundaryPlayerB);
        Player playerB =  new Player(boardB, 2, new LocalChanceGeneration(inputProvider));
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);
        return players;
    }

    private static void addShip(int i, int size, Integer xa, Integer xb, Integer ya, Integer yb, ArrayList<BoardItem> shipsA, ArrayList<BoardItem> shipsB, String[][] battleFieldView) throws AlreadyOccupiedException{
        BoardItem shipA = new BoardItem(i+"", getCoordinate(size, xa, ya));
        BoardItem shipB = new BoardItem(i+"", getCoordinate(size, xa, ya));
        fillBattleField(shipA, shipB, battleFieldView);
        shipsA.add(shipA);
        shipsB.add(shipB);
    }

    private static void fillBattleField(BoardItem shipA, BoardItem shipB, String[][] battleFieldView){
        List<Coordinate> allCoordinatesA = shipA.getBoundary().allCoordinates();
        for(Coordinate coordinate: allCoordinatesA){
            if(battleFieldView[coordinate.getX()][coordinate.getY()] != null) throw new AlreadyOccupiedException();
            battleFieldView[coordinate.getX()][coordinate.getY()] = shipA.getName();
        }
        List<Coordinate> allCoordinatesB = shipA.getBoundary().allCoordinates();
        for(Coordinate coordinate: allCoordinatesA){
            if(battleFieldView[coordinate.getX()][coordinate.getY()] != null) throw new AlreadyOccupiedException();
            battleFieldView[coordinate.getX()][coordinate.getY()] = shipB.getName();
        }
    }

    private static void viewBattleField( String[][] battleFieldView){
        for(int i =0; i< battleFieldView.length; i++){
            for(int j =0; j< battleFieldView[0].length; j++){
                System.out.print(battleFieldView[i][j] + "|");
            }
            System.out.println();
        }
    }


    public static RectangularBoundary getCoordinate(int x, int y, int size){
        Coordinate X =  new Coordinate(x-size/2, y+size/2);
        Coordinate Y = new Coordinate(x+size/2, y-size/2);
        return new RectangularBoundary(X, Y);
    }


}
