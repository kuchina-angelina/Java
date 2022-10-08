package seminar2;

public class FixedSalary extends Workers{
    int fixed_salary;
    int id;
    String name;

    //конструктор класса
    void fixedSalary(int id,String name,int fixed_salary){
        this.fixed_salary=fixed_salary;
        this.name=name;
        this.id=id;
    }

    //метод из базового класса
    @Override
    void countSalary() {
        System.out.println("Среднемесячная зарплата = " + fixed_salary);
    }
}
