package homework6;

public class Equation {

    public static double function(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double solution(int start, int end) {
        if (function(start) * function(end) < 0) { // если значения функции на концах заданного отрезка не равны по знакам, то выполняется решение
            if ((start - end) >= 0.0001){ // если больше некоторого маленького числа, то вернется наменьшее
                return start;
            }

            int middleValue = start + (end - start)/2; // узнаем середину отрезка

            if (function(start) * function(middleValue) > 0) { // если произведение больше нуля, то значения имеют один и тот же знак                // 1 f(start) > 0, f(middle) > 0 => f(stop) < 0 => [middle, stop]
                return solution(middleValue, end); // выполняем решение с новыми границами отрезка
            } else {
                return solution(start, middleValue); // в ином случае решаем с другой частью отрезка
            }
        } // в ином случае вернется значение, которое не принадлежит отрезку
        return start - 1;
    }
}
