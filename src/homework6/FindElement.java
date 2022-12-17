package homework6;
import java.util.Arrays;

public class FindElement {

    public static void main(String[] args) {
        int[] numbers = new int[100000000]; // создаем массив и затем заполняем его
        for (int i = 0; i < 100000000; i++) {
            numbers[i] = (1) + (int) (Math.random() * 10);
        }

        long start_en = System.currentTimeMillis(); // засекаем время старта
        System.out.println(enumeration(numbers, 5));
        long end_en = System.currentTimeMillis(); // время окончания
        long result_en = end_en - start_en; // результат работы
        System.out.println("Метод перебора: " + result_en + " миллисекунд");

        long start_b = System.currentTimeMillis(); //запускаем время старта
        System.out.println(binarySearch(numbers, 5));
        long end_b = System.currentTimeMillis(); // момент окончания
        long result_b = end_b - start_b;
        System.out.println("Метод двоичного поиска: " + result_b + " миллисекунд");
    }

    public static int enumeration(int[] numbers, int element) { //метод перебора
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == element) { // если элемент находится в массиве,то вернется позиция этого элемента
                return i;
            }
        }
        return -1; // в ином случае -1
    }

    public static int binarySearch(int [] number, int element) {
        return binarySearch(number, element, 0, number.length);
    }

    public static int binarySearch(int[] numbers, int element, int start, int end) {
        int middle = (start + end) / 2; // находим середину списка

        if (end < start) { // если делить больше нечего,то возвращаем -1
            return -1;
        }

        if (element == numbers[middle]) { // если заданный элемент есть в списке,то передаем его позицию
            return middle;
        } else if (element < numbers[middle]) { // если заданный элемент меньше значения в середине списка,то идем по левой части списка
            return binarySearch(numbers, element, start, middle - 1);
        } else {
            return binarySearch( numbers, element, middle + 1, end); // если заданный элемент меньше значения в середине списка,то идем по правой части списка
        }
    }

}
