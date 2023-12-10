package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;

public class DiagonalWinningStrategy extends MapWinningStrategy{

    public DiagonalWinningStrategy(int dimension) {
        super(dimension);
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        Player player = move.getPlayer();
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        boolean updateLeftDiagonalResult = false;
        if(row == column){
            updateLeftDiagonalResult = checkAndUpdateMap(1, player, board);
        }

        boolean updateRightDiagonalResult = false;
        if (row + column == board.getSize()-1){
            updateRightDiagonalResult = checkAndUpdateMap(2, player, board);
        }

        if (updateLeftDiagonalResult || updateRightDiagonalResult){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        int row = lastMove.getCell().getRow();
        int column = lastMove.getCell().getColumn();

        if(row == column){
            updateMapForUndo(1, player);
        }
        if (row + column == board.getSize()-1){
            updateMapForUndo(2, player);
        }
    }


}
