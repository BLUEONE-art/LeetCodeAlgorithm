//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 188 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        // base case
        if (matrix.length == 0) return new int[0];
        // 定义二维矩阵的上下左右边界
        // 上边界
        int top = 0;
        // 下边界
        int bottom = matrix.length - 1; // 也就是行数
        // 左边界
        int left = 0;
        // 右边界
        int right = matrix[0].length - 1; // 列数
        // 输出结果数组
        int[] res = new int[(bottom + 1) * (right + 1)];
        // 定义 res 中指针
        int x = 0;
        // 循环开始
        while (true) {
            // 从左边界遍历到有边界
            for (int i = left; i <= right; i++) {
                // res[x++]：先计算 res[x] 的值，再 x 自加
                res[x++] = matrix[top][i];
            }
            // 如果 while 循环一直循环到 top > bottom，跳出 while
            // ++top：先让 top 自加 1，然后把自加结果赋值给 ++top 这个表达式
            if (++top > bottom) break;

            // 从上边界到下边界
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }
            // 如果 while 循环一直循环到 right < left，跳出 while
            if (--right < left) break;

            // 从下边界的右边界到左边界
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }
            // 如果 while 循环一直循环到 bottom < top，跳出 while
            if (--bottom < top) break;

            // 从左边界的下边界到上边界
            for (int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left];
            }
            // 如果 while 循环一直循环到 left > right，跳出 while
            if (++left > right) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
