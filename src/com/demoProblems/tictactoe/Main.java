package com.demoProblems.tictactoe;

import com.demoProblems.tictactoe.winning_stratergies.ColWin;
import com.demoProblems.tictactoe.winning_stratergies.DiagonalWin;
import com.demoProblems.tictactoe.winning_stratergies.RowWin;
import com.demoProblems.tictactoe.winning_stratergies.WinningStrategies;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(Symbol.O, "p1");
        Player p2 = new Player(Symbol.X, "p2");
        List<Player>playerList = List.of(p1, p2);
        List<WinningStrategies>winningStrategies = List.of(new RowWin(), new ColWin(), new DiagonalWin());
        Game game = new Game(3, playerList, winningStrategies);
        game.startGame();
    }
}
