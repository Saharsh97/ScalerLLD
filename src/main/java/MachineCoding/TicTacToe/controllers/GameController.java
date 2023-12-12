package MachineCoding.TicTacToe.controllers;

import MachineCoding.TicTacToe.models.Game;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.exceptions.BotCountException;
import MachineCoding.TicTacToe.models.exceptions.DimensionException;
import MachineCoding.TicTacToe.models.exceptions.DuplicateSymbolException;
import MachineCoding.TicTacToe.models.exceptions.PlayerCountException;
import MachineCoding.TicTacToe.models.winningStrategies.WinningStrategy;

import java.util.List;

// controller's responsibility is to just forward the request to the appropriate logic -> model, services
public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayerCountException, DuplicateSymbolException, BotCountException, DimensionException {
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(players).
                setWinningStrategies(winningStrategies).
                build();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void checkWinner(Game game){

    }

    public void undo(Game game){

    }
}
