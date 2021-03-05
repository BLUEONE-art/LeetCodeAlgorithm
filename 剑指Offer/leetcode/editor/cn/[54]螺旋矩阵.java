//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 624 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 左边界
        int left = 0;
        // 右边界
        int right = matrix[0].length - 1;
        // 上边界
        int top = 0;
        // 下边界
        int bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 判断是否越界
            if (++top > bottom) break;
            // 从上到下
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);
            }
            // 判断是否越界
            if (--right < left) break;

            for (int k = right; k >= left; k--) {
                res.add(matrix[bottom][k]);
            }
            // 判断是否越界
            if (--bottom < top) break;

            for (int l = bottom; l >= top; l--) {
                res.add(matrix[l][left]);
            }
            // 判断是否越界
            if (++left > right) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
