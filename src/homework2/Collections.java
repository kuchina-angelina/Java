package homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Collections {
    public static void main(String[] args){
        Collection<String> collections= new ArrayList<String>(Arrays.<String>asList("BEN","BEN","JACK"));
        System.out.println(deleteString(collections));

    }

    public static Collection<Byte> deleteByte(Collection<Byte> collection){
        return new HashSet<Byte>(collection); //HashSet возвращает коллекцию без дубликатов
    }

    public static Collection<Short> deleteShort(Collection<Short> collection) {
        return new HashSet<Short>(collection);//HashSet возвращает коллекцию без дубликатов
    }

    public static Collection<Integer> deleteInteger(Collection<Integer> collection){
        return new HashSet<Integer>(collection);//HashSet возвращает коллекцию без дубликатов
    }
    public static Collection<Float> deleteFloat(Collection<Float> collection) {
        return new HashSet<Float>(collection);//HashSet возвращает коллекцию без дубликатов
    }

    public static Collection<Double> deleteDouble(Collection<Double> collection) {
        return new HashSet<Double>(collection);//HashSet возвращает коллекцию без дубликатов
    }
    public static Collection<String> deleteString(Collection<String> collection){
        return new HashSet<String>(collection);//HashSet возвращает коллекцию без дубликатов
    }

    public static Collection<Character> deleteCharacter(Collection<Character> collection) {
        return new HashSet<Character>(collection);//HashSet возвращает коллекцию без дубликатов
    }
}
