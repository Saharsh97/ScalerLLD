package MachineCoding.TicTacToe.controllers;

import MachineCoding.TicTacToe.models.Game;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.models.exceptions.BotCountException;
import MachineCoding.TicTacToe.models.exceptions.DimensionException;
import MachineCoding.TicTacToe.models.exceptions.DuplicateSymbolException;
import MachineCoding.TicTacToe.models.exceptions.PlayerCountException;
import MachineCoding.TicTacToe.models.winningStrategies.WinningStrategy;

import java.util.List;

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
        int currentPlayerIndex = game.getCurrentPlayerIndex();
        Player currentPlayer = game.getPlayers().get(currentPlayerIndex);

        currentPlayer.makeMove(game.getBoard());
        // 3. update the game's list of Moves

        // check if there is a winner after this move.

        int nextPlayerIndex = (currentPlayerIndex + 1) % (game.getBoard().getSize()-1);
        game.setCurrentPlayerIndex(nextPlayerIndex);
    }

    public void checkWinner(Game game){

    }

    public void undo(Game game){

    }
}
