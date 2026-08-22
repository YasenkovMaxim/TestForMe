package TasksTest;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     /*  Scanner scanner = new Scanner(System.in);
        System.out.println("Введите перво число: ");
        int first = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int second = scanner.nextInt();
        int sum = first + second;
        System.out.println("Сумма: " + sum);
        int rest = first - second;
        System.out.println("Разность: " + rest);
        int multiplication = first * second;
        System.out.println("Умножение: " + multiplication);
        if (second == 0) {
            System.out.println("Делить на ноль невозможно!");
        } else {
            double division = (double) first / second;
            System.out.println("Деление: " + division);
            int modification = first % second;
            System.out.println("Остаток от деления: " + modification);
        }
        scanner.close();*/

        int[] array = new int[10];
        Random random = new Random();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(101) - 50;
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
            sum = sum + array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.print("\nИндексы всех положительных чисел: ");
        for (int i = 0; i < 10; i++) {
            if (array[i] > 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nМинимальное число в массиве: " + min);
        System.out.println("Максимальное число в массиве: " + max);
        System.out.println("Среднее ариметическое: " + sum / array.length);

        int[][] array2 = new int[3][3];
        int value = 1;
        int sum2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = value++;
                System.out.print(array2[i][j] + " ");
                if (i == j) {
                    sum2 += array2[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("Сумма элементов на главной диагонали: " + sum2);
    }
}
