package com.demoProblems.tictactoe.winning_stratergies;

import com.demoProblems.tictactoe.Board;
import com.demoProblems.tictactoe.Move;

public class ColWin implements WinningStrategies{
    @Override
    public boolean checkWin(Board board, Move move){
        int col = move.getCol();
        var reqSymbol = move.getPlayer().getSymbol();
        int n = board.getN();
        for(int i=0;i<n;i++){
            if(board.getElement(i, col) != reqSymbol)
                return false;
        }
        return true;
    }
}
