package com.zjuee.innerclass;

import static net.mindview.util.Print.print;

interface Game { boolean move(); }
interface GameFactory { Game getGame(); }

class Checkers implements Game {
    private int moves = 0;
    private static final int MOVES = 3;
    public boolean move() {
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory checkersFactory() {
        return new GameFactory() {
            @Override
            public Game getGame() {
                return new Checkers();
            }
        };
    }
}

class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;
    public boolean move() {
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory checkersFactory() {
        return new GameFactory() {
            @Override
            public Game getGame() {
                return new Chess();
            }
        };
    }
}

public class Games {
    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while(s.move());
    }
    public static void main(String[] args) {
        playGame(Checkers.checkersFactory());
        playGame(Chess.checkersFactory());
    }
}
