package com.demoProblems.tictactoe.winning_stratergies;

import com.demoProblems.tictactoe.Board;
import com.demoProblems.tictactoe.Move;

public class RowWin implements WinningStrategies{
    @Override
    public boolean checkWin(Board board, Move move){
        int row = move.getRow();
        var reqSymbol = move.getPlayer().getSymbol();
        int n = board.getN();
        for(int j=0;j<n;j++){
            if(board.getElement(row, j) != reqSymbol)
                return false;
        }
        return true;
    }
}
