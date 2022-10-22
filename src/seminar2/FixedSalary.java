package seminar2;

public class FixedSalary extends Workers{
    int id;
    String first_name;
    String last_name;
    double salary;

    //конструктор класса
    FixedSalary(int id,String last_name,String first_name, double salary){
        this.salary=salary;
        this.first_name=first_name;
        this.last_name=last_name;
        this.id=id;
    }
    //метод из базового класса
    @Override
    double countSalary() {
//        System.out.println("Среднемесячная зарплата = " + fixed_salary);
        return salary;
    }
    //метод из базового класса,возращающий айди
    @Override
    int getId() {
        return id;
    }
    //метод из базового класса,возращающий фамилию
    @Override
    String lastName() {
        return this.last_name;
    }
    //метод из базового класса,возвращающий имя
    @Override
    String firstName() {
        return this.first_name;
    }

    public double getFixed_salary() {
        return salary;
    }
}

