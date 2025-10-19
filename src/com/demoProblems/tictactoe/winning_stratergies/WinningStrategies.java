package com.demoProblems.tictactoe.winning_stratergies;

import com.demoProblems.tictactoe.Board;
import com.demoProblems.tictactoe.Move;

public interface WinningStrategies {
    boolean checkWin(Board board, Move move);
}
