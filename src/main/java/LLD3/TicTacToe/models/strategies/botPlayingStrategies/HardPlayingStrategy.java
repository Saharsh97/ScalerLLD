package LLD3.TicTacToe.models.strategies.botPlayingStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Cell;
import LLD3.TicTacToe.models.Move;
import LLD3.TicTacToe.models.Player;
import LLD3.TicTacToe.models.enums.CellState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HardPlayingStrategy implements BotPlayingStrategy{

    // this could be using 3rd Party libraries/softwares, or create AI/ML Model in TicTacToe
    // what can we use for that? Adapters
    Player bot;

    public HardPlayingStrategy(Player botPlayer){
        this.bot = botPlayer;
    }
    @Override
    public Move makeMove(Board board) {
        System.out.println("It's " + bot.getName() + "'s turn. Thinking hard...\n");
        List<Cell> emptyCellsList = getEmptyCells(board);

        Random random = new Random();
        int randomIndex = random.nextInt(emptyCellsList.size());
        Cell randomlyChosenCell = emptyCellsList.get(randomIndex);

        return new Move(randomlyChosenCell, bot);
    }

    private List<Cell> getEmptyCells(Board board){
        int sizeOfBoard = board.getSize();
        List<Cell> emptyCells = new ArrayList<>();
        for(int i = 0; i < sizeOfBoard; i++){
            for(int j = 0; j < sizeOfBoard; j++){
                Cell currentCell = board.getBoard().get(i).get(j);
                if(currentCell.getCellState() == CellState.EMPTY){
                    emptyCells.add(currentCell);
                }
            }
        }
        return emptyCells;
    }
}
