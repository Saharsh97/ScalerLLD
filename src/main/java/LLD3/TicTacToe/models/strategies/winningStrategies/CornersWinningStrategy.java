package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.*;
import LLD3.TicTacToe.models.enums.CellState;

import java.util.List;

public class CornersWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        int size = board.getSize();
        Player player = move.getPlayer();
        char playerSymbol = player.getSymbol().getaChar();

        List<List<Cell>> actualBoard = board.getBoard();
        Cell topLeftCell = actualBoard.get(0).get(0);
        Cell topRightCell = actualBoard.get(0).get(size-1);
        Cell bottomLeftCell = actualBoard.get(size-1).get(0);
        Cell bottomRightCell = actualBoard.get(size-1).get(size-1);

        if(topLeftCell.getCellState()==CellState.EMPTY || topRightCell.getCellState()==CellState.EMPTY  || bottomLeftCell.getCellState()==CellState.EMPTY  || bottomRightCell.getCellState()==CellState.EMPTY ){
            return false;
        }

        char symbolAtTopLeft = topLeftCell.getPlayer().getSymbol().getaChar();
        char symbolAtTopRight = topRightCell.getPlayer().getSymbol().getaChar();
        char symbolAtBottomLeft = bottomLeftCell.getPlayer().getSymbol().getaChar();
        char symbolAtBottomRight = bottomRightCell.getPlayer().getSymbol().getaChar();

        if(playerSymbol == symbolAtTopLeft &&
                symbolAtTopLeft == symbolAtTopRight &&
                symbolAtTopRight == symbolAtBottomLeft &&
                symbolAtBottomLeft == symbolAtBottomRight){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}
