package Test;

import java.util.ArrayList;
import java.util.Comparator;

public class Garage {
    int maxCapacity;//уровень вместительности
    ArrayList<Car> cars = new ArrayList<>();//список машин

    public Garage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addCars(Car car) {
        //счетчики для того,чтобы узнать количество машин
        int bmv = 0;
        int toyoto = 0;
        int volk = 0;
        Class clazz = car.getClass();//определяем марку машины
        if (clazz == BMVX5.class) {
            int size = ((BMVX5) car).weigth * ((BMVX5) car).length;//узнаем габариты машины
            if (size < maxCapacity) {
                maxCapacity -= size;//вычитаем из доступной вместительности габариты машины
                bmv += 1;//прибавляем счетчик
                cars.add(car);//добавим машину в список
            } else {
                System.out.println("Недостаточно места");
            }//ниже аналогично
        } else if (clazz == ToyotaRav4.class) {
            int size = ((ToyotaRav4) car).weigth * ((ToyotaRav4) car).length;
            if (size < maxCapacity) {
                maxCapacity -= size;
                toyoto += 1;
                cars.add(car);
            } else {
                System.out.println("Недостаточно места");
            }

        } else if (clazz == VolkswagenPolo.class) {
            int size = ((VolkswagenPolo) car).weigth * ((VolkswagenPolo) car).length;
            if (size < maxCapacity) {
                maxCapacity -= size;
                volk += 1;
                cars.add(car);
            } else {
                System.out.println("Недостаточно места");
            }
        }
        System.out.println("В гараже находятся: " + "BMV X5" + " в количестве " + bmv + " штук,Toyota Rav 4" + " в количестве" + toyoto + " штук, Volkswagen Polo " + "в количестве " + volk + "штук.");
    }

    public void sortCarsByPrice() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (car1.price > car2.price) {//если у car1 цена выше,то поменяем местами
                    return -1;
                } else if (car1.price == car2.price) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }
}

