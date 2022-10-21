package homework3;

public class SchoolCard extends Card {
    double payment;
    double balance;
    String pay = "Empty";

    public SchoolCard(int number, String name, String last_name){
        super(number,name,last_name);
        this.balance=0;
        this.payment=300;
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
