package bishi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        while (size > 0) {
            while (sc.hasNextLine()) {
                String[] strings = sc.next().split(",");
            }
            size--;
        }
        int res = minSum(matrix);
        System.out.println(res);
    }

    public static int minSum(int[][] matrix) {
        int len = matrix.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[len][len];
    }
}
