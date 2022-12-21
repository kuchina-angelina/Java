package project;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        while (true){ //бесконечный цикл
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("\u001B[32mВыберете действие:\u001B[0m\nСоздать задание - 1 \nУдалить задание - 2 \nОтредактировать задание - 3 \nПосмотреть список ВСЕХ заданий - 4 \nПосмотреть список ВЫПОЛНЕННЫХ заданий - 5 \nПосмотреть список НЕВЫПОЛНЕННЫХ заданий - 6 \nПосмотреть детальное описание задачи - 7 \nСтоп - 8");
//                Scanner input = new Scanner(System.in);
                //вводим номер функции,которую хотим выполнить
                //в зависимости от того,что выбрали вызывается необходимый метод
                int action = input.nextInt();
                if(action == 1){
                    Planner.createTask();

                }else if (action == 2){
                    Planner.deleteTask();

                }else if (action == 3){
                    Planner.editTask();
//                    System.out.println("\u001B[32mЗадание успешно отредактировано!\u001B[0m");

                }else if (action == 4){
                    System.out.println("\u001B[32mЧто Вам необходимо?\u001B[0m \nСписок ВСЕХ заданий - 1 \nСписок ВСЕХ заданий по дате создания - 2 \nСписок ВСЕХ заданий по дате выполнения - 3 ");
                    try{
                        int option = input.nextInt();
                        if(option == 1){
                            Planner.showAll();

                        }else if(option == 2){
                            Planner.showAllCreateDate();

                        }else if(option == 3){
                            Planner.showAllEndDate();

                        }
                    }catch (Exception e){
                        System.out.println("Вероятно, Вы ввели неккоректный формат данных.\nПопробуйте ещё раз");
                    }

                }else if (action == 5){
                    System.out.println("\u001B[32mЧто Вам необходимо?\u001B[0m \nСписок ВСЕХ выполненных заданий - 1 \nСписок ВСЕХ выполненных заданий по дате создания - 2 \nСписок ВСЕХ выполненных заданий по дате выполнения - 3 ");
                    try{
                        int option = input.nextInt();
                        if(option == 1){
                            Planner.doneTasks();



                        }else if(option == 2){
                            Planner.doneTasksCreateDate();


                        }else if(option == 3){
                            Planner.doneTasksEndDate();

                        }
                    }catch (Exception e){
                        System.out.println("\u001B[32mВероятно, Вы ввели неккоректный формат данных.\nПопробуйте ещё раз\u001B[0m");
                    }


                }else if (action == 6){
                    System.out.println("\u001B[32mЧто Вам необходимо?\u001B[0m \nСписок ВСЕХ невыполненных заданий - 1 \nСписок ВСЕХ невыполненных заданий по дате создания - 2 \nСписок ВСЕХ невыполненных заданий по дате выполнения - 3 ");
                    try{
                        int option = input.nextInt();
                        if(option == 1){
                            Planner.uncompletedTasks();


                        }else if(option == 2){
                            Planner.uncompletedTasksCreateDate();


                        }else if(option == 3){
                            Planner.uncompletedTasksEndDate();

                        }
                    }catch (Exception e){
                        System.out.println("\u001B[31mВероятно, Вы ввели неккоректный формат данных.\nПопробуйте ещё раз\u001B[0m\n");
                    }

                }else if (action == 7){
                    Planner.showInfrornation();
                }else if (action == 8){
                    break;
                }else{
                    System.out.println("\u001B[31mТакой функции нет\u001B[0m");
                }
            }catch (Exception e) {
                System.out.println("\u001B[31mВероятно, Вы ввели неккоректный формат данных.\nПопробуйте ещё раз\u001B[0m");
            }
        }
    }
}
