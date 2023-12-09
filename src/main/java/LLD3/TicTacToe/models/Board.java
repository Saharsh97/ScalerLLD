package LLD3.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.size = dimension;
        initialiseBoard();
    }

    private void initialiseBoard(){
        this.board = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List<Cell> rowOfCells = new ArrayList<>();
            for(int j = 0; j < size; j++){
                rowOfCells.add(new Cell(i, j));
            }
            this.board.add(rowOfCells);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void displayBoard(){
        System.out.println();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell cell = this.board.get(i).get(j);
                if(cell.getPlayer() == null){
                    System.out.print("   ");
                } else {
                    System.out.print(" " + cell.getPlayer().getSymbol().getaChar() + " ");
                }

                if(j < size-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            for(int j = 0; i < size-1 && j < size; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    public void updateBoard(int row, int column, Player player){
        this.board.get(row).get(column).setPlayer(player);
    }
}
