package LLD3.TicTacToe.models;

import LLD3.TicTacToe.models.enums.BotDifficultyLevel;
import LLD3.TicTacToe.models.factories.BotPlayingStrategyFactory;
import LLD3.TicTacToe.models.strategies.botPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        BotPlayingStrategy playingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByBotLevel(this);
        return playingStrategy.makeMove(board);
    }
}
