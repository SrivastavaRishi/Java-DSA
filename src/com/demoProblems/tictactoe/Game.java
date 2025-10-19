package com.demoProblems.tictactoe;

import com.demoProblems.tictactoe.winning_stratergies.WinningStrategies;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> playerList;
    private final List<WinningStrategies>winningStrategies;
    private int currentPlayerIndex;
    private Player winner;

    public Game(int sizeOfBoard, List<Player>playerList, List<WinningStrategies>winningStrategies){
        this.board = new Board(sizeOfBoard);
        this.playerList = playerList;
        this.winningStrategies = winningStrategies;
        currentPlayerIndex = 0;
        winner = null;
    }

    public void startGame(){
        int n = playerList.size();
        Scanner sc = new Scanner(System.in);
        while(winner == null){
            board.displayBoard();
            var player = playerList.get(currentPlayerIndex);
            System.out.printf("%s Please Enter row and col", player.getName());
            int row = sc.nextInt();
            int col = sc.nextInt();
            Move move = new Move(row, col, player);
            boolean validMove = board.placeMove(move);
            if(validMove){
                var win = checkWin(board, move);
                if(win) {
                    winner = player;
                }
                else currentPlayerIndex = (currentPlayerIndex + 1) % n;
            } else {
                System.out.println("Invalid move, please try again !!!");
            }
        }
        System.out.println("Winner is " + winner);
    }

    private boolean checkWin(Board board, Move move){
        boolean win = false;
        for(var ws: winningStrategies){
            win = ws.checkWin(board, move);
            if(win)break;
        }
        return win;
    }
}
