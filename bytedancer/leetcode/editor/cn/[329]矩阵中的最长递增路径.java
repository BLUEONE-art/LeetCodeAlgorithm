//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 
// 👍 506 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/javashi-xian-shen-du-you-xian-chao-ji-jian-dan-yi-/
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] == 0) {
                    max = Math.max(max, dfs(matrix, r, c, visited));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int r, int c, int[][] visited) {
        if (!inArea(matrix, r, c)) {
            return 0;
        }
        if (visited[r][c] > 0) {
            return visited[r][c];
        }
        int max = 0;
        if (r - 1 >= 0 && matrix[r][c] > matrix[r - 1][c]) {
            max = Math.max(max, dfs(matrix, r - 1, c, visited));
        }
        if (r + 1 < matrix.length && matrix[r][c] > matrix[r + 1][c]) {
            max = Math.max(max, dfs(matrix, r + 1, c, visited));
        }
        if (c - 1 >= 0 && matrix[r][c] > matrix[r][c - 1]) {
            max = Math.max(max, dfs(matrix, r, c - 1, visited));
        }
        if (c + 1 < matrix[0].length && matrix[r][c] > matrix[r][c + 1]) {
            max = Math.max(max, dfs(matrix, r, c + 1, visited));
        }
        visited[r][c] = max + 1;
        return max + 1;
    }

    public boolean inArea(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
