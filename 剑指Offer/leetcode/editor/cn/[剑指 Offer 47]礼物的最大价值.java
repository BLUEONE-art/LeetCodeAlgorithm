//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 108 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        // dp[i][j]：第 i 行第 j 列礼物的最大值
        int[][] dp =  new int[row + 1][column + 1];
        // base case：第一行和第一列初始化为 0
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                // 状态转移：求上两个路径选择的最大值加上当前格子里礼物的值
                // dp[][] 中的 i，j 对应 grid 矩阵中的 i - 1，j - 1
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
