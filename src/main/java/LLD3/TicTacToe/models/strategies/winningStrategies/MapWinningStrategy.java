package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class MapWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Player, Integer>> countMap;

    public MapWinningStrategy(int dimension){
        this.countMap = new HashMap<>();
        initialiseCountMap(dimension);
    }

    private void initialiseCountMap(int dimension){
        for(int i = 0; i < dimension; i++){
            countMap.put(i, new HashMap<>());
        }
    }

    boolean checkAndUpdateMap(int type, Player player, Board board){
        int existingCount = countMap.get(type).getOrDefault(player, 0);
        existingCount++;
        if(existingCount == board.getSize()){
            return true;
        }
        countMap.get(type).put(player, existingCount);
        return false;
    }

    public abstract boolean checkWinner(Board board, Move move);
}
