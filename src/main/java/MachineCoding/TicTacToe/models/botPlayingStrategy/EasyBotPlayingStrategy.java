package MachineCoding.TicTacToe.models.botPlayingStrategy;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Bot;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    Bot bot;

    public EasyBotPlayingStrategy(Bot bot){
        this.bot = bot;
    }

    @Override
    public Move makeBotMove(Board board) {
        System.out.println("It's " + bot.getName() + "'s turn. Thinking...\n");
        List<Cell> emptyCellsList = getEmptyCells(board);

        Cell chosenCell = emptyCellsList.get(0);

        chosenCell.setPlayer(bot);
        chosenCell.setCellState(CellState.OCCUPIED);
        return new Move(chosenCell, bot);
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
