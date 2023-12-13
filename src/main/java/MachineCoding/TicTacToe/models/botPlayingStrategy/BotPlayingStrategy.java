package MachineCoding.TicTacToe.models.botPlayingStrategy;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;

public interface BotPlayingStrategy {
    Move makeBotMove(Board board);
}
