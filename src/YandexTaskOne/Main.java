package YandexTaskOne;

import java.util.Scanner;

public class Main {
    static long[][] prize;
    static int n;
    static int totalPlayers;

    static long[] solve(int l, int r, int h) {
        if (h == 0) {
            return new long[]{0};
        }
        int mid = (l + r) / 2;
        long[] left = solve(l, mid, h - 1);
        long[] right = solve(mid, r, h - 1);
        int half = 1 << (h - 1);
        long[] result = new long[1 << h];
        long maxRightLoss = Long.MIN_VALUE;
        for (int j = 0; j < half; j++) {
            long val = right[j] + prize[mid + j][h - 1];
            if (val > maxRightLoss) maxRightLoss = val;
        }
        for (int i = 0; i < half; i++) {
            result[i] = left[i] + maxRightLoss;
        }
        long maxLeftLoss = Long.MIN_VALUE;
        for (int i = 0; i < half; i++) {
            long val = left[i] + prize[l + i][h - 1];
            if (val > maxLeftLoss) maxLeftLoss = val;
        }
        for (int j = 0; j < half; j++) {
            result[half + j] = right[j] + maxLeftLoss;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        totalPlayers = 1 << n;
        prize = new long[totalPlayers][n + 1];
        for (int i = 0; i < totalPlayers; i++) {
            for (int j = 1; j <= n; j++) {
                prize[i][j] = sc.nextLong();
            }
        }
        long[] bestWithoutFinal = solve(0, totalPlayers, n);
        long answer = Long.MIN_VALUE;
        for (int i = 0; i < totalPlayers; i++) {
            long total = bestWithoutFinal[i] + prize[i][n];
            if (total > answer) answer = total;
        }
        System.out.println(answer);
        sc.close();
    }
}