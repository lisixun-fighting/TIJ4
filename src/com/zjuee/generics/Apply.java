package com.zjuee.generics;

import java.lang.reflect.*;
import java.util.*;

public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object...args) {
        try {
            for (T t : seq)
                f.invoke(t, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void rotate() {
        System.out.println(this + " rotate");
    }
    public void resize(int newSize) {
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape {}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++)
                add(type.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class),5);

        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class),5);

        Apply.apply(new FilledList<>(Shape.class, 10), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<>(Shape.class, 10), Shape.class.getMethod("resize", int.class), 5);

        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
    }
}
