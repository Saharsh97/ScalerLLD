package MachineCoding.TicTacToe.models.factories;

import MachineCoding.TicTacToe.models.Bot;
import MachineCoding.TicTacToe.models.botPlayingStrategy.BotPlayingStrategy;
import MachineCoding.TicTacToe.models.botPlayingStrategy.EasyBotPlayingStrategy;
import MachineCoding.TicTacToe.models.botPlayingStrategy.HardBotPlayingStrategy;
import MachineCoding.TicTacToe.models.botPlayingStrategy.MediumBotPlayingStrategy;
import MachineCoding.TicTacToe.models.enums.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(Bot bot){
        BotDifficultyLevel difficultyLevel = bot.getDifficultyLevel();
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy(bot);
        } else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy(bot);
        } else if(difficultyLevel == BotDifficultyLevel.HARD){
            return new HardBotPlayingStrategy(bot);
        }
        return null;
    }
}
