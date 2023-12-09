package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy extends MapWinningStrategy{

    public RowWinningStrategy(int dimension) {
        super(dimension);
    }

    public boolean checkWinner(Board board, Move move){
        Player player = move.getPlayer();
        int row = move.getCell().getRow();

        return checkAndUpdateMap(row, player, board);
    }
}
