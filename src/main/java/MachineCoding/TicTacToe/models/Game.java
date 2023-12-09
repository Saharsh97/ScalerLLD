package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.models.enums.GameState;
import MachineCoding.TicTacToe.models.enums.PlayerType;
import MachineCoding.TicTacToe.models.exceptions.BotCountException;
import MachineCoding.TicTacToe.models.exceptions.DimensionException;
import MachineCoding.TicTacToe.models.exceptions.DuplicateSymbolException;
import MachineCoding.TicTacToe.models.exceptions.PlayerCountException;
import MachineCoding.TicTacToe.models.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private List<Move> moves;
    private int currentPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder){
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
        this.board = new Board(builder.dimension);

        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validateBotCount() throws BotCountException {
            // only 1 bot in the game
            int botCount = 0;
            for(Player p: players){
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new BotCountException("Bot count is more than 1. This is not allowed");
            }
        }

        private void validateBoardSize() throws DimensionException {
            // size of board is atleast 3.
            if(dimension < 3){
                throw new DimensionException("Board size should be atleast 3");
            }
        }

        private void validatePlayersCount() throws PlayerCountException {
            // no. of players is n-1
            if(players.size() != dimension-1){
                throw new PlayerCountException("Players count should be N-1");
            }
        }

        private void validateDuplicateSymbols() throws DuplicateSymbolException {
            // no duplicate symbols.
            HashSet<Character> symbols = new HashSet<>();
            for(Player p: players){
                if(symbols.contains(p.getSymbol().getaChar())){
                    throw new DuplicateSymbolException("Duplicate Player symbols found! Please try again with different symbols");
                }
                symbols.add(p.getSymbol().getaChar());
            }
        }

        private void validate() throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException {
            validateBotCount();
            validateBoardSize();
            validatePlayersCount();
            validateDuplicateSymbols();
        }

        public Game build() throws PlayerCountException, DuplicateSymbolException, BotCountException, DimensionException {
            validate();
            return new Game(this);
        }
    }
}
