package TasksTest.eight;

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
        for (int i = 0; i > -1; i++) {
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
    }
}
