package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.models.enums.BotDifficultyLevel;
import MachineCoding.TicTacToe.models.enums.PlayerType;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;

    public Bot(int id, String name, Symbol symbol) {
        super(id, name, symbol);
        this.setPlayerType(PlayerType.BOT);
    }

    @Override
    public void makeMove(Board board){
        // do some bot thing.
    }
}
