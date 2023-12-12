package MachineCoding.TicTacToe.models.winningStrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private int dimension;
    private Map<Integer, Map<Player, Integer>> countMap;

    public RowWinningStrategy(int dimension, List<Player> playerList){
        this.dimension = dimension;
        this.countMap = new HashMap<>();
        initialiseCountMap(playerList);
    }

    private void initialiseCountMap(List<Player> playerList){
        for(int i = 0; i < dimension; i++){
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

        int existingCount = countMap.get(row).get(player);
        int newCount = existingCount + 1;
        countMap.get(row).put(player, newCount);
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();

        if(countMap.get(row).get(player) == dimension){
            return true;
        }
        return false;
    }
}
