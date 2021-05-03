package com.zjuee.polymorphism;

import static net.mindview.util.Print.print;

class Glyph {
    void draw() {
        print("Glyph.draw()");
    }
    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private static int radius = 1;
    public RoundGlyph(int radius) {
        RoundGlyph.radius = radius;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
