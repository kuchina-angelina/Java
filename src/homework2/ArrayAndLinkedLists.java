package homework2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayAndLinkedLists {

    public static void main(String[] args){
        SetAndGet();
    }

    public static void SetAndGet() {
        //создаем ArrayList и LinkedList
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<Integer> linked = new LinkedList<>();

        int add = 1000000;//переменная для добавления элемента
        int get = 100000;//переменная для возврата элемента

        for (int i = 0; i < add; i++) {//цикл для добавления элементов
            //добавляется рандомный элемент
            array.add((1) + (int) (Math.random() * 100));
            linked.add((1) + (int) (Math.random() * 100));
        }

        long start_f = System.currentTimeMillis();//заскает начальное время
        for (int i = 0; i < get; i++) {//цикл по возврату рандомного элемента
            int el = array.get((int) (Math.random() * array.size()));//выбирается рандомный элемент
        }
        long finish_f = System.currentTimeMillis();//засекает конечное время
        long result_f = finish_f - start_f;//считаем разницу времени
        System.out.println("Программа для ArrayList выполнялась " + result_f + " милисекунд");

        long start_s = System.currentTimeMillis();//заскает начальное время
        for (int i = 0; i < get; i++) {//цикл по возврату рандомного элемента
            int el = linked.get((int) (Math.random() * linked.size()));//выбирается рандомный элемент
        }
        long finish_s = System.currentTimeMillis();
        long result_s = finish_s - start_s;//считаем разницу времени
        System.out.println("Программа для LinkedList выполнялась " + result_s/1000 + " секунд");
    }
}
