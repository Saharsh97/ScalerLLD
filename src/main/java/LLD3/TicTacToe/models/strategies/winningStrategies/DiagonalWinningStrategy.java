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

        if(row == column){
            return checkAndUpdateMap(1, player, board);
        }else if (row + column == board.getSize()-1){
            return checkAndUpdateMap(2, player, board);
        }
        return false;
    }
}
