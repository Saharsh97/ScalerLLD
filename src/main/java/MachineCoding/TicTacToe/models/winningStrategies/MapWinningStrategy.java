package MachineCoding.TicTacToe.models.winningStrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapWinningStrategy implements WinningStrategy{
    private int dimension;
    private Map<Integer, Map<Player, Integer>> countMap;

    public MapWinningStrategy(int dimension, List<Player> playerList){
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

    public void updateCountMap(int key, Player player){
        int existingCount = countMap.get(key).get(player);
        int newCount = existingCount + 1;
        countMap.get(key).put(player, newCount);
    }

    public boolean checkCountMapForWinner(int key, Player player, int boardSize){
        if(countMap.get(key).get(player) == boardSize){
            return true;
        }
        return false;
    }

    public void handleMapUndo(int key, Player player){
        int existingCount = countMap.get(key).get(player);
        int newCount = existingCount - 1;
        countMap.get(key).put(player, newCount);
    }
}
