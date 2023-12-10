package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;

public class ColumnWinningStrategy extends MapWinningStrategy{

    public ColumnWinningStrategy(int dimension) {
        super(dimension);
    }

    public boolean checkWinner(Board board, Move move){
        Player player = move.getPlayer();
        int column = move.getCell().getColumn();

        return checkAndUpdateMap(column, player, board);
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        int column = lastMove.getCell().getColumn();

        updateMapForUndo(column, player);
    }

}
