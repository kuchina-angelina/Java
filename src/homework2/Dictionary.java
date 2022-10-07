package homework2;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        CreateDictionary("I want to go home and don't want to do my lessons");
    }
    public static void CreateDictionary(String string) {
        String[] strings = string.split(" ");//сплитим по пробелу
        LinkedHashMap<String, Integer> dictionary = new LinkedHashMap<>();//создаем словарь,куда добавим слово(ключ) и
                                                                            // кол-во раз сколько оно встретится(значение)
        int count = 0;//счетчик слов
        for (int i = 0; i<strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {//сравниваем слово(i) с другими
                    count++;//если слов в строке несколько,то прибавляем счетчик на 1
                }
            }
            dictionary.put(strings[i],count);//добавляем слово и счетчик слов в словарь
            count=0;//обнуляем счетчик
        }
        System.out.println(dictionary);
    }
}

