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
        employees.add(new PerHourSalary(1, "Иванов", "Иван", 500));
        employees.add(new FixedSalary(2, "Петров", "Петр", 50000));
        employees.add(new PerHourSalary(3, "Сидоров", "Андрей", 210));
        employees.add(new FixedSalary(4, "Копылов", "Юрий", 50000));
        employees.add(new PerHourSalary(5, "Авросимова", "Ксения", 456));
        employees.add(new FixedSalary(6, "Иванова", "Мария", 100000));
        employees.add(new PerHourSalary(7, "Корнев", "Даниил", 700));
        employees.add(new FixedSalary(8, "Биляева", "Ольга", 48900));
        employees.add(new PerHourSalary(9, "Андропова", "Татьяна", 119));
        employees.add(new FixedSalary(10, "Морозова", "Морозко", 200000));
    }

    public void getEmployees() {
        // проходим циклом по списку с работниками
        for (int i = 0; i < employees.size(); i++) {
            Workers emp = employees.get(i); // берется элемент из списка
            Class class1 = employees.get(i).getClass(); // узнаем, к какому из классов-наследников принадлежит элемент
            // рассматриваем 2 варианта, чтобы не перепутать методы
            if (class1 == PerHourSalary.class) {
                int id = ((PerHourSalary) emp).getId();
                System.out.print(id + ":");

                String first_name = ((PerHourSalary) emp).firstName();
                System.out.print(first_name + "; ");

                String last_name = ((PerHourSalary) emp).lastName();
                System.out.print(last_name + "; ");

                double salary = ((PerHourSalary) emp).getPer_hourSalary();
                System.out.print(salary + "; " + "\n");

            } else if (class1 == FixedSalary.class) {
                int id = ((FixedSalary) emp).getId();
                System.out.print(id + ":");
                String first_name = ((FixedSalary) emp).firstName();
                System.out.print(first_name + "; ");

                String last_name = ((FixedSalary) emp).lastName();
                System.out.print(last_name + "; ");

                double salary = ((FixedSalary) emp).getFixed_salary();
                System.out.print(salary + "; " + "\n");
            }
        }
    }

    public void sortSalary(){
        employees.sort(new Comparator<Workers>() {
            @Override
            public int compare(Workers worker1, Workers worker2) {
               if(worker1.countSalary()>worker2.countSalary()){
                   return -1;
               }else if(worker1.countSalary()==worker2.countSalary()){
                   return 0;
               }else{
                   return 1;
               }
            }

        });
        for(int i=0;i<employees.size()-1;i++){
            Workers worker1 = employees.get(i);
            Workers worker2 = employees.get(i+1);
            int result=worker1.lastName().compareTo(worker2.lastName());
            if(worker1.countSalary()==worker2.countSalary() && result > 0){
                Collections.swap(employees,i,i+1);
            }
        }
    }

    public void fivePeople(){
        for(int i=0;i<5;i++){
            Workers worker = employees.get(i);
            String last_name = worker.lastName();
            String fist_name = worker.firstName();
            System.out.println(last_name + " " + fist_name);
        }
    }

    public void threePeople(){
        int j = employees.size()-4;
        System.out.println(j);
        for(int i=employees.size()-1;i>j;i--){
            Workers worker = employees.get(i);
            String last_name = worker.lastName();
            String fist_name = worker.firstName();
            System.out.println(last_name + " " + fist_name);
        }
    }

//    public void writeFile(String fileName) {
//        try(FileWriter fw = new FileWriter(fileName)){
//            for (int i = 0; i < employees.size(); i++) {
//                Workers emp = employees.get(i); // берется элемент из списка
//                // вытаскиваем информацию о работнике из элемента
//                int id = emp.getId();
//                String lastName = emp.lastName();
//                String firstName = emp.firstName();
//                double salary = emp.countSalary();
//                // записываем в файл
//                fw.write("id: " + id + ", first name: " + firstName + ", last name: " + lastName +
//                        ", salary: " + salary + "; \n");
//            }
//            fw.close();
//        };
//
//        }
//    }
////
////    public readFile(){
////
//
//
