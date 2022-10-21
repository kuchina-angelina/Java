package homework3;
import java.lang.*;


public class Card {
    double pay;
    int number;
    String name;
    String last_name;
    double balance;

    public Card(int number,String name,String last_name){
        this.number=number;
        this.name=name;
        this.last_name=last_name;
        this.balance=0;
        this.pay=46;
    }

    public double checkTheBalance(){
        return this.balance;
    }
}
