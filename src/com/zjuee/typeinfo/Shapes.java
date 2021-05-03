package com.zjuee.typeinfo;

import java.util.Arrays;
import java.util.List;

import static net.mindview.util.Print.print;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }
    public abstract String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Rectangular extends Shape {
    public String toString() {
        return "Rectangular";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Rectangular(), new Rhomboid());
        for (Shape shape : shapes) {
            shape.draw();
        }
        Shape r = new Rhomboid();
        print(r instanceof Rhomboid);
            Rhomboid r2 = (Rhomboid) r;
        print(r instanceof Circle);
            Circle r3 = (Circle) r;

    }
}
