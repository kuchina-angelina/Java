package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Planner {
    static ArrayList<Task> listOfTasks = new ArrayList<>(); //создаем список, где будут храниться все данные о запланнированнах задачах
    static int[] nums = IntStream.rangeClosed(1, 10000000).toArray(); // создаем массив со значениями, откуда потом будем брать номер для задачи
    static List<Integer> ids = Arrays.stream(nums).boxed().collect(Collectors.toList()); //конвертируем массив в список

    //метод, который создает задание
    public static void createTask() {
        try {
            System.out.println("Введите название задания: "); //ввод данных(название,доп. информация и дата окончания) производится с консоли
            Scanner input_name = new Scanner(System.in);
            String name = input_name.nextLine();

            System.out.println("Введите дополнительную информацию: ");
            Scanner input_info = new Scanner(System.in);
            String information = input_info.nextLine();

            System.out.println("Введите дату окончания: ");
            Scanner input = new Scanner(System.in);
            String endDate = input.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
            LocalDate date = LocalDate.parse(endDate, formatter);
            LocalDate currentDate = LocalDate.now();

            if(date.isAfter(currentDate)){
                Task task = new Task(endDate,name, information); //затем введенные данные мы передаем в конструктор,чтобы создать задание
                listOfTasks.add(task); //добавляем задание в список, где хранятся все планы
                System.out.println();
                System.out.println("\u001B[32mЗадание успешно создано!\u001B[0m");

            } else if (date.getDayOfMonth() == currentDate.getDayOfMonth() & date.getMonth() == currentDate.getMonth() & date.getYear() == currentDate.getYear()) {
                Task task = new Task(endDate,name, information); //затем введенные данные мы передаем в конструктор,чтобы создать задание
                listOfTasks.add(task); //добавляем задание в список, где хранятся все планы
                System.out.println();
                System.out.println("\u001B[32mЗадание успешно создано!\u001B[0m");

            }else {
                System.out.println("\u001B[31mВы не можете установить дату,которая раньше текущей\u001B[0m");

            }


        }catch (Exception e){ //обработка исключения(перехватываются некорректные данные)
            System.out.println("Вероятно,Вы ввели некорректный тип данных!");
        }

    }

    //метод, который удаляет задание
    public static void deleteTask() {
        try {
            if (!listOfTasks.isEmpty()){
                System.out.println("\u001B[32mВыберете номер задачи,которую хотите удалить:\u001B[0m");
                showAll();
                Scanner inputId = new Scanner(System.in);
                int id = inputId.nextInt();
                //удаление производится по номеру задачи(с консоли вводим номер задачи,которую хотим удалить)
                for(int i = 0; i<listOfTasks.size();i++){ //затем проходим циклом по списку,если номер задачи совпадает с заданным номером,то удаляем информацию
                    Task t = listOfTasks.get(i);
                    if(t.getId()==id){
                        listOfTasks.remove(i);
                        System.out.println("\u001B[32mЗадание успешно удалено!\u001B[0m");

                    }
                }
            }else{
                System.out.println("У вас нет созданных заданий");
            }
        }catch (Exception e){ //обрабатываем ситуацию,когда вводится некорректный тип данных
            System.out.println("Некорректный ввод данных!");
        }
    }

    //метод, который редактирует задание
    public static void editTask () {
        System.out.println("\u001B[32mВыберете номер задачи,которую хотите отредактировать:\u001B[0m");
        showAll(); //редактирование также производится по номеру задачи, он вводится с консоли
        try {
            if (!listOfTasks.isEmpty()) { //если список с заданиями непустой, то выбираем, что именно мы хотим отредактировать(описание,название,статус,дату выполнения)
                Scanner input_id = new Scanner(System.in);
                int id = input_id.nextInt();
                for (Task i : listOfTasks) { //проверка того, что введеное число есть в списке(т.е существует задача с таким номером)
                    if (i.getId() == id) {
                        System.out.println("Выберете, что Вам необходимо отредактировать: \n 1 - описание \n 2 - название \n 3 - статус \n 4 - дату выполнения");
                        Scanner edit = new Scanner(System.in);
                        int edition = edit.nextInt();

                        ArrayList<Task> tasks = new ArrayList<>(); // в этот список добавим задачу, которую необходимо будет отредактировать
                        for (Task t : listOfTasks) {
                            if (t.getId() == id) { //редактирование производится по номеру,если номер совпадает с заданным,то добавляем его в список
                                tasks.add(t);
                            }
                        }
                        Task task = tasks.get(0);


                        if (edition == 1) {
                            System.out.println("Введите новое описание: "); //вводим новое описание(с консоли)
                            Scanner input_info = new Scanner(System.in);
                            String newInfo = input_info.nextLine();
                            task.setInfo(newInfo); //обновляем описание
                            System.out.println("\u001B[32mДополнительная информация успешно обновлена!\u001B[0m");


                        } else if (edition == 2) {
                            System.out.println("Введите новое название: "); //вводим новое название(с консоли)
                            Scanner input_name = new Scanner(System.in);
                            String newName = input_name.nextLine();
                            if (task.getName().equalsIgnoreCase(newName)) { //проверяем совпадает ли новое название с текущем,если совпадает,то ничего не меняем
                                System.out.println("Новое название совпадает с текущем");
                            }
                            task.setName(newName); //в ином случае,вызываем метод и обновляем название
                            System.out.println("\u001B[32mНазвание успешно обновлено!\u001B[0m");


                        } else if (edition == 3) {
                            //даем выбор хотим изменить статус или нет(выбираем один из вариантов)
                            System.out.println("\u001B[32mТекущий статус: \u001B[0m" + task.getStatus() + "\nХотите его изменить? \n1 - да \n2 - нет");
                            Scanner input = new Scanner(System.in);
                            try {
                                int num = input.nextInt();
                                if (num == 1 & task.getStatus().equalsIgnoreCase("Не выполнено")) { //если ответ "да", то меняем статус на противоположный
                                    task.setStatus("Сделано");
                                    System.out.println("\u001B[32mСтатус успешно обновлен!\u001B[0m");


                                } else if (num == 1 & task.getStatus().equalsIgnoreCase("Сделано")) { //если ответ отрицательный, то статус остается прежним
                                    task.setStatus("Не выполено");
                                    System.out.println("\u001B[32mСтатус успешно обновлен!\u001B[0m");
                                } else {
                                    System.out.println("Статус не изменен"); //в ином случае выводим, что статус не изменен
                                }
                            } catch (Exception e) {
                                System.out.println("Вероятно, Вы ввели некорректые данные");
                            }


                        } else if (edition == 4) {
                            System.out.println("Введите новую дату выполнения: ");
                            Scanner input_date = new Scanner(System.in);
                            String date = input_date.nextLine();


                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
                            LocalDate newDate = LocalDate.parse(date, formatter);
                            LocalDate oldDate = LocalDate.parse(task.getFormattedDate(), formatter);
                            if (newDate.isAfter(oldDate)) {
                                task.setDate(date);
                                System.out.println("\u001B[32mДата успешно обновлена!\u001B[0m");
                            } else if (oldDate.getDayOfMonth() == newDate.getDayOfMonth() & oldDate.getMonth() == newDate.getMonth() & oldDate.getYear() == newDate.getYear()) {
                                task.setDate(date);
                                System.out.println("\u001B[32mДата успешно обновлена!\u001B[0m");


                            } else {
                                System.out.println("Вы не можете установить дату,которая раньше текущей");
                            }

                        } else {
                            System.out.println("Некорректный ввод!");
                        }
                    } else {
                        System.out.println("Задачи с таким номером нет"); //если задания с введеным числом нет, то выводится сообщение об этом
                    }
                }

            }else {
                System.out.println("У вас нет созданных заданий");
            }
        }catch (Exception e){
            System.out.println("Некорректный ввод данных");
        }
    }

    //метод, который отображает все задания
    public static void showAll(){
        if(!listOfTasks.isEmpty()){ //если список непустой, то проходимся по списку и берем значения,затем выводим их
            System.out.println("Список всех заданий:");
            for (Task t : listOfTasks) {
                int id = t.getId();
                String cd = t.getFormattedDate();
                String endDate = t.getEndDate();
                String name = t.getName();
                String info = t.getInformation();
                String status = t.getStatus();
                System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" +"Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                System.out.println(" ");
            }
        }else{ //если же заданий в списке нет, то выведется сообщение об этои
            System.out.println("У Вас нет созданных заданий");
        }
    }

    //метод, который отображает все задания по дате их создания
    public static void showAllCreateDate(){
        //в целом алгоритм тот же самый,что и в предыдущем методе, но тут мы вводим дату с консоли(она типа String)
        System.out.println("Введите дату(в формате dd-mon-yyyy), по которой хотите посмотреть задачи:");
        Scanner input_CD = new Scanner(System.in);
        String cd = input_CD.nextLine();

        //но так как переменная,которая отвечает за дату создания имеет тип LocalDate, необходимо конвертировать строку в тип данных LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date = LocalDate.parse(cd, formatter);

        if (!listOfTasks.isEmpty()){
            for(Task t:listOfTasks){//проходимя по списку и если заданная дата совпадает с датой в списке,то выводим информацию об этой задаче
                if(date.equals(t.getCreateDate())){
                    int id = t.getId();                         //дальше аналогично , как и в прошлом методе
                    String cD = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cD + "\n" + "Дата выполнения: " + endDate + "\n" +"Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("У вас нет созданных заданий");
        }
    }

    //метод, который выводит все задания по дате выполнения
    public static void showAllEndDate(){
        //вводим дату с консоли
        System.out.println("Введите дату(в формате dd-mon-yyyy), по которой хотите посмотреть задачи:");
        Scanner input_ED = new Scanner(System.in);
        String date = input_ED.nextLine();

        if(!listOfTasks.isEmpty()){ //проверяем, что список не пустой
            for (Task t : listOfTasks) {
                if(t.getEndDate().equals(date)){ //если дата,которую ввели с консоли, совпадает с датой в списке, то выводим информацию
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" +"Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("У Вас нет созданных заданий");
        }
    }

    //метод, который выводит список ВСЕХ сделанных заданий
    public static void doneTasks () {
        if (!listOfTasks.isEmpty()){ //проверка на то, что в списке есть данные
            System.out.println("\u001B[32mСписок выполненных задач:\u001B[0m");
            for (Task t : listOfTasks) {
                if (t.getStatus().equals("Сделано") || t.getStatus().equals("сделано") ) { //проверяем статус у задания,если задание сделано,то выводим информацию
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" + "Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("У вас нет созданных заданий"); //если список пустой, то выводим сообщение об этом
        }

    }

    //метод, который выводит список сделанных задач по дате создания
    public static void doneTasksCreateDate(){
        //вводим дату,по которой мы хотим посмотреть, с консоли
        System.out.println("Введите дату(в формате dd-mon-yyyy), по которой хотите посмотреть задачи:");
        Scanner input_CD = new Scanner(System.in);
        String dateEnd = input_CD.nextLine();

        //затем форматируем строку в формат yyyy-mon-dd,чтобы сравнить введеную дату с той,которая уже установлена
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date = LocalDate.parse(dateEnd, formatter);


        if(!listOfTasks.isEmpty()){//проверяем, что список непустой
            System.out.println("\u001B[32mСписок выполненных задач по дате создания:\u001B[0m");

            for (Task t : listOfTasks) {
                if(t.getCreateDate().equals(date) & t.getStatus().equalsIgnoreCase("сделано")){ //проверяем все условия: 1 - введеная дата совпадает с датой в списке
                    //и 2 - статус задания говорит о том, что задание уже сделано
                    //если условия выполнены, то выводим задания
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" +"Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("У Вас нет созданных заданий"); //если список пустой,то сообщаем об этом
        }
    }

    //метод, который выводит список сделанных задач по дате выполнения
    public static void doneTasksEndDate(){
        //вводим строку с консоли, она будет типа String, он походит
        System.out.println("Введите дату(в формате dd-mon-yyyy), по которой хотите посмотреть задания:");
        Scanner input_ED = new Scanner(System.in);
        String date = input_ED.nextLine();

        if(!listOfTasks.isEmpty()){
            System.out.println("\u001B[32mСписок выполненных задач по дате выполнения:\u001B[0m");
            for (Task t : listOfTasks) {
                if(t.getEndDate().equals(date) & t.getStatus().equalsIgnoreCase("сделано")){ // если выполняются условия:1-даты(введеная и та,что в списке) совпадают
                    // и 2 - задание выполнено,то выводим эти задачи
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" +"Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("У Вас нет созданных заданий"); //если список пустой,то выводим сообщение
        }
    }

    //метод, который выводит ВСЕ несделанные задания
    public static void uncompletedTasks() { //	Просмотреть список НЕВЫПОЛНЕННЫХ заданий
        if (!listOfTasks.isEmpty()){
            System.out.println("\u001B[32mСписок несделанных задач:\u001B[0m");
            for (Task t : listOfTasks) { //проходимся по элементам списка
                if (t.getStatus().equals("Не выполнено") || t.getStatus().equals("не выполнено") ) { //проверяем то, что задание невыполнено и если условие выполняется,
                    //то выводим информацию о задании
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" + "Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");

                }
            }
        }else{
            System.out.println("У вас нет созданных заданий"); //ну и если список пуст, то выводим собщение
        }
    }

    //метод, который выводит ВСЕ несделанные задания по дате создания
    public static void uncompletedTasksCreateDate(){
        //вводим дату с консоли,а затем конвертируем ее в необходимый формат для сравнения
        System.out.println("Введите дату(в формате dd-mon-yyyy), по которой хотите посмотреть задачи:");
        Scanner input_CD = new Scanner(System.in);
        String dateCreate = input_CD.nextLine();

        //конвертируем дату в формат yyyy-mon-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date = LocalDate.parse(dateCreate, formatter);

        if(!listOfTasks.isEmpty()){
            System.out.println("\u001B[32mСписок несделанных задач по дате создания:\u001B[0m");
            for (Task t : listOfTasks) {
                if (t.getStatus().equals("Не выполнено") || t.getStatus().equals("не выполнено") & date.equals(t.getCreateDate()) ) {//проверяем все условия: 1 - введеная дата совпадает с датой в списке
                    //и 2 - статус задания говорит о том, что задание не сделано
                    //если условия выполнены, то выводим задания
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" + "Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");

                }
            }
        }else{
            System.out.println("У вас нет созданных заданий");
        }

    }

    //метод, который выводит ВСЕ несделанные задания по дате выполнения
    public static void uncompletedTasksEndDate(){
        //вводим дату,по которой хотим посмотреть задачи
        System.out.println("Введите дату(в формате dd-mon-yyyy),по которой хотите посмотреть задания:");
        Scanner input_ED = new Scanner(System.in);
        String date = input_ED.nextLine();

        if (!listOfTasks.isEmpty()){
            System.out.println("\u001B[32mСписок несделанных задач по дате выполнения:\u001B[0m");
            for (Task t : listOfTasks) {
                if (t.getStatus().equals("Не выполнено") & t.getEndDate().equals(date)) { // если выполняются условия:1-даты(введеная и та,что в списке) совпадают
                    // и 2 - задание не выполнено,то выводим эти задачи
                    int id = t.getId();
                    String cd = t.getFormattedDate();
                    String endDate = t.getEndDate();
                    String name = t.getName();
                    String info = t.getInformation();
                    String status = t.getStatus();
                    System.out.println("Номер задачи: " + id + "\n" + "Дата создания: " + cd + "\n" + "Дата выполнения: " + endDate + "\n" + "Наименование: " + name + "\n" + "Детальное описание: " + info + "\n" + "Статус: " + status);
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("У вас нет созданных заданий");
        }
    }

    //метод, который выводит детальное описание
    public static void showInfrornation(){
        //чтобы посмотреть детальное описание, необходимо ввести номер заачи
        showAll();
        System.out.println("Введите номер задачи,чтобы узнать детальную информацию о задании:");
        try {
            //вводим номер задачи
            Scanner input_id = new Scanner(System.in);
            int id = input_id.nextInt();

            for (int i = 0; i < listOfTasks.size(); i++) {
                Task t = listOfTasks.get(i);
                if (t.getId() == id) { //если номера совпадают, то выводим детальное описание
                    i += 1;
                    System.out.println("Детальное описание задания '" + t.getName() + "':\n" + t.getInformation());
                }
            }
        }catch (Exception e){
            System.out.println("Некорректный ввод!");
        }

    }
}



