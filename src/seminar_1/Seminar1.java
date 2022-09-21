package seminar_1;

public class Seminar1 {
    public static void main(String[] args) {
        first();
        second();
        third();
        fourth_1();
        fourth_2();
        fifth();
        sixth();
        seventh();
        eighth();
        ninth();
        tenth();
        eleventh();
        twelveth();


    }

    public static void first() {
        System.out.println("Hello world");
    }

    public static void second() {
        int x = 10;
        System.out.println(x);
    }

    public static void third() {
        int x = 10;
        System.out.println(x);
        int a = ++x;
        x += 1;
        System.out.println(a);
        System.out.println(x);
    }

    public static void fourth_1() {
        int first = 1;
        int second = 2;
        int third;
        third = first;
        first = second;
        second = third;
        System.out.println(first);
        System.out.println(second);
    }

    public static void fourth_2() {
        int first = 8;
        int second = 7;
        second -= first;
        first += second;
        second = first - second;
        System.out.println(first);
        System.out.println(second);
    }

    public static void fifth() {
        int a = 3;
        int b = 4;
        double c = Math.sqrt(a * a + b * b);
        System.out.println(c);

    }

    public static void sixth() {
        int a = 798645312;
        float b = a % 10;
        System.out.println(b);

    }

    public static void seventh() {
        int number = 51285;
        if (number > 10) {
            int result = number % 100 / 10;
            System.out.println(result);
        } else {
            System.out.println("a number is less than 10");

        }

    }

    public static void eighth() {
        int number_ = 85;
        if(number_ > 9 && number_ < 100){
            int result_ = number_ / 10;
            System.out.println(result_);
        }
        else{
            System.out.println("a number has more or less than 2 symbols");
        }
    }

    public static void ninth(){
        int num = 100;
        int res = num - 21;
        System.out.println(res);

    }

    public static void tenth(){
        int number1 = 5;
        int number2 = 15;
        float arithmetic_mean = (number1 + number2) / 2;
        System.out.println("Среднее арифметическое = " + arithmetic_mean);

    }

    public static void eleventh(){
        int number_1 = 25;
        int number_2 = 15;
        double geometric_mean = Math.sqrt(number_1*number_2);
        System.out.println("geometric mean = " + geometric_mean);
    }

    public static void twelveth(){
        float number_x1 = 5;
        float number_y1 = 4;
        float number_x2 = 4;
        float number_y2 = 8;

        double distance = Math.sqrt(Math.pow(number_x2 - number_x1, 2) - Math.pow(number_y2 - number_y1, 2));
        System.out.println("distance between points = " + distance);

    }

}