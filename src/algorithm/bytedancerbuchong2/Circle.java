package algorithm.bytedancerbuchong2;

public class Circle {
    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c.backToOrigin(10));
    }

    public int backToOrigin(int n) {
        int len = 10;
        int[][] dp = new int[n + 1][len];
        dp[0][0] = 1;
        // 走i步到0的选择是 走i-1步到1 + 走i-1步到9 的和
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % len] + dp[i - 1][(j - 1 + len) % len];
            }
        }
        return dp[n][0];
    }
}
