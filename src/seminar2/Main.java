package seminar2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    ArrayList<Workers> employees = new ArrayList<>();

    // создание работников для проверки методов, чтобы не создавать в конструкторе каждый раз
    public void setEmployees() {
        employees.add(new PerHourSalary(1, "Иванов", "Иван", 456));
        employees.add(new FixedSalary(2, "Петров", "Петр", 74123));
        employees.add(new PerHourSalary(3, "Сидоров", "Кирилл", 666));
        employees.add(new FixedSalary(4, "Белов", "Александр", 50000));
        employees.add(new PerHourSalary(5, "Филатов", "Валера", 456));
        employees.add(new FixedSalary(6, "Холмагоров", "Космос", 10000));
        employees.add(new PerHourSalary(7, "Пчелкин", "Виталий", 700));
        employees.add(new FixedSalary(8, "Беляева", "Ксения", 100000));
    }

    public void getEmployees() {
        // проходим циклом по списку с работниками
        for (int i = 0; i < employees.size(); i++) {
            Workers emp = employees.get(i); // берется элемент из списка
            Class class1 = employees.get(i).getClass(); // узнаем, к какому из классов-наследников принадлежит элемент
            if (class1 == PerHourSalary.class) {
                int id = ((PerHourSalary) emp).getId();//берем айди работника из класса PerHourSalary
                System.out.print(id + ":");

                String first_name = ((PerHourSalary) emp).firstName();//берем имя работника из класса PerHourSalary
                System.out.print(first_name + "; ");

                String last_name = ((PerHourSalary) emp).lastName();//берем фамилию работника из класса PerHourSalary
                System.out.print(last_name + "; ");

                double salary = ((PerHourSalary) emp).getPer_hourSalary();//берем зп работника из класса PerHourSalary
                System.out.print(salary + "; " + "\n");

            } else if (class1 == FixedSalary.class) {
                int id = ((FixedSalary) emp).getId(); //берем айди работника из класса FixedSalary
                System.out.print(id + ":");
                String first_name = ((FixedSalary) emp).firstName();//берем имя работника из класса FixedSalary
                System.out.print(first_name + "; ");

                String last_name = ((FixedSalary) emp).lastName();//берем фамилию работника из класса FixedSalary
                System.out.print(last_name + "; ");

                double salary = ((FixedSalary) emp).getFixed_salary();//берем зп работника из класса FixedSalary
                System.out.print(salary + "; " + "\n");
            }
        }
    }

    public void sortSalary() {
        employees.sort(new Comparator<Workers>() {
            @Override
            public int compare(Workers worker1, Workers worker2) {
                if (worker1.countSalary() > worker2.countSalary()) {//если зп у worker1 больше,то поменяет местами
                    return -1;
                } else if (worker1.countSalary() == worker2.countSalary()) {
                    return 0;
                } else {
                    return 1;
                }
            }

        });
        //сортировка по фамилии
        for (int i = 0; i < employees.size() - 1; i++) {
            Workers worker1 = employees.get(i);
            Workers worker2 = employees.get(i + 1);
            int result = worker1.lastName().compareTo(worker2.lastName());//сравниваем фамилии
            int result2 = worker1.firstName().compareTo(worker2.firstName());//сравниваем имена
            if (worker1.countSalary() == worker2.countSalary() && result > 0) {//если одинаковые зарплаты и result возвращает положительное число
                Collections.swap(employees, i, i + 1);//то меняем местами
                //аналогично,но если люди однофамильцы
            } else if (worker1.countSalary() == worker2.countSalary() && worker1.lastName() == worker2.lastName() && result2 > 0) {
                Collections.swap(employees, i, i + 1);
            }
        }
    }

    //выводим первые пять человек из списка
    public void fivePeople() {
        for (int i = 0; i < 5; i++) {
            Workers worker = employees.get(i);
            String last_name = worker.lastName();//вытаскиваем фамилию
            String fist_name = worker.firstName();//вытаскиваем имя
            System.out.println(last_name + " " + fist_name);
        }
    }

    //выводим последних 3 человек
    public void threePeople() {
        int j = employees.size() - 4;
        System.out.println(j);
        for (int i = employees.size() - 1; i > j; i--) {//идем с конца списка
            Workers worker = employees.get(i);
            String last_name = worker.lastName();
            String fist_name = worker.firstName();
            System.out.println(last_name + " " + fist_name);
        }
    }
}

