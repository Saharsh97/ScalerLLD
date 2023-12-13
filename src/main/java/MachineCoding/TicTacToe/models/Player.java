package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.models.enums.CellState;
import MachineCoding.TicTacToe.models.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = PlayerType.HUMAN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Cell chosenCell = getValidChosenCell(board);

        chosenCell.setPlayer(this);
        chosenCell.setCellState(CellState.OCCUPIED);

        Move move = new Move(chosenCell, this);
        return move;
    }

    public Cell getValidChosenCell(Board board){
        while(true) {
            System.out.println("Player " + this.getName() + ", make your move");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Row: ");
            int row = scanner.nextInt();

            System.out.print("Enter Column: ");
            int column = scanner.nextInt();

            // 1. validate the row, column inputs, if it is within boundary. ask for inputs again.
            if(!isValidInput(row, column, board.getSize())){
                continue;
            }

            Cell chosenCell = board.getBoard().get(row).get(column);

            // 2. validate that this cell is empty. if not empty, ask for input again.
            if(isValidCellChosen(chosenCell)){
                return chosenCell;
            }
        }
    }

    private boolean isValidInput(int row, int column, int size){
        if(row >= 0 && row < size && column >= 0 && column < size){
            return true;
        }
        System.out.println("\nPlease provide the inputs within boundary! Please try again...\n");
        return false;
    }

    private boolean isValidCellChosen(Cell chosenCell){
        if (chosenCell.getCellState() != CellState.EMPTY) {
            System.out.println("\nThis cell is already occupied! Please try again...\n");
            return false;
        }
        return true;
    }
}
