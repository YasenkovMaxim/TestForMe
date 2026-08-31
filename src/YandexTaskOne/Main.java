package YandexTaskOne;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countObstacles = scanner.nextInt();

        int[] coordinatesObstacles = new int[countObstacles];
        for (int i = 0; i < coordinatesObstacles.length; i++) {
            int input = scanner.nextInt();
            if (i != 0 && coordinatesObstacles[i - 1] >= input) {
                System.out.println("Неверный ввод");
                i--;
            } else {
                coordinatesObstacles[i] = input;
            }
        }
        System.out.println(Arrays.toString(coordinatesObstacles));

        int[] obstacles = new int[countObstacles];
        for (int i = 0; i < obstacles.length; i++) {
            int input = scanner.nextInt();
            if (input != 1 && input != 2 && input != 3) {
                System.out.println("Неверный ввод");
                i--;
            } else {
                obstacles[i] = input;
            }
        }
        System.out.println(Arrays.toString(obstacles));

        int countJump = scanner.nextInt();

        int[] coordinatesJumps = new int[countJump];
        for (int i = 0; i < coordinatesJumps.length; i++) {
            int input = scanner.nextInt();
            if (i != 0 && coordinatesJumps[i - 1] >= input) {
                System.out.println("Неверный ввод");
                i--;
            } else {
                coordinatesJumps[i] = input;
            }
        }
        System.out.println(Arrays.toString(coordinatesJumps));

        int[] jumpingRange = new int[countJump];
        for (int i = 0; i < jumpingRange.length; i++) {
            int input = scanner.nextInt();
            if (input != 1 && input != 2 && input != 4) {
                System.out.println("Неверный ввод");
                i--;
            } else {
                jumpingRange[i] = input;
            }
        }
    }
}
