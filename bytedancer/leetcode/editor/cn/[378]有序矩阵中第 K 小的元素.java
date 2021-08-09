//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 636 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 找到数组中的第K小的元素，说明前面有k个元素小于等于它
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (countLowerMid(matrix, mid) < k) {
                // 如果小于mid的元素小于k个，说明第K小的元素在mid之后
                left = mid + 1;
            } else {
                // 大于k个，说明结果可能在这之中
                right = mid;
            }
        }
        return left;
    }

    public int countLowerMid(int[][] matrix, int mid) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] <= mid) {
                // 说明col这一整列都小于等于mid
                count += row + 1;
                col++;
            } else {
                // 大于mid
                row--;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
