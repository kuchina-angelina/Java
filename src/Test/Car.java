package Test;

public abstract class Car {
    String colour,transmission; //цвет,коробка передач
    int maxSpeed,currentSpeed,price; //максимальная скоростьбтекущая скорость,цена

    public Car(String colour,String transmission,int currentSpeed,int price ){
        this.colour = colour;
        this.transmission = transmission;
        this.currentSpeed = currentSpeed;
        this.price = price;
    }

    abstract void start();

    abstract void  stop();

    abstract int accelerate(int speed);



}
