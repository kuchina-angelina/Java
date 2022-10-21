package homework3;

public class StudentCard extends Card{
    double payment;
    double balance;
    String pay = "Empty";

    public StudentCard(int number, String name, String last_name){
        super(number,name,last_name);
        this.balance=0;
        this.payment=400;
    }

    @Override
    public double checkTheBalance() {
        return this.balance;
    }

    public String payment(double payment){
        if(payment>=this.payment){
            System.out.println("Проезд оплпaчен на месяц.");
            this.pay="Pay";
            return this.pay;
        }else{
            return this.pay;
        }
    }

    public String checkPayment(){
        return this.pay;
    }

}
