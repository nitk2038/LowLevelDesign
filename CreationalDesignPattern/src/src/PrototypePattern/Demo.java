package CreationalDesignPattern.PrototypePattern;

import CreationalDesignPattern.PrototypePattern.Shapes.Circle;
import CreationalDesignPattern.PrototypePattern.Shapes.Shape;
import CreationalDesignPattern.PrototypePattern.Shapes.Square;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Prototype Pattern ---");
        List<Shape> shapeList = new ArrayList<>();
        Circle c = new Circle();
        c.x = 10;
        c.y = 20;
        c.radius = 25;
        c.color = "red";
        shapeList.add(c);

        Circle anotherCircle = (Circle)(c.clone());
        if(c.equals(anotherCircle)) {
            System.out.println("Cloning success");
        } else {
            System.out.println("Some Err while cloning ");
        }
    }
}
