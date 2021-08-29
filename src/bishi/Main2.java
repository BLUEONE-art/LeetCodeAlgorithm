package bishi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        // 有n个数组，每个数组逗号分开
//        int n = sc.nextInt();
//        int[][] matrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//        int res = countNum(matrix);
//        System.out.println(res);

        int[][] test = new int[4][5];
        test[0][0] = 1;
        test[0][1] = 1;
        test[0][2] = 1;
        test[0][3] = 1;
        test[0][4] = 0;
        test[1][0] = 1;
        test[1][1] = 1;
        test[1][2] = 0;
        test[1][3] = 1;
        test[1][4] = 0;
        test[2][0] = 1;
        test[2][1] = 1;
        test[2][2] = 0;
        test[2][3] = 0;
        test[2][4] = 0;
        test[3][0] = 0;
        test[3][1] = 0;
        test[3][2] = 0;
        test[3][3] = 0;
        test[3][4] = 0;
        System.out.println(countNum(test));

        int[] t = new int[]{1, 1, 2};
        int r = removeDuplicates(t);
        PriorityQueue<Integer> q = new PriorityQueue<>(3, (a, b) -> a - b);
    }

    // 类似于岛屿数量
    public static int countNum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        // 可以从矩阵中任意位置开始查找
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] matrix, int row, int col) {
        // 如果查找的行列不在范围内
        if (!isArea(matrix, row, col)) {
            return;
        }
        if (matrix[row][col] != 1) {
            return;
        }

        // 标识此格子已经走过一次，防止重新走
        matrix[row][col] = 2;
        dfs(matrix, row - 1, col);
        dfs(matrix, row + 1, col);
        dfs(matrix, row, col - 1);
        dfs(matrix, row, col + 1);
    }

    public static boolean isArea(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int slow = 0;
        int fast = 0;
        while (fast < len) {
            while (fast < len && nums[slow] == nums[fast]) {
                fast++;
            }
            // 不相等时
            slow++;
            nums[slow] = nums[fast];
        }
        return slow + 1;
    }
}
