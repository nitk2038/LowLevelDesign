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