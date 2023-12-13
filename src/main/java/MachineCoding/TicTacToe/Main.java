package MachineCoding.TicTacToe;

import MachineCoding.TicTacToe.controllers.GameController;
import MachineCoding.TicTacToe.models.Bot;
import MachineCoding.TicTacToe.models.Game;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.Symbol;
import MachineCoding.TicTacToe.models.enums.BotDifficultyLevel;
import MachineCoding.TicTacToe.models.enums.GameState;
import MachineCoding.TicTacToe.models.exceptions.BotCountException;
import MachineCoding.TicTacToe.models.exceptions.DimensionException;
import MachineCoding.TicTacToe.models.exceptions.DuplicateSymbolException;
import MachineCoding.TicTacToe.models.exceptions.PlayerCountException;
import MachineCoding.TicTacToe.models.winningStrategies.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PlayerCountException, DuplicateSymbolException, BotCountException, DimensionException {
        GameController gameController = new GameController();

        int dimension = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Saharsh", new Symbol('X')));
        players.add(new Bot(2, "SastaBot", new Symbol('B'), BotDifficultyLevel.HARD));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(dimension, players));
        winningStrategies.add(new ColumnWinningStrategy(dimension, players));
        winningStrategies.add(new DiagonalWinningStrategy(players));
        winningStrategies.add(new CornersWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);
        System.out.println("game has been started");
        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        gameController.displayBoard(game);
        if(game.getGameState() == GameState.COMPLETED){
            System.out.println("Game is completed. Winner is " + game.getWinner().getName());
        }
        if(game.getGameState() == GameState.DRAW){
            System.out.println("Game is a Draw");
        }
    }
}
