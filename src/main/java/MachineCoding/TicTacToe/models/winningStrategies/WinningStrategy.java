package MachineCoding.TicTacToe.models.winningStrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;

public interface WinningStrategy {
    void updateCount(Board board, Move lastMove);
    boolean checkWinner(Board board, Move lastMove);
    void handleUndo(Board board, Move lastMove);
}
