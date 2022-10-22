package homework3;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Terminal {

    ArrayList<String> statistics = new ArrayList<>();
    //мептод для проверки оплаты проезда
    public void payWay(Card card){
        Class classCard = card.getClass();
        if (classCard == Card.class){//для обычной карты достаточно,что на балансе хватало денег для оплаты
            if(card.balance>=46){
                card.balance-=46;
                statistics.add("Разовая поездка");//добавляем в список данные
                statistics.add("Зашли в транспорт");//добавляем в список данные
                statistics.add("Оплата прошла");//добавляем в список данные
                System.out.println("Оплата прошла. Остаток " + card.balance);
            }else{
                System.out.println("Недостаточно средств!");

            }
        }
        else if(classCard == StudentCard.class){
            if(((StudentCard) card).checkPayment()=="Pay"){//если checkPayment() возвращает "Рау",то проезд оплачен на месяц
                statistics.add("Зашли в транспорт");//добавляем в список данные
                statistics.add("Оплата прошла");//добавляем в список данные
                System.out.println("Оплата прошла.");

            }
            else {
                System.out.println("Недостаточно средств!");//в другом случае оплата не пройдет,потому что платеж просрочен
            }
        }

        //с методами ниже аналогично
        else if(classCard == SocialCard.class){
            if(((SocialCard) card).checkPayment()=="Pay"){
                statistics.add("Зашли в транспорт");//добавляем в список данные
                statistics.add("Оплата прошла");//добавляем в список данные
                System.out.println("Оплата прошла.");

            }
            else {
                System.out.println("Недостаточно средств!");
            }
        }
        else if(classCard == SchoolCard.class){
            if(((SchoolCard) card).checkPayment()=="Pay"){
                statistics.add("Зашли в транспорт");//добавляем в список данные
                statistics.add("Оплата прошла");//добавляем в список данные
                System.out.println("Оплата прошла");

            }
            else {
                System.out.println("Недостаточно средств!");
            }
        }
        System.out.println(statistics);
    }

    public void getStatictic(){
        //метод,который выводит статистику
        LinkedHashMap<String, Integer> statistic = new LinkedHashMap<>();
        int k=1;//счетчик для отслеживания оплаты
        int k1=1;//счетчик проходимости
        int k2=1;//счетчик разовой оплаты
        for(String i:statistics){
            if(i.equals("Оплата прошла")){
                statistic.put(i,k+1);//добавляем в словарь значение i и счетчик
            }else if(i.equals("Зашли в транспорт")){
                statistic.put(i,k1+1);//добавляем в словарь значение i и счетчик
            }
            else if(i.equals("Разовая оплата")){
                statistic.put(i,k2+1);//добавляем в словарь значение i и счетчик

            }
        }
        System.out.println(statistic);//выводим
    }
}
