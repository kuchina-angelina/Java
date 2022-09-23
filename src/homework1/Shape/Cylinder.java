package homework1.Shape;

public class Cylinder extends SolidOfRevolution{
    private final double height;

    public Cylinder(double radius, double height){//конструкор
        this.height=height;
        this.radius=radius;
    }
    public double getVolume(){//площадь цилиндра
        return Math.PI*radius*radius*height;
    }

}
