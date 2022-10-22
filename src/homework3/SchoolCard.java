package homework3;

public class SchoolCard extends Card {
    double payment;//оплата
    double balance;//баланс
    String pay = "Empty";//состояние карты (оплачена или нет)

    public SchoolCard(int number, String name, String last_name){
        super(number,name,last_name);
        this.balance=0;
        this.payment=300;
    }
    public String payment(double payment){
        if(payment>=this.payment){
            System.out.println("Проезд оплпaчен на месяц.");
            this.pay="Pay";//если мы пополняем на нужную сумму,то переменная рау меняет значение
            return this.pay;
        }else{
            return this.pay;//если нет,то возвращаем изначальное значение
        }
    }

    public String checkPayment(){//проверка оплаты карты на месяц
        return this.pay;
    }
}
