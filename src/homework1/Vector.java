package homework1;

import java.util.Arrays;

public class Vector {
    double x, y, z;

    public Vector(double x, double y, double z) {
        // конструктор векторов(x,y,z) с координатами;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
//        Vector vect1 = new Vector(4, 5, 2);
//        Vector vect2 = new Vector(4, 3, 1);
//        vect1.lengthOfVector();
//        vect2.lengthOfVector();
//        vect1.scalarnoeProizvedenie(vect2);
//        vect1.multiplicationOfVectors(vect2);
//        angleBetweenVectors(vect1,vect2);
//        vect1.summa(vect2);
//        vect2.substraction(vect1);
//        generate(3);
    }

    //метод, вычисляющий длину вектора
    public double lengthOfVector() {
        double lenght = Math.sqrt(x * x + y * y + z * z);
        System.out.println("Длина вектора: " + lenght);
        return lenght;
    }

    //метод, вычисляющий скалярное произведение
    public double scalarnoeProizvedenie(Vector vect2) {
        double scalarnoe = x * vect2.x + y * vect2.y + z * vect2.z;
        System.out.println("Скалярное произведение: " + scalarnoe);
        return scalarnoe;
    }

    //метод для внутреннего пользования
    public static double scalarnoe(Vector vect1, Vector vect2) {
        return vect1.x * vect2.x + vect1.y * vect2.y + vect1.z * vect2.z;
    }
    //метод для внутреннего пользования
    public double lenVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    //метод, вычисляющий векторное произведение с другим вектором
    public void multiplicationOfVectors(Vector vect2) {
        double numX = this.y * vect2.z - this.z * vect2.y;
        double numY = this.z * vect2.x - this.x * vect2.z;
        double numZ = this.x * vect2.y - this.y * vect2.x;
        System.out.println("Векторное произведение с другим вектором" + "(" + numX + ", " + numY + ", " + numZ + ")");
    }

    //метод, вычисляющий угол между векторами
    public static double angleBetweenVectors(Vector vect1, Vector vect2) {
        //double angle = (x * vect2.x + y * vect2.y + z * vect2.z) / (Math.sqrt(x * x + y * y + z * z) * Math.sqrt(vect2.x * vect2.x + vect2.y * vect2.y + vect2.z * vect2.z));
        double angle = scalarnoe(vect1, vect2) / (vect1.lenVector() * vect2.lenVector());
        System.out.println("Угол между векторами:" + angle);
        return angle;
    }

    //метод для суммы
    public void summa(Vector vect2) {
        int numX = (int) (x + vect2.x);
        int numY = (int) (y + vect2.y);
        int numZ = (int) (z + vect2.z);
        System.out.println("Сумма векторов:" + "(" + numX + ", " + numY + ", " + numZ + ")");
    }

    //метод для разности
    public void substraction(Vector vect2) {
        int numX = (int) (x - vect2.x);
        int numY = (int) (y - vect2.y);
        int numZ = (int) (z - vect2.z);
        System.out.println("Разность векторов:" + "(" + numX + ", " + numY + ", " + numZ + ")");
    }

    //статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N
    public static Vector[] generate(int number) {
        Vector[] vectors = new Vector[number];
        for (int i = 0; i < number; i++) {
            vectors[i] = new Vector((-50) + (int) (Math.random() * 50),
                    (-50) + (int) (Math.random() * 50), (-50) + (int) (Math.random() * 50));
        }
        System.out.println(Arrays.deepToString(vectors));
        return vectors;
    }

}



