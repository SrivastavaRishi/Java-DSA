package com.demoProblems.tictactoe;

public class Board {
    private final int n;
    private final Symbol [][]grid;

    public Board(int n){
        this.n = n;
        grid = new Symbol[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                grid[i][j] = Symbol.EMPTY;
        }
    }

    private boolean isValidMove(int row, int col){
        return row >= 0 && row < n && col >=0 && col < n && grid[row][col] == Symbol.EMPTY;
    }

    public void displayBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String ch = ".";
                if(grid[i][j] != Symbol.EMPTY)
                    ch = grid[i][j].toString();
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public boolean placeMove(Move move){
        int row = move.getRow();
        int col = move.getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if(isValidMove(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public int getN() {
        return n;
    }

    public Symbol getElement(int row, int col){
        return grid[row][col];
    }
}
