package seminar2;

public class PerHourSalary extends Workers{
    double per_hourSalary;
    String name;
    int id;

    //конструктор класса
    void per_hourSalary(String name, int id,double per_hourSalary){
        this.name=name;
        this.id=id;
        this.per_hourSalary=per_hourSalary;
    }

    //метод из базового класса
    @Override
    void countSalary() {
        double average_salary = 20.8 * 8 * per_hourSalary;
        System.out.println("Cреднемесячная зарплата = " + average_salary);
    }





}
