import java.util.Arrays;
import java.util.Scanner;

public class MainExample {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] numbersArray = {4, 9, 1, 12, 7, 8, 10, 1, 3, 15, 14, 19};
        boolean isFindTarget = false;

        outerLoop:
        for (int i = 0; i < numbersArray.length; i++) {
            for (int j = numbersArray.length - 1; j >= 0; j--) {
                if (i != j && numbersArray[i] + numbersArray[j] == target) {
                    isFindTarget = true;
                    int[] result = {i, j};
                    System.out.println("Индексы чисел: " + Arrays.toString(result));
                    break outerLoop;
                }
            }
        }
        if (!isFindTarget) {
            System.out.println("Не найдены числа");
        }
        scanner.close();


        /*2. Максимальная сумма подмассива
Условие: Найдите непрерывный подмассив с наибольшей суммой.
Пример: [-2,1,-3,4,-1,2,1,-5,4] → 6 (подмассив [4,-1,2,1])*/

        int[] wholeArray = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = wholeArray[0];
        int currentSum = wholeArray[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        for (int i = 1; i < wholeArray.length; i++) {
            if (wholeArray[i] > currentSum + wholeArray[i]) {
                currentSum = wholeArray[i];
                tempStart = i;
            } else {
                currentSum += wholeArray[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Максимальная сумма: " + maxSum);
        System.out.print("Подмассив: ");
        for (int i = start; i <= end; i++) {
            System.out.print(wholeArray[i]);
            if (i < end) System.out.print(", ");
        }
    }
}
