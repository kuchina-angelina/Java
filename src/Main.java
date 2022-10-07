import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> dictionaryOfWords = new HashMap<>();
        String ss = "you you";
        String[] strings = ss.split(" ");

        LinkedHashSet<String> word = new LinkedHashSet<>(List.of(strings));
        ArrayList<String> words = new ArrayList<>(word);

        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < strings.length; j++) {
                if (words.get(i).equals(strings[j])) {
                    count++;
                }
            }
            dictionaryOfWords.put(words.get(i), count);
            count = 0;
        }
        System.out.println(dictionaryOfWords);

    }
}
