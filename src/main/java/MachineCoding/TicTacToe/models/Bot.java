package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.models.botPlayingStrategy.BotPlayingStrategy;
import MachineCoding.TicTacToe.models.enums.BotDifficultyLevel;
import MachineCoding.TicTacToe.models.enums.PlayerType;
import MachineCoding.TicTacToe.models.factories.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultyLevel difficultyLevel;

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol);
        this.difficultyLevel = difficultyLevel;
        this.setPlayerType(PlayerType.BOT);
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        BotPlayingStrategy playingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficultyLevel(this);
        return playingStrategy.makeBotMove(board);
    }
}
