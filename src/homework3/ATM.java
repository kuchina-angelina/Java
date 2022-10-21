package homework3;

public class ATM {
    public void updateBalance(Card card,double pay){
        card.balance+=pay;
        System.out.println(card.balance);
//        return card.balance;
    }
}
