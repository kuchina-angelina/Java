package homework1.Shape;

public class Box extends Shape{
    private double volume;

    public void Box(double volume){//конструктор
        this.volume=volume;

    }

    public boolean add(Shape shape){
        this.volume-=shape.getVolume();
        if(this.volume>0){
            return true;
        }
        else{
            return false;

        }
    }
}
