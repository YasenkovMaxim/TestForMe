import java.util.Scanner;

public class LessonTwo {
    public static void lessonTwo() {
       /* Задача 1:
        Напишите программу, которая будет принимать на вход число из консоли и на выход
        будет выводить сообщение четное число или нет. Для определения четности числа
        используйте операцию получения остатка от деления (операция выглядит так: '% 2'). */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int numberScanner = scanner.nextInt();
        if (numberScanner % 2 == 0) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число нечетное");
        }

       /* Задача 2:
        Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
        Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold» */

        System.out.println("Введите температуру");
        int temperature = scanner.nextInt();
        if (temperature > -5) {
            System.out.println("Warm");
        } else if (temperature <= -5 && temperature > -20) {
            System.out.println("Normal");
        } else {
            System.out.println("Cold");
        }

        /* Задача 3:
        Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно. */
        int numberInQuarter;
        for (int i = 10; i <= 20; i++) {
            numberInQuarter = (int) Math.pow(i, 2);
            System.out.print(numberInQuarter + " ");
        }
        System.out.println();

       /* Задача 4:
        Необходимо, чтоб программа выводила на экран вот такую последовательность:
        7 14 21 28 35 42 49 56 63 70 77 84 91 98. В решении используйте цикл while*/

        int forTaskFour = 7;
        while (forTaskFour <= 98) {
            System.out.print(forTaskFour + " ");
            forTaskFour += 7;
        }


       /* Задача *:
        Напишите программу, где пользователь вводит любое целое положительное число. А
        программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
        числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
        ввести некорректные данные */
        System.out.println("\nВведите любое положительно число");
        int forTaskFive = scanner.nextInt();
        if (forTaskFive <= 0) {
            System.out.println("Некоректное число");
        } else {
            int sum = 0;
            for (int i = 0; i <= forTaskFive; i++) {
                sum += i;
            }
            System.out.println("Сумма чисел = " + sum);
        }
        scanner.close();
    }
}


