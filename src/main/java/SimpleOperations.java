package guru.qa;

public class Main {

    public static void main(String[] args) {

//        0) прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой
//
//        1) поупражняться с математическими и логическими операторами, добиться переполнения при вычислениях, посмотреть результаты (вывести в консоль)
//
//        2) попробовать вычисления комбинаций типов данных (int и double)


        byte b1 = 100;
        byte b2 = 40;
        // byte sum = b1 + b2;    ошибка
        System.out.println(b1 + b2); // сумма вычисляется
        System.out.println(b1 * b2);

        int byteToInt1 = b1;
        int byteToInt2 = b2;
        int sum = byteToInt1 + byteToInt2;
        System.out.println(sum);

        short s1 = 30000;
        short s2 = 5000;
        short s3 = -15677;

        short multipleShort = (short) (s1 * s2);   //результат -11904
        System.out.println(multipleShort);
        short divShort = (short) (s1 / s2);
        System.out.println(divShort);
        System.out.println(s3 + s1 * 5);

        boolean aBool = true;
        boolean bBool = false;
        System.out.println(!aBool);
        System.out.println(aBool == bBool);
        System.out.println(aBool && bBool);
        System.out.println(aBool || bBool);

        if(5 >= 6){
            System.out.println(aBool);
        } else {
            System.out.println(bBool);
        }


        // вычисления разных типов данных
        double d1 = 0.001;
        int i1 = 40;
        System.out.print((d1 + i1) + "\n" +
                (d1 - i1) + "\n" +
                (d1 * i1) + "\n" +
                (d1 / i1) + "\n");

        System.out.println(d1 % 10);
        System.out.println(i1 % 10);

    }


        System.out.println(msg);
    }





}