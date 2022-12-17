package homework6;

public class NumbersToN {

    public static void main(String[] args) {
        System.out.println(numbers(13));
    }

    public static String numbers(int n) {
        if (n <=0) {
            System.out.println("Введите число, которое будет больше 0"); //если переданное число меньше 1,то выведется сообщение
        } else if (n > 1) { //если больше 1, то рекурсиво выводим числа от 1 до n
            return numbers(n - 1) + "\n" + n;
        }
        return "1"; //если n = 1, то просто выводим ее
    }
}