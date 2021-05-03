package com.zjuee.reusing;

import static net.mindview.util.Print.print;

class RYL {
    void win(int x) {
        print("win(int)");
    }

    void win(float f) {
        print("win(float)");
    }
}

public class RNG extends RYL {
    void win(long l) {
        print("win(long)");
    }

    public static void main(String[] args) {
        RNG rng = new RNG();
        rng.win(1L);
        rng.win(1);
        rng.win(1.0f);
    }
}
