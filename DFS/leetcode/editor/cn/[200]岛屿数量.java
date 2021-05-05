//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        // 可以从任何一个岛屿开始寻找
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 帮你找大陆个数，怎么找的不需要关心
                    dfsGrid(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfsGrid(char[][] grid, int r, int c) {
        // base case
        if (!isArea(grid, r, c)) return;
        if (grid[r][c] != '1') return;
        grid[r][c] = '2';
        // 模板
        dfsGrid(grid, r - 1, c);
        dfsGrid(grid, r + 1, c);
        dfsGrid(grid, r, c - 1);
        dfsGrid(grid, r, c + 1);
    }

    // 判断是否越界
    public boolean isArea(char[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[0].length - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
