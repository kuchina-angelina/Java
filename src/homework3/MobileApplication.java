package homework3;

//оплата через мобильное приложение
public class MobileApplication {
    public void updateBalance(Card card,double pay){
        card.balance+=pay; //к балансу карты прибавляем пополнение
    }
}
