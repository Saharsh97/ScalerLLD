package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;

public class CornersWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        int size = board.getSize();
        Player player = move.getPlayer();
        char playerSymbol = player.getSymbol().getaChar();

        char symbolAtTopLeft = board.getBoard().get(0).get(0).getPlayer().getSymbol().getaChar();
        char symbolAtTopRight = board.getBoard().get(0).get(size-1).getPlayer().getSymbol().getaChar();
        char symbolAtBottomLeft = board.getBoard().get(size-1).get(0).getPlayer().getSymbol().getaChar();
        char symbolAtBottomRight = board.getBoard().get(size-1).get(size-1).getPlayer().getSymbol().getaChar();

        if(playerSymbol == symbolAtTopLeft &&
                symbolAtTopLeft == symbolAtTopRight &&
                symbolAtTopRight == symbolAtBottomLeft &&
                symbolAtBottomLeft == symbolAtBottomRight){
            return true;
        }
        return false;
    }
}
