package com.demoProblems.tictactoe.winning_stratergies;

import com.demoProblems.tictactoe.Board;
import com.demoProblems.tictactoe.Move;

public class DiagonalWin implements WinningStrategies{
    @Override
    public boolean checkWin(Board board, Move move){
        var reqSymbol = move.getPlayer().getSymbol();
        int n = board.getN();
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(board.getElement(i, i) != reqSymbol){
                flag = false;
                break;
            }
        }
        if(flag)return true;
        flag = true;
        for(int i=0;i<n;i++){
            if(board.getElement(i, n-i-1) != reqSymbol){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
