package seminar2;

public class PerHourSalary extends Workers{
    int id;
    String first_name;//имя
    String last_name;//фамилия
    double salary;


    //конструктор класса
    PerHourSalary(int id,String last_name,String first_name, double salary){
        this.first_name=first_name;
        this.last_name=last_name;
        this.id=id;
        this.salary=salary;
    }
    //метод из базового класса
    @Override
    double countSalary() {
        double average_salary = 20.8 * 8 * salary;
//        System.out.println("Cреднемесячная зарплата = " + average_salary);
        return average_salary;
    }

    public int getId() {
        return id;
    }

    public String lastName(){
        return last_name;
    }

    public String firstName(){
        return first_name;
    }

    public double getPer_hourSalary() {
        return salary;
    }
}
