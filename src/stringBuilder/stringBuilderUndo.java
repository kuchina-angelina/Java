package stringBuilder;
import java.util.Stack;

public class stringBuilderUndo {
    // интерфейс команда
    public interface Command {
        void undo();
    }

    public class Commands implements Command {//наследуем интерфейс Command
        public void undo() {
        }
    }

    StringBuilder stringBuilder; // делегат
    Stack<Command> commands = new Stack<>(); //создаем стек,куда будем добавлять функции для отката назад

    // конструктор класса, где создается  строка
    public stringBuilderUndo(String string) {
        stringBuilder = new StringBuilder(string);
    }

    public stringBuilderUndo append(String string) {
        int length = stringBuilder.length(); // берем длину строки до изменений
        stringBuilder.append(string); // делегируем метод
        int updateLength = stringBuilder.length(); // длина новой строки

        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.delete(updateLength - length + 1, updateLength); //обратное действие: вычисляем начало и конец строки,которую добавили
            }
        };
        commands.add(command); // добавляем в стек команду delete
        return this;
    }

    public stringBuilderUndo delete(int start, int end){ // передаем параматеры,которые означают диапозон,который мы ъотим удалить
        String deleted = stringBuilder.substring(start,end); //substring возвращает подстроку, начиная с позиции start до позиции end(в нашем случае - удаленная строка)
        stringBuilder.delete(start,end); //делегируем метод

        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.insert(start,deleted);//обратное дейсвие: на указанную позицию добавляем удаленную строку
            }
        };
        commands.add(command); // добавляем обратное действие в стек
        return this;
    }

    public stringBuilderUndo deleteCharAt(int index){ //удаляет символ с указанной позиции
        String deleted = String.valueOf(stringBuilder.charAt(index)); //берем удаленную строку
        stringBuilder.deleteCharAt(index);//делегируем метод

        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.insert(index,deleted);//обратное действие:добавляем на определенный индекс удаленную строку
            }
        };
        commands.add(command);// добавляем обратную команду в стек
        return this;
    }

    public stringBuilderUndo reverse() { //метод,который переворачивает строку
        stringBuilder.reverse(); //делегируем метод

        Command command = new Command(){
            public void undo() {
                stringBuilder.reverse(); //обратный переворот
            }
        };
        commands.add(command); //добавляем команду для отката
        return this;
    }

    public stringBuilderUndo replace(int start, int end, String string){//меняет строку на заданном диапозоне
        String replaced = stringBuilder.substring(start,end); // берем строку до изменения
        stringBuilder.replace(start,end,string); //делегируем метод

        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.replace(start, end, replaced); //обратная функция: на тот же диапозон добавляем строку,которую запомнили
            }
        };
        commands.add(command);//добавляем команду в стек
        return this;

    }

    public stringBuilderUndo insert(int index, String string){ //вставляет подстроку в указанную позицию
        stringBuilder.insert(index,string);//добавляем подстроку

        Command command = new Command() {
            @Override
            public void undo() {
                int end = string.length()+1;//обозначаем конец диапозона
                stringBuilder.delete(index,end);//обратное действие: удаляем строку с заданного индекса и до конца вставленной подстроки
            }
        };
        commands.add(command);//добавляем команду в стек
        return this;
    }

    public String toString() { //метод для вывода строки
        return stringBuilder.toString();
    }

    public void undo(){
        if(!commands.isEmpty()){ // если стек не пустой, то откат назад возможен
            commands.pop().undo();
        }else { // в ином случае выведется сообщение о том,что в стеке ничего нет
            System.out.println("Стек пустой");
        }
    }
}
