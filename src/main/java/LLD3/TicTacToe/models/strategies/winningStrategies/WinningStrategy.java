package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.Map;


// write map implementation for each type of class. row, column, diagonal, corners.
// they are common for row, column, diagonal. but not for corners.
// I can move common code of row, column, diagonal to a normal class MapWinningStrategy. (no hierarchy for now)
// MapWinningStrategy should be a sub-class of WinningStrategy? Yes (hierarchy)
// however I want the implementing classes of MapWinningStrategy to write the actual implementation (abstract)
// Draw this on notes first
public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board, Move lastMove);
}
