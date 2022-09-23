package homework1.Shape;

public class Ball extends SolidOfRevolution{

    public Ball(double radius){// конструторк мяча
        this.radius = radius;

    }
    public double getVolume(){// объем
        return 4.0/3*Math.PI*radius*radius*radius;
    }
}
