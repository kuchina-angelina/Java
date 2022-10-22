package homework3;

//пополнение через банкомат
public class ATM {
    public void updateBalance(Card card,double pay){
        card.balance+=pay;//к балансу карты прибавляем пополнение
        System.out.println(card.balance);
    }
}
