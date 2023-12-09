package LLD3.TicTacToe;

import LLD3.TicTacToe.controllers.GameController;
import LLD3.TicTacToe.exceptions.BotCountException;
import LLD3.TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import LLD3.TicTacToe.exceptions.DuplicateSymbolsException;
import LLD3.TicTacToe.models.Game;
import LLD3.TicTacToe.models.Player;
import LLD3.TicTacToe.models.Symbol;
import LLD3.TicTacToe.models.enums.GameState;
import LLD3.TicTacToe.models.enums.PlayerType;
import LLD3.TicTacToe.models.strategies.winningStrategies.ColumnWinningStrategy;
import LLD3.TicTacToe.models.strategies.winningStrategies.RowWinningStrategy;
import LLD3.TicTacToe.models.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws BotCountException, PlayerCountDimensionMismatchException, DuplicateSymbolsException {
        // how will we make our game up and running?
        // to start the game what should we be doing?
        // create game.
        // but client talks to the gameController for everything!

        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = createPlayers();
        List<WinningStrategy> winningStrategies = getWinningStrategies(dimension);

        Game game = gameController.startGame(3, players, winningStrategies);
        System.out.println("Game is starting");
        // after discussion on 2. Game object and single controller.

        // can you give me the state of this particular game.
        gameController.displayBoard(game);
        while(gameController.checkState(game) == GameState.IN_PROGRESS){
            // first, display the board
            // then play the move
            gameController.makeMove(game);
            gameController.displayBoard(game);

            // check state, if winner found, or draw happened.

            if(gameController.checkState(game) == GameState.SUCCESS){
                System.out.println("\nWinner is " + gameController.getWinner(game).getName() + "!!");
                break;
            } else if (gameController.checkState(game) == GameState.DRAW){
                System.out.println("\nGame is a Draw!");
                break;
            }
        }
    }

    private static List<WinningStrategy> getWinningStrategies(int dimension){
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(dimension));
        winningStrategies.add(new ColumnWinningStrategy(dimension));
        return winningStrategies;
    }

    private static List<Player> createPlayers(){
        Player p1 = new Player();
        p1.setName("Rajat");
        p1.setId(1);
        p1.setPlayerType(PlayerType.HUMAN);
        p1.setSymbol(new Symbol('X'));

        Player p2 = new Player();
        p2.setName("Shiva");
        p2.setId(2);
        p2.setPlayerType(PlayerType.HUMAN);
        p2.setSymbol(new Symbol('O'));

        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        return players;
    }
}
