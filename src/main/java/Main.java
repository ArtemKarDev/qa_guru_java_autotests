
public class Main {

    public static void main(String[] args) {

        // 0) прочитать про диапазоны типов данных для вещественных чисел с плавающей точкой
        System.out.println("Числа с плавающей точкой (иначе вещественные) — float, double.");
        System.out.println("Диапозон float: от 1.4e-45f до 3.4e+38f");
        System.out.println("Диапозон double: от 4.9e-324 до 1.7e+308");

        // 1) поупражняться с математическими и логическими операторами, добиться переполнения при вычислениях, посмотреть результаты (вывести в консоль)
        System.out.println("Арифметические операторы. Применяются для простых вычислений: сложения, деления, умножения.");
        int x = 2;
        int y = 2;
        System.out.println(x+y + " / "+ x*y +" = " + x/y);
        System.out.println("Операторы сравнения. Сравнивают две величины между собой, получая булевые значения: true или false.");
        System.out.println(x == y);
        System.out.println(x > ++y);
        System.out.println(x < y);
        System.out.println("Логические операторы. Работают с булевыми значениями true или false.");
        boolean tr = true;
        boolean fl = false;
        System.out.println(!tr == fl);
        System.out.println(tr && fl);
        System.out.println(fl || tr);

        System.out.println("Переполнение");
        short littleNumber = 1;
        littleNumber += 32767;
        System.out.println(littleNumber);

        byte b1 = 70, b2 = 70;
        // byte sum = b1 + b2;   // error: incompatible types: possible lossy conversion from int to byte
        System.out.println(b1 + b2);
        System.out.println(b1 * b2);

        //  2) попробовать вычисления комбинаций типов данных (int и double)
        int iNum = 100;
        double dNum = 0.1;
        System.out.println(iNum + dNum + " " + (iNum - dNum) + " " + iNum * dNum + " " +  iNum / dNum);
        System.out.println(dNum + iNum + " " + (dNum - iNum) + " " + dNum * iNum + " " +  dNum / iNum);

    }

}