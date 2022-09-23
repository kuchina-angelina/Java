package homework1.Shape;

public class Pyramid extends Shape {
    private double s;
    private double h;

    public Pyramid(double s, double h) { // конструктор
        this.s = s;
        this.h = h;
    }
    public double getVolume(){
        return 1.0/3*s*h;
    }
}
