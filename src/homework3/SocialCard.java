package homework3;

public class SocialCard extends Card {
    double payment;
    double balance;
    String pay;

    public SocialCard(int number, String name, String last_name) {
        super(number, name, last_name);
        this.balance = 0;
        this.pay = "Empty";
        this.payment = 500;
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
