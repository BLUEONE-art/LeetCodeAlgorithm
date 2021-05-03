package changeTo1;

public class ChangeTo1Copy {
    // 此递归函数表示：将n转换为1的最小步数
    public static int recurChangeTo1(int n) {
        if (n <= 1) return 0;
        if (n % 2 == 0) {
            return recurChangeTo1(n / 2) + 1;
        }
        else {
            int a = (n + 1) / 2;
            int b = (n - 1) / 2;
            return Math.min(recurChangeTo1(a), recurChangeTo1(b)) + 2;
        }
    }

    // 动态规划解法
    public static int ChangeTo1(int n) {
        // res[i]表示n == i时需要的步数
        int[] res = new int[n + 1];
        int len = res.length - 1;
        for (int i = 2; i <= len; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2] + 1;
            }
            else {
                res[i] = Math.min(res[(i - 1) / 2] + 2, res[(i + 1) / 2] + 2);
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        int res = recurChangeTo1(61);
        int res1 = ChangeTo1(61);
        System.out.println("res = " + res);
        System.out.println("res1 = " + res1);
    }
}
