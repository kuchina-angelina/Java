package homework4;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader("Aгапова К.В", 1, "Экономика",
                "01.04.2001", 161573186 );

        Book book1 = new Book("Набоков В.В.", "Лолита");
        Book book2 = new Book("Джек Лондон", "Мартин Иден");
        Book book3 = new Book("Булгаков М.А.", "Морфий");

        reader.takeBook(3);
        reader.takeBook(book1, book2, book3);
        reader.returnBook("Джейн Эйр","Третья девушка");
    }
}
