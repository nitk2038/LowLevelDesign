- It is used when we have to make copy/clone from existing object.
- Existing Problem
	- The client would have to know all ppty of object it wants to clone
	- He may not be able to clone if there are private fields/methods.
	- So it becomes responsibility of class to provide clone functionality.

## Code

Demo Class
```
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
```

Shape
```
package CreationalDesignPattern.PrototypePattern.Shapes;  
  
import java.util.Objects;  
  
public abstract class Shape {  
        public int x;  
        public int y;  
        public String color;  
  
        public Shape() {}  
        public Shape(Shape target) {  
            if(target!=null) {  
                this.x = target.x;  
                this.y = target.y;  
                this.color = target.color;  
            }  
        }  
  
        public abstract Shape clone();  
        public boolean equals(Object object2) {  
            if(!(object2 instanceof  Shape)) return false;  
            Shape shape2 = (Shape)object2;  
            return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);  
        }  
}
```

Square
```
package CreationalDesignPattern.PrototypePattern.Shapes;  
  
import java.util.Objects;  
  
public class Square extends Shape {  
    public int x;  
    public int y;  
    public Square(){};  
    public Square(Square target) {  
        super(target);  
        if(target!=null) {  
            this.x = target.x;  
            this.y = target.y;  
        }  
    }  
  
    public Shape clone() {  
        return new Square(this);  
    }  
    public boolean equals(Object object2) {  
        if(!(object2 instanceof  Shape)) return false;  
        Shape shape2 = (Shape)object2;  
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);  
    }  
}
```

Circle
```
package CreationalDesignPattern.PrototypePattern.Shapes;  
  
import java.util.Objects;  
  
public class Circle extends  Shape {  
    public int radius;  
    public Circle (){};  
    public Circle(Circle target) {  
        super(target);  
        if(target!=null) {  
            this.radius = target.radius;  
        }  
    }  
  
    @Override  
    public Shape clone() {  
        return new Circle(this);  
    }  
    public boolean equals(Object object2) {  
        if(!(object2 instanceof  Shape)) return false;  
        Shape shape2 = (Shape)object2;  
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);  
    }  
}
```

Output
```
--- Prototype Pattern ---
Cloning success
```