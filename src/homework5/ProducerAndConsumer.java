package homework5;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Bufer bufer = new Bufer();
        Producer producer = new Producer(bufer);
        Consumer consumer = new Consumer(bufer);
        producer.start(); // запуск потока производителя
        consumer.start(); // запуск потока потребителя
    }
}

// класс общего буфера
class Bufer {
    int size = 5; // вместимость буфера
    int numbers = 0; // количество данных в буфере(изначально 0)

    // метод, который потребляет данные из буфера
    public synchronized void get() {
        // пока буфер пуст - ждет
        while (numbers < 1) {
            try {
                wait();
            } catch (InterruptedException exception) {
                System.out.println("Буфер данных пустой");
            }
        }
        numbers--; //иначе потребляет данные по одному
        notify();
    }

    // метод, который добавляет данные в буфер
    public synchronized void put() {
        while (numbers >= size) {
            try {
                wait(); //пока размеры буфера превышены - ждет
            } catch (InterruptedException exception) {
                System.out.println("Допустимый размер буфера превышен");
            }
        }
        numbers++; // если место есть, то загружает данные
        notify();
    }
}

// поток производителя
class Producer extends Thread {
    Bufer bufer; // общий буфер

    // конструктор производителя
    Producer(Bufer bufer){
        this.bufer = bufer;
    }

    public void run() {
        for(int i = 0; i < bufer.size; i++) { //пока есть место в буфере, будет вызываться метод, который добавляет данные
            bufer.put();
        }
    }
}

// поток потребителя
class Consumer extends Thread {
    Bufer bufer;

    // конструктор потребителя
    Consumer(Bufer bufer) {
        this.bufer = bufer;
    }

    public void run() {
        for (int i = 0; i < bufer.size; i++) { //пока данные есть в буфере, будет вызываться метод, который потребляет данные
            bufer.get();
        }
    }
}

