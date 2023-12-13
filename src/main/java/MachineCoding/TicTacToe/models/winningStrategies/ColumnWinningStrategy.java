package MachineCoding.TicTacToe.models.winningStrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnWinningStrategy extends MapWinningStrategy{

    public ColumnWinningStrategy(int dimension, List<Player> players){
        super(dimension, players);
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int column = cell.getColumn();

        updateCountMap(column, player);
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int column = cell.getColumn();

        return checkCountMapForWinner(column, player, board.getSize());
    }

    @Override
    public void handleUndo(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int column = cell.getColumn();

        handleMapUndo(column, player);
    }
}



// X O X
//   O X
//   O
