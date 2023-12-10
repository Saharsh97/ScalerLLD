package LLD3.TicTacToe.controllers;

// after notes 1.

import LLD3.TicTacToe.exceptions.BotCountException;
import LLD3.TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import LLD3.TicTacToe.exceptions.DuplicateSymbolsException;
import LLD3.TicTacToe.models.Game;
import LLD3.TicTacToe.models.Player;
import LLD3.TicTacToe.models.enums.GameState;
import LLD3.TicTacToe.models.strategies.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) throws BotCountException, PlayerCountDimensionMismatchException, DuplicateSymbolsException {
        // create the game.
        // to start the game, we will need some attributes from the client.
        // go over the Game class, and check if each of the attributes are needed from the client one by one.
        // board, no. players, yes. winningStrategies, yes. board.size, yes

        // will I straight away create the game, or do something else? need Validations.
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerList)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove(game);
    }

    // who will write the core logic of this function? Board class
    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }


    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void checkForUndo(Game game){
        boolean undoHappened = game.checkForUndo();
        if(undoHappened) {
            displayBoard(game);
        }
    }
}
