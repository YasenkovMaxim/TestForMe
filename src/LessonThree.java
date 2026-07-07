import java.util.Arrays;
import java.util.Scanner;

public class LessonThree {
    public static void lessonThree() {
      /*  Для всех задач исходные условия следующие: пользователь с клавиатуры вводит размер
        массива (просто целое число). После того, как размер массива задан, заполнить его
        одним из двух способов: используя Math.random(), или каждый элемент массива вводится
        пользователем вручную. Попробовать оба варианта. После заполнения массива
        данными, решить для него следующие задачи:
        Задача 1:
        Пройти по массиву, вывести все элементы в прямом и в обратном порядке.*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое, положительное число, это будет длинной массива");
        int arrayLine = scanner.nextInt();
        int[] array = new int[arrayLine];
        System.out.println("Если хотите сами установить значения внутри массива напишите 1, если нет напишите 0");
        int choice = scanner.nextInt();
        if (choice == 1) {
            for (int i = 0; i < arrayLine; i++) {
                array[i] = scanner.nextInt();
            }
        } else if (choice == 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

        /*Задача 2:
        Найти минимальный-максимальный элементы и вывести в консоль.
         Задача 3:
        Найти индексы минимального и максимального элементов и вывести в консоль.*/
        System.out.println();
        int min = array[0];
        int max = array[0];
        int indexForMin = 0;
        int indexForMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexForMin = i;
            }
            if (array[i] > max) {
                max = array[i];
                indexForMax = i;
            }
        }
        System.out.println("Минимальное число = " + min + ". Индекс этого числа: " + indexForMin);
        System.out.println("Максимальное число = " + max + ". Индекс этого числа: " + indexForMax);

        /*Задача 4:
        Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
        сообщение, что их нет */
        int countByZero = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                countByZero++;
            }
        }
        if (countByZero == 0) {
            System.out.println("Нулевых элементов нет");
        } else {
            System.out.println("Количество нулевых элементов: " + countByZero);
        }

       /* Задача 5:
        Пройти по массиву и поменять местами элементы первый и последний, второй и
        предпоследний и т.д*/
        System.out.println("Задача 5: ");
        for (int i = 0; i < array.length; i++) {
            if (i >= array.length / 2) {
                break;
            }
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

       /* Задача 6:
        Проверить, является ли массив возрастающей последовательностью (каждое следующее
        число больше предыдущего).*/

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println("Массив является возрстающей последовательностью");
                break;
            }
            if (array[i] <= array[i + 1]) {

            } else {
                System.out.println("Массив не является возрстающей последовательностью");
                break;
            }
        }

       /* Задача *:
        Имеется массив из неотрицательных чисел(любой). Представьте что массив
        представляет целое число (Например массив {1,2,3} -> 123, {9,9,9} -> 999). Задача
        добавить единицу к этому “числу” и на выходе получить исправленный массив. Массив не
        содержит нуля в начале, кроме самого числа 0.
        Пример:
        Input: [1,4,0,5,6,3]
        Output: [1,4,0,5,6,4]
        Input: [9,9,9]
        Output: [1,0,0,0]*/

        int[] arrayForTask = {9, 9, 9, 9, 9};
        for (int i = arrayForTask.length - 1; i >= 0; i--) {
            if (arrayForTask[i] == 9) {
                arrayForTask[i] = 0;
                if (i == 0) {
                    int[] newArray = new int[arrayForTask.length + 1];
                    newArray[0] = 1;
                    arrayForTask = newArray;
                }
            } else {
                arrayForTask[i] = arrayForTask[i] + 1;
                break;
            }
        }

        System.out.println("Результат: ");
        for (int i = 0; i < arrayForTask.length; i++) {
            System.out.print(arrayForTask[i] + " ");
        }
        scanner.close();
    }
}

