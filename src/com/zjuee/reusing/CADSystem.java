package com.zjuee.reusing;

import static net.mindview.util.Print.print;

class Shape {
    Shape(int i) {
        print("Shape constructor");
    }
    void dispose() {
        print("Shape dispose");
    }
}

class Circle extends Shape {

    Circle(int i) {
        super(i);
        print("Drawing Circle");
    }

    @Override
    void dispose() {
        print("Erasing Circle");
        super.dispose();
    }
}

class Line extends Shape {

    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + "start" + ", " + end);
    }

    @Override
    void dispose() {
        print("Erasing Line: " + "start" + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {

    private Circle c;
    private Line[] lines;

    public CADSystem(int i) {
        super(i+1);
        c = new Circle(i);
        lines = new Line[i];
        for (int j = 0; j < i; j++) {
            lines[j] = new Line(j, j+j);
        }
        print("Combined Structure");
    }

    public void dispose() {
        print("CADSystem dispose()");
        c.dispose();
        for (Line l : lines) {
            l.dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(10);
        try {
            //
//            return;
        } finally {
            x.dispose();
        }
    }
}
