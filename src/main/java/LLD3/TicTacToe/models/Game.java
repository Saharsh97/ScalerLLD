package LLD3.TicTacToe.models;

import LLD3.TicTacToe.exceptions.BotCountException;
import LLD3.TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import LLD3.TicTacToe.exceptions.DuplicateSymbolsException;
import LLD3.TicTacToe.models.enums.GameState;
import LLD3.TicTacToe.models.enums.PlayerType;
import LLD3.TicTacToe.models.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 4. convert from normal class to builder.
// what did we do? create an inner static class.


public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int currentPlayerIndex;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;

    // always make constructors for all the entities! And assign values for all attributes. otherwise NPE
    // access specifier for constructor?
    private Game(Builder builder){
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayerIndex = 0;
        this.winner = null;
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

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void makeMove(Game game){
        // figure out whose turn is it?
        int currentPlayerIndex = game.getCurrentPlayerIndex();
        Player currentPlayer = game.getPlayers().get(currentPlayerIndex);

        // Ask that player, which cell they should place their symbol
        Move move = currentPlayer.makeMove(game.getBoard());
        this.moves.add(move);

        //TODO check winner here!

        game.setCurrentPlayerIndex((currentPlayerIndex + 1) % (game.getBoard().getSize()-1));
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        // what attributes are going to be here?
        // all of them? no. Only the ones that will be used for game creation.
        // attributes that we need to take from client.

        // I need a dimension from the client
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        // do I need to have both getters and setters in builder? only setters
        // what used to be the return type of setters? builder
        // what else we need to actually use this builder? a build method to create the game.

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

        // if I want to add multivalued attributes, like a list, we can add them individually.
        // this is also a common practice.
        public Builder addPlayer(Player player){
            if(players == null){
                players = new ArrayList<>();
            }
            players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            if(winningStrategies == null){
                winningStrategies = new ArrayList<>();
            }
            winningStrategies.add(winningStrategy);
            return this;
        }

        private void validate() throws BotCountException, PlayerCountDimensionMismatchException, DuplicateSymbolsException {
            // 1. validate single bot player.
            // 2. number of players = dimension - 1
            // 3. different symbol for each player
            validateBotCount();
            validatePlayerCount();
            validatePlayerSymbols();



            // when you look at the validate function, what comes to your mind?
            // isn't this doing too many things? SRP
            // create different functions
        }

        private void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player p: players){
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                // create own set of exceptions in a package
                throw new BotCountException("Bots cannot be more than 1");
            }
        }

        private void validatePlayerCount() throws PlayerCountDimensionMismatchException {
            if(players.size() != dimension - 1){
                throw new PlayerCountDimensionMismatchException("Players count are not Dimension-1");
            }
        }

        private void validatePlayerSymbols() throws DuplicateSymbolsException {
            HashSet<Character> symbolsSet = new HashSet<>();
            for(Player p: players){
                if(symbolsSet.contains(p.getSymbol().getaChar())){
                    throw new DuplicateSymbolsException("Multiple players have the same symbols. Please retry with different symbols again");
                }
                symbolsSet.add(p.getSymbol().getaChar());
            }
        }

        public Game build() throws BotCountException, PlayerCountDimensionMismatchException, DuplicateSymbolsException {
            // 8. validate
            validate(); // 10. this throws exception? chef error and waiter.
            return new Game(this);
        }
    }
}
