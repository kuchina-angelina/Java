package homework3;

public class Terminal {

    public void payWay(Card card){
        Class classCard = card.getClass();
        if (classCard == Card.class){
            if(card.balance>=46){
                card.balance-=46;
                System.out.println("Оплата прошла. Остаток " + card.balance);
            }else{
                System.out.println("Недостаточно средств!");

            }
        }
        else if(classCard == StudentCard.class){
            if(((StudentCard) card).checkPayment()=="Pay"){
                System.out.println("Оплата прошла.");
            }
            else {
                System.out.println("Недостаточно средств!");
            }
        }

        else if(classCard == SocialCard.class){
            if(((SocialCard) card).checkPayment()=="Pay"){
                System.out.println("Оплата прошла.");
            }
            else {
                System.out.println("Недостаточно средств!");
            }
        }
        else if(classCard == SchoolCard.class){
            if(((SchoolCard) card).checkPayment()=="Pay"){
                System.out.println("Оплата прошла.");
            }
            else {
                System.out.println("Недостаточно средств!");
            }
        }
    }
}
