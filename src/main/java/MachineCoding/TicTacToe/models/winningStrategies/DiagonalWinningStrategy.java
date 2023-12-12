package MachineCoding.TicTacToe.models.winningStrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    private int dimension;
    private Map<Integer, Map<Player, Integer>> countMap;

    public DiagonalWinningStrategy(List<Player> playerList){
        this.dimension = 2;
        this.countMap = new HashMap<>();
        initialiseCountMap(playerList);
    }

    private void initialiseCountMap(List<Player> playerList){
        for(int i = 0; i < dimension; i++){ // i = 1
            countMap.put(i, new HashMap<>());
            for(Player player: playerList){
                countMap.get(i).put(player, 0);
            }
        }
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        // left diagonal is type 0
        if(row == column){
            int existingCount = countMap.get(0).get(player);
            int newCount = existingCount + 1;
            countMap.get(0).put(player, newCount);
        }

        // right diagonal is type 1
        if(row + column == board.getSize()-1){
            int existingCount = countMap.get(1).get(player);
            int newCount = existingCount + 1;
            countMap.get(1).put(player, newCount);
        }
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        boolean leftDiagonalAnswer = false;
        if(row == column){
            if(countMap.get(0).get(player) == board.getSize()){
                leftDiagonalAnswer = true;
            }
        }

        boolean rightDiagonalAnswer = false;
        if(row + column == board.getSize() - 1){
            if(countMap.get(1).get(player) == board.getSize()){
                rightDiagonalAnswer = true;
            }
        }

        if(leftDiagonalAnswer || rightDiagonalAnswer){
            return true;
        }
        return false;
    }
}
