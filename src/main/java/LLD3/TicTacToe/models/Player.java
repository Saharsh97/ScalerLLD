package LLD3.TicTacToe.models;

import LLD3.TicTacToe.models.enums.CellState;
import LLD3.TicTacToe.models.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Cell chosenCell = getValidCellChoiceFromPlayer(board);

        chosenCell.setPlayer(this);
        chosenCell.setCellState(CellState.OCCUPIED);

        Move move = new Move();
        move.setPlayer(this);
        move.setCell(chosenCell);
        return move;
    }

    private Cell getValidCellChoiceFromPlayer(Board board){
        while(true) {
            System.out.println("Player: " + this.getName() + ", Please enter your input");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Row : ");
            int row = scanner.nextInt();
            System.out.print("Enter Column : ");
            int column = scanner.nextInt();

            if(!isValidInput(row, column, board.getSize())){
                continue;
            }
            Cell chosenCell = board.getBoard().get(row).get(column);
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
