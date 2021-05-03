package com.zjuee.reusing;

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }

    void dispose() {}
}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }

    @Override
    void dispose() {
        super.dispose();
    }
}

public class Chess extends BoardGame {
    Chess(int i) {
        super(i);
        System.out.println("Chess constructor");
    }

    @Override
    void dispose() {
        super.dispose();
    }
}
