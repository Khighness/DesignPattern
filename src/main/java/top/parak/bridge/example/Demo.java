package top.parak.bridge.example;

import java.time.Clock;

/**
 * <p> Project: DesignPattern </P>
 * <p> Package: top.parak.bridge.example </p>
 * <p> FileName: Demo <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/8
 */

public class Demo {
    public static void main(String[] args) {
        Shape s1 = new Round(new Red());
        Shape s2 = new Round(new Blue());
        s1.draw();
        s2.draw();
    }
}

interface Color {
    String getColor();
}

class Red implements Color {
    @Override
    public String getColor() {
        return "红色";
    }
}

class Blue implements Color {
    @Override
    public String getColor() {
        return "蓝色";
    }
}

abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public String  getColor() {
        return color.getColor();
    }

    public abstract void draw();
}

class Round extends Shape {
    public Round(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("画" + getColor()  + "的圆形");
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("画" + getColor()  + "的正方形");
    }
}
