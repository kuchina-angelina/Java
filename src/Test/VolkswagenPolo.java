package Test;

public class VolkswagenPolo extends Car {
    int length, weigth, mileage;//длина,ширина,пробег
    String seatHeating;//подогрев сиденья
    int maxSpeed;

    VolkswagenPolo(String colour, String transmission, int currentSpeed, int price, int length, int weigth, int mileage) {
        super(colour, transmission, currentSpeed, price);
        this.colour = colour;
        this.maxSpeed = 204;//фиксированная макс скорость
        this.transmission = transmission;
        this.currentSpeed = currentSpeed;
        this.price = price;
        this.mileage = mileage;
        this.weigth = weigth;
        this.length = length;
        this.seatHeating = "No";//подогрев сиденья (фиксированная)

    }

    public int setSpeed(int speed) {//установка текущей скорости
        this.currentSpeed = speed;
        return currentSpeed;
    }
    //метод из базового класса
    @Override
    void start() {
        System.out.println("Машина начала движение");
    }

    //метод из базового класса
    @Override
    void stop() {
        System.out.println("Машина остановилась");
    }

    //метод из базового класса
    @Override
    int accelerate(int speed) {
        currentSpeed += speed;
        if (currentSpeed > maxSpeed) {
            System.out.println("Ускорение невозможно");
        }
        return currentSpeed;
    }

    public int SlowDown(int speed) {//метод сбавления скорости
        currentSpeed -= speed;
        if (currentSpeed < 0) {
            System.out.println("No");
        }
        return currentSpeed;
    }

    public void checkMaileAge(int maileage, int age) {//метод проверяющий уровень пробега
        if (maileage > 50000 && age > 3) {
            System.out.println("Пробег слишком большой");
        }
        System.out.println("Пробег в норме");
    }

    public void checkSeatHeating() {//метод проверяющий есть ли функция подогрева сиденья
        if (seatHeating.equals("Yes")) {
            System.out.println("Функция подогрева сиденья доступна");
        } else {
            System.out.println("Функция подогрева сиденья отсутствует");
        }
    }
}
