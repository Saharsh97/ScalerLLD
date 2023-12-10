package LLD3.TicTacToe;

import LLD3.TicTacToe.controllers.GameController;
import LLD3.TicTacToe.exceptions.BotCountException;
import LLD3.TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import LLD3.TicTacToe.exceptions.DuplicateSymbolsException;
import LLD3.TicTacToe.models.Bot;
import LLD3.TicTacToe.models.Game;
import LLD3.TicTacToe.models.Player;
import LLD3.TicTacToe.models.Symbol;
import LLD3.TicTacToe.models.enums.BotDifficultyLevel;
import LLD3.TicTacToe.models.enums.GameState;
import LLD3.TicTacToe.models.enums.PlayerType;
import LLD3.TicTacToe.models.strategies.winningStrategies.*;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws BotCountException, PlayerCountDimensionMismatchException, DuplicateSymbolsException {
        GameController gameController = new GameController();

        List<Player> players = createPlayers();
        int dimension = players.size()+1;
        List<WinningStrategy> winningStrategies = getWinningStrategies(dimension);

        Game game = gameController.startGame(dimension, players, winningStrategies);
        System.out.println("Game is starting");

        gameController.displayBoard(game);
        while(gameController.checkState(game) == GameState.IN_PROGRESS){
                gameController.makeMove(game);
                gameController.displayBoard(game);
                gameController.checkForUndo(game);
        }

        if(gameController.checkState(game) == GameState.SUCCESS){
            System.out.println("\nWinner is " + gameController.getWinner(game).getName() + "!!");
        } else if (gameController.checkState(game) == GameState.DRAW){
            System.out.println("\nGame is a Draw!");
        }
    }

    private static List<WinningStrategy> getWinningStrategies(int dimension){
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy(dimension));
        winningStrategies.add(new ColumnWinningStrategy(dimension));
        winningStrategies.add(new DiagonalWinningStrategy(dimension));
        winningStrategies.add(new CornersWinningStrategy());
        return winningStrategies;
    }

    private static List<Player> createPlayers(){
        Player p1 = new Player();
        p1.setName("Rajat");
        p1.setId(1);
        p1.setPlayerType(PlayerType.HUMAN);
        p1.setSymbol(new Symbol('X'));

//        Player p2 = new Player();
//        p2.setName("Shiva");
//        p2.setId(2);
//        p2.setPlayerType(PlayerType.HUMAN);
//        p2.setSymbol(new Symbol('O'));

        Bot bot = new Bot();
        bot.setName("SastaBot");
        bot.setId(3);
        bot.setPlayerType(PlayerType.BOT);
        bot.setSymbol(new Symbol('B'));
        bot.setBotDifficultyLevel(BotDifficultyLevel.EASY);

        List<Player> players = new ArrayList<>();
        players.add(p1);
//        players.add(p2);
        players.add(bot);
        return players;
    }
}
