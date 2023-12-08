package LLD3.TicTacToe.models;

import LLD3.TicTacToe.models.enums.BotDifficultyLevel;

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
        return super.makeMove(board);   // either keep this as it is, or have its own implementation of make move
    }
}
