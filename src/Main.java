

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Напишите номер занятия, в котором хотите увидеть результаты задач");
        Scanner scanner = new Scanner(System.in);
        int numberScanner = scanner.nextInt();
        switch (numberScanner) {
            case 1 -> LessonOne.lessonOne();
            case 2 -> LessonTwo.lessonTwo();
            case 3 -> LessonThree.lessonThree();
            case 5 -> LessonFive.lessonFive();
            default -> System.out.println("Такого занятия нет");
        }
        System.out.println();
    }
}