package TasksTest.eight;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Игра "Угадай число": Программа загадывает число, пользователь его угадывает, получая подсказки "больше/меньше".
        System.out.println("Я загадаю число от 1 до 20, а тебе нужно угадать какое, при каждом неверном ответе" +
                " буду говорить больше или меньше мое число");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(20) + 1;
        while (true) {
            int userNumber = scanner.nextInt();
            if (number == userNumber) {
                break;
            } else {
                if (userNumber > number) {
                    System.out.println("Мое число меньше");
                }
                if (userNumber < number) {
                    System.out.println("Мое число больше");
                }
            }
        }
        System.out.println("Поздраваляю вы угадали мое число: " + number);

        // Даны две строки. Нужно проверить, являются ли они анаграммами (состоят из одних и тех же букв в любом порядке).
        String s1 = "CAT";
        String s2 = "tac";
        String str1 = s1.replaceAll("\\s+", "").toLowerCase();
        String str2 = s2.replaceAll("\\s+", "").toLowerCase();

        if (str1.length() != str2.length()) {
            System.out.println("not anagramme");
        } else {
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            boolean result = Arrays.equals(arr1, arr2);
            if (result) {
                System.out.println("anagramme");
            } else {
                System.out.println("not anagramme");
            }
        }

        //Даны два отсортированных по возрастанию массива целых чисел. Нужно объединить их в один отсортированный массив.
        int[] arr1 = {1, 4, 7, 9, 10, 11, 17};
        int[] arr2 = {1, 4, 8, 10, 34, 71};
        int[] arrResult = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arrResult[i] = arr1[i];
        }
        for (int i = arr1.length; i < arrResult.length; i++) {
            arrResult[i] = arr2[i - arr1.length];
        }
        Arrays.sort(arrResult);
        System.out.println(Arrays.toString(arrResult));
    }
}

