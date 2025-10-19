package com.demoProblems.tictactoe;

public class Player {
    private Symbol symbol;
    private String name;

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Player(Symbol symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
}
