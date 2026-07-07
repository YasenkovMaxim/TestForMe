import java.util.Scanner;

public class LessonFive {

    public static void lessonFive() {
            /*Задача 1:
            1.1 Создать двумерный массив, заполнить его случайными числами.
            1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
            1.3 Найти сумму всех получившихся элементов и вывести в консоль. */

        int[][] array = new int[6][10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для прибавления к каждому числу в массиве");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
                sum = array[i][j] + num + sum;
            }
            System.out.println();
        }
        System.out.println("результат: " + sum);

        /*Задача 2:
        Создать программу для раскраски шахматной доски с помощью цикла. Создать
        двумерный массив String 8х8. С помощью циклов задать элементам массива значения
        B(Black) или W(White). При выводе результат работы программы должен быть
        следующим:
        W B W B W B W B
        B W B W B W B W
        W B W B W B W B
        B W B W B W B W
        W B W B W B W B
        B W B W B W B W
        W B W B W B W B
        B W B W B W B W*/

        String[][] stringChest = new String[8][8];
        String B = "B";
        String W = "W";
        for (int i = 0; i < stringChest.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < stringChest[i].length; j++) {
                    stringChest[i][j] = W;
                    if (j % 2 != 0) {
                        stringChest[i][j] = B;
                    }
                    System.out.print(stringChest[i][j] + " ");
                }

            } else {
                for (int j = 0; j < stringChest[i].length; j++) {
                    stringChest[i][j] = W;
                    if (j % 2 == 0) {
                        stringChest[i][j] = B;
                    }
                    System.out.print(stringChest[i][j] + " ");
                }
            }

            System.out.println();
        }
    }
}
