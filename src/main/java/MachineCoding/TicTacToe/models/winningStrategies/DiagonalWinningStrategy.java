package MachineCoding.TicTacToe.models.winningStrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalWinningStrategy extends MapWinningStrategy{

    public DiagonalWinningStrategy(List<Player> players){
        super(2, players);
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        if(row == column){
            updateCountMap(0, player);
        }

        if(row + column == board.getSize()-1){
            updateCountMap(1, player);
        }
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        if(row == column){
            if(checkCountMapForWinner(0, player, board.getSize())){
                return true;
            }
        }

        if(row + column == board.getSize() - 1){
            if(checkCountMapForWinner(1, player, board.getSize())){
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int row = cell.getRow();
        int column = cell.getColumn();

        if(row == column){
            handleMapUndo(0, player);
        }
        if(row + column == board.getSize() - 1){
            handleMapUndo(1, player);
        }

    }
}
