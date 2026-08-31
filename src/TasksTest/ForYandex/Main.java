package TasksTest.ForYandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        boolean[][] processed = new boolean[n][m];
        int replacements = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (processed[i][j]) {
                    continue;
                }
                List<Integer> group = new ArrayList<>();
                group.add(matrix[i][j]);
                processed[i][j] = true;
                int i2 = n - 1 - i;
                int j2 = m - 1 - j;
                if (!processed[i][j2]) {
                    group.add(matrix[i][j2]);
                    processed[i][j2] = true;
                }
                if (!processed[i2][j]) {
                    group.add(matrix[i2][j]);
                    processed[i2][j] = true;
                }
                if (!processed[i2][j2]) {
                    group.add(matrix[i2][j2]);
                    processed[i2][j2] = true;
                }
                Map<Integer, Integer> frequency = new HashMap<>();
                for (int value : group) {
                    frequency.put(value, frequency.getOrDefault(value, 0) + 1);
                }

                int maxFreq = 0;
                for (int count : frequency.values()) {
                    maxFreq = Math.max(maxFreq, count);
                }
                replacements += group.size() - maxFreq;
            }
        }
        System.out.println(replacements);
    }
}