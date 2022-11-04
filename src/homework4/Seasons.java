package homework4;
import java.lang.*;

public enum Seasons {//перечисление времен года с средней температурой сезона
    Winter(-20),
    Spring(9.7),
    Autumn(8.0),
    Summer(21){
        public void getDescription() {//метод getDescription для переменной Summer
            System.out.println("Теплое время года.");
        }
    };

    double avgTemperature;

    String[] seasons = new String[] {"Winter", "Spring", "Summer", "Autumn"}; //переменная,содержащая времена года

    public static void main(String[] args) {
        for (Seasons season : Seasons.values()) {//проходимся по переменной,где времена года(seasons) и потом передаем каждый элемент(season)
            info(season);                         //в метод,который печатает информацию о временах года
            System.out.println(' ');
        }
        Seasons mySeason = Summer;//переменная,которая содержит мое любимое время года
        infoAboutMyFavouriteSeason(mySeason);//метод,который печатает информацию о моем любимом времени года

    }

    Seasons(double avgTemperature){//конструктор для среднемесячной температуры
        this.avgTemperature = avgTemperature;
    }

    public double getAverageTemp (){//метод,который возвращает среднемесячную температуру
        return avgTemperature;
    }

    public void season(Seasons season){//метод,который который принимает на вход переменную season enum типа,работает с помощью оператора switch
        switch (season){
            case Winter -> System.out.println("Я люблю зиму!");
            case Spring -> System.out.println("Я люблю весну!");
            case Summer -> System.out.println("Я люблю лето!");
            case Autumn -> System.out.println("Я люблю осень!");
        }
    }
    public void getDescription() {//метод для описания 3-х времен года
        System.out.println("Холодное время года.");
//        switch (season){
//            case AUTUMN -> System.out.println("Холодное время года");
//            case SPRING -> System.out.println("Холодное время года");
//            case WINTER -> System.out.println("Холодное время года");
//            case SUMMER -> System.out.println("Теплое время года");
        }

    public static void info(Seasons season){//метод,который печатает информацию о времени года
        System.out.println("Средняя температура " + season + ": " + season.getAverageTemp());
        season.getDescription();
    }

    public static void infoAboutMyFavouriteSeason(Seasons mySeason){//метод,который печатает информацию о моем любимом времени года
        System.out.println("Средняя температура в мое люимое время года " + '(' + mySeason + ')' + ": " + mySeason.getAverageTemp());
        mySeason.getDescription();
    }
}