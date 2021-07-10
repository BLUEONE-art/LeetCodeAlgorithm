//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// 👍 196 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, count = 0;
        int[] res = new int[m * n];
        boolean flag = true;
        for (int i = 0; i < m + n; i++) {
            int curM = flag ? m : n;
            int curN = flag ? n : m;

            int x = (i < curM) ? i : curM - 1; // i >= curM，表明此时已经遍历到矩阵右下角了
            int y = i - x;

            while (x >= 0 && y < curN) {
                res[count] = flag ? mat[x][y] : mat[y][x];
                count++;
                x--;
                y++;
            }

            flag = !flag;
        }
        return res;
    }

//    public static void antiClockwise90(int[][] mat) {
//        int n = mat.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                int tmp = mat[i][j];
//                mat[i][j] = mat[j][i];
//                mat[j][i] = tmp;
//            }
//        }
//
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < n; j++) {
//                int tmp = mat[i][j];
//                mat[i][j] = mat[n - 1 - i][j];
//                mat[n - 1 - i][j] = tmp;
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
