package LLD3.TicTacToe.models.strategies.botPlayingStrategies;

import LLD3.TicTacToe.models.Board;
import LLD3.TicTacToe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
