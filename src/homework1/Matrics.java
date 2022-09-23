package homework1;
import java.util.Arrays;

public class Matrics {
    int rows;
    int coloumns;
    int[][] matrics;

    public Matrics(int[][] matrics) {
        //конструктор матрицы
        this.matrics = matrics;
        this.rows = matrics.length; //строки
        this.coloumns = matrics[0].length; //столбцы
    }

    public static void main(String[] args){
        Matrics matrics = new Matrics(new int[][] {{1,2,4},{3,4,5}});
        Matrics matrics1 = new Matrics(new int[][] {{3,4},{1,2}});
//        matrics.Summa(matrics1);
//        Matrics matrics = new Matrics(new int[][] {{1, 2}, {3,4}});
//        Matrics matrics2 = new Matrics(new int[][] {{1, 1}, {1,1}});
//        matrics.printMatrix();
//        System.out.println();
//        matrics1.printMatrix();
//        System.out.println();
//        matrics.Summa(matrics1);
//        matrics1.Transposition();
//        matrics.Substraction(matrics1);
//        matrics1.MultiplicationOnNumber(2);
//        matrics.MultiplyMatrics(matrics1);
//        exponentiation(matrics,2);
    }

    //функция,которая выводит матрицу
    public void printMatrix() {
        for (int row = 0; row < matrics.length; row++) { //цикл по массиву строк
            for (int colomn = 0; colomn < matrics[row].length; colomn++) { //цикл по массиву столбцов
                System.out.print(matrics[row][colomn]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    //функция сложения матриц
    public Matrics Summa(Matrics matrics2) {
        Matrics new_matrics = new Matrics(new int[matrics.length][matrics[0].length]); //матрица куда записывается результат сложения матриц
        try {
            for (int row = 0; row < this.rows; row++) { //цикл по массиву строк
                for (int colom = 0; colom < this.coloumns; colom++) {  //цикл по массиву столбцов
                    new_matrics.matrics[row][colom] = this.matrics[row][colom] + matrics2.matrics[row][colom]; //складываем элементы первой и второй матрицы
                }
            }
            System.out.println("Результат сложения матриц:");
            new_matrics.printMatrix();
            return new_matrics;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Ошибка!");
            return this;
        }
    }


    //функция вычитания матриц
    public Matrics Substraction(Matrics matrics2) {
        Matrics new_matrics = new Matrics(new int[matrics.length][matrics[0].length]); //матрица с результатом
        try {
            for (int row = 0; row < this.rows; row++) { //цикл по строкам
                for (int colom = 0; colom < this.coloumns; colom++) { // цикл по столбцам
                    new_matrics.matrics[row][colom] = this.matrics[row][colom] - matrics2.matrics[row][colom]; //вычитаем элементы первой и второй матрицы
                }
            }
            System.out.println("Результат вычитания матриц:");
            new_matrics.printMatrix();
            return new_matrics;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Ошибка!");
            return this;
        }
    }


    //функция,которая транспонирует матрицу
    public Matrics Transposition() {
        try {
            Matrics new_matrics = new Matrics(new int[this.rows][this.coloumns]); //результат транспонированной матрицы
            for (int coloumn = 0; coloumn < matrics[0].length; coloumn++) { // цикл по столбцам
                for (int row = 0; row < matrics.length; row++) { // цикл по строкам
                    new_matrics.matrics[coloumn][row] = this.matrics[row][coloumn]; //меняем столбцы и строки меставми и присваиваем новые значения
                }
            }
            System.out.println("Транспонированная матрица:");
            new_matrics.printMatrix();
            return new_matrics;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Ошибка!");
        }
        return this;
    }


    //функция умножения матрицы на число
    public Matrics MultiplicationOnNumber(int number) {
        Matrics new_matrics = new Matrics(new int[matrics.length][matrics[0].length]); //результат
        for (int row = 0; row < this.rows; row++) { //цикл по строкам
            for (int colom = 0; colom < this.coloumns; colom++) { //цикл по столбцам
                new_matrics.matrics[row][colom] = this.matrics[row][colom] * number; // умножаем элементы матрицы на число
            }
        }
        System.out.println("Результат умножения на " + number + ":");
        new_matrics.printMatrix();
        return new_matrics;
    }


    // умножение матриц
    public Matrics MultiplyMatrics(Matrics matrics2) {
        if (this.coloumns == matrics2.matrics.length){    //проверка на то,что количество столбцов первой матрицы равно количеству строк второй матрицы
            Matrics new_matrics = new Matrics(new int[matrics.length][matrics[0].length]);    // результат умножения матриц
            for(int row=0;row<this.rows;row++){   // цикл по строкам
                for(int coloumn=0;coloumn<this.coloumns;coloumn++){   // цикл по столбцам
                    for (int rows = 0; rows < matrics2.matrics.length; rows++){   //еще один цикл по строкам второй матрицы для умножения
                        new_matrics.matrics[row][coloumn]+= matrics[rows][row]*matrics2.matrics[rows][coloumn];   //умножаем столбцы первой матрицы на строки второй и складываем
                    }
                }
            }
            System.out.println("Результат умножения матриц:");
            new_matrics.printMatrix();
            return new_matrics;
        }
        else{
            System.out.println("Эти матрицы нельзя перемножить.");
        }
        return this;
    }

    // функция умножения матриц для внутреннего пользования
    public Matrics MultMatrics(Matrics matrics2) {
        if (this.coloumns == matrics2.matrics.length){
            Matrics new_matrics = new Matrics(new int[this.rows][this.coloumns]);
            for(int row=0;row<this.rows;row++){
                for(int coloumn=0;coloumn<this.coloumns;coloumn++){
                    for (int rows = 0; rows < this.rows; rows++){
                        new_matrics.matrics[row][coloumn]+= matrics[row][rows]*matrics2.matrics[rows][coloumn];
                    }
                }
            }
            return new_matrics;
        }
        else{
            System.out.println("Эту матрицу нельзя возвести в степень.");
        }
        return this;
    }

    // функция возведения матрицы в степень
    public static void exponentiation(Matrics matrics, int number){
        Matrics new_matrics = matrics;
        int num=1; // счетчик степени
        while(num < number){ // пока выполняется это условие умножать матрицу number-раз саму на себя
            new_matrics=new_matrics.MultMatrics(matrics);
            num+=1;
        }
        if(new_matrics!=matrics){//если матрица изменилась,то вывести результат
            System.out.println("Результат возведения матрицы в степень " + number + ":");
            new_matrics.printMatrix(); // результат
        }
        else{
            System.out.println();
        }
    }

}
