package YandexTaskOne;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int t = Integer.parseInt(first[1]);
        int[] rowCnt = new int[n];
        int[] colCnt = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        String[] nums = br.readLine().split(" ");
        for (int round = 1; round <= t; round++) {
            int a = Integer.parseInt(nums[round - 1]);
            int row = (a - 1) / n;
            int col = (a - 1) % n;
            rowCnt[row]++;
            colCnt[col]++;
            if (row == col) diag1++;
            if (row + col == n - 1) diag2++;
            if (rowCnt[row] == n || colCnt[col] == n || diag1 == n || diag2 == n) {
                System.out.println(round);
                return;
            }
        }
        System.out.println(-1);
    }
}