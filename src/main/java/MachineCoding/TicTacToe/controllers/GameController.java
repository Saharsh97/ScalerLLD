package MachineCoding.TicTacToe.controllers;

import MachineCoding.TicTacToe.models.Game;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return null;
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public void makeMove(Game game){

    }

    public void checkWinner(Game game){

    }

    public void undo(Game game){

    }
}
