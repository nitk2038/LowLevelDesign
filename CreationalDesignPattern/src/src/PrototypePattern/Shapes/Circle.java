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
