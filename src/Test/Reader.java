package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Reader {
    String FIO, faculty, birthdate;
    int readerId;
    long phone;

    //конструктор класса Reader
    Reader(String FIO,int readerId, String faculty, String birthdate,long phone){
        this.FIO = FIO; //ФИО
        this.faculty = faculty; //факультет
        this.phone = phone; //номер телефона
        this.birthdate = birthdate; // дата рождения
        this.readerId = readerId; //номер читательского билета
        }


    public void takeBook(int number){//метод,который выводит информацию о том,сколько книг взял студент
        System.out.println(this.FIO + "взял(а) " + number + " книг(и)");

    }

    public void returnBook(int number){//метод,который выводит информацию о том,сколько книг студент вернул
        System.out.println(this.FIO + "вернул(а) " + number + " книг(и)");

    }

    public void takeBook(Book... books){//метод,который принимает переменное количество объектов класса Book и выводит информацию о том,какие книги взял студент
        ArrayList<String> arrayBooks = new ArrayList<>();//создаем список,где у нас будут названия книг
        for(Book book:books){//проходимя по переданным значениям и затем добавляем их в список
            arrayBooks.add(book.name);
        }
        System.out.print(this.FIO + " взял(a) книги: ");
        for(String i:arrayBooks){
            System.out.print(i + ", ");//проходимся по списку книг и выводим их названия
        }
    }

    public void returnBook(Book ... books){//метод,который принимает переменное количество объектов класса Book и выводит информацию о том,какие книги студент вернул
        ArrayList<String> arrayBooks = new ArrayList<>();//создаем список,где у нас будут названия книг
        for(Book book:books){//проходимя по переданным значениям и затем добавляем их в список
            arrayBooks.add(book.name);
        }
        System.out.println(this.FIO + " вернул(a) книги: ");
        for(String i:arrayBooks){//проходимся по списку книг и выводим их названия
            System.out.println(i);
        }
    }

    public void takeBook(String ... nameBooks){//метод,который принимает переменное количество названий книг и выводит информацию,какие книги взял студент
        ArrayList<String> arrayBooks = new ArrayList<>(Arrays.asList(nameBooks));//закидываем названия всех книг в список
        System.out.print(this.FIO + " взял(a) книги: ");
        for(String i:arrayBooks){//проходимся по списку книг и выводим на консоль их названия
            System.out.print(i + ", ");
        }
    }

    public void returnBook(String ... nameBooks){//метод,который принимает переменное количество названий книг и выводит информацию,какие книги студент вернул
        ArrayList<String> arrayBooks = new ArrayList<>(Arrays.asList(nameBooks));//закидываем названия всех книг в список
        System.out.print(this.FIO + " вернул(a) книги: ");
        for(String i:arrayBooks){//проходимся по списку книг и выводим на консоль их названия
            System.out.print(i + ", ");
        }
    }
}
