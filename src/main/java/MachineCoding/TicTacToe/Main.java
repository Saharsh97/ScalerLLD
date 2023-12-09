package MachineCoding.TicTacToe;

import MachineCoding.TicTacToe.controllers.GameController;
import MachineCoding.TicTacToe.models.Game;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.Symbol;
import MachineCoding.TicTacToe.models.enums.GameState;
import MachineCoding.TicTacToe.models.winningStrategies.ColumnWinningStrategy;
import MachineCoding.TicTacToe.models.winningStrategies.RowWinningStrategy;
import MachineCoding.TicTacToe.models.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        int dimension = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Saharsh", new Symbol('X')));
        players.add(new Player(2, "Rajat", new Symbol('X')));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());

        Game game = gameController.startGame(3, players, winningStrategies);

        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.displayBoard(game);
            gameController.makeMove(game);

            if(game.getGameState() == GameState.COMPLETED){
                System.out.println("Game is completed. Winner is " + game.getWinner().getName());
                break;
            }
            if(game.getGameState() == GameState.DRAW){
                System.out.println("Game is a Draw");
                break;
            }
        }
    }
}
