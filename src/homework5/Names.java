package homework5;

public class Names {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();//заускаем первый поток
        thread1.join();//ждем,когда первый поток завершится,чтобы выполнить второй
        thread2.start(); // выполняем второй поток
    }
}

class Thread1 extends Thread{ //первый поток
    @Override
    public void run() {
            System.out.println(getName()); //метод, который выводит имя потока с помощью метода getName()
        }
}

class Thread2 extends Thread{ //второй поток
    @Override
    public void run() {
        System.out.println(getName()); //метод, который выводит имя потока с помощью метода getName()
    }
}





