package LLD3.TicTacToe.models.factories;

import LLD3.TicTacToe.models.Bot;
import LLD3.TicTacToe.models.Player;
import LLD3.TicTacToe.models.enums.BotDifficultyLevel;
import LLD3.TicTacToe.models.strategies.botPlayingStrategies.BotPlayingStrategy;
import LLD3.TicTacToe.models.strategies.botPlayingStrategies.EasyPlayingStrategy;
import LLD3.TicTacToe.models.strategies.botPlayingStrategies.HardPlayingStrategy;
import LLD3.TicTacToe.models.strategies.botPlayingStrategies.MediumPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByBotLevel(Bot bot){
        BotDifficultyLevel difficultyLevel = bot.getBotDifficultyLevel();
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyPlayingStrategy(bot);
        } else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumPlayingStrategy(bot);
        } else if(difficultyLevel == BotDifficultyLevel.HARD){
            return new HardPlayingStrategy(bot);
        }
        return null;
    }
}
