package LLD3.TicTacToe.models.strategies.winningStrategies;

import LLD3.TicTacToe.models.Board;
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
        int newCount = existingCount + 1;
        if(newCount == board.getSize()){
            return true;
        }
        countMap.get(type).put(player, newCount);
        return false;
    }

    void updateMapForUndo(int type, Player player){
        int existingSymbolCountForThisPlayer = countMap.get(type).get(player);
        countMap.get(type).put(player, existingSymbolCountForThisPlayer-1);
    }
}
