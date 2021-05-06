//有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。 
//
// 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。 
//
// 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。 
//
// 请返回封闭岛屿的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,1,1,1,1,1,1,0],
//              [1,0,0,0,0,1,1,0],
//              [1,0,1,0,1,1,1,0],
//              [1,0,0,0,0,1,0,1],
//              [1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,1,0,0],
//              [0,1,0,1,0],
//              [0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 输入：grid =   [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//                [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 
// 👍 75 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean inAreaFlag;
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    inAreaFlag = true;
                    dfsGrid(grid, i, j);
                    if (inAreaFlag) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void dfsGrid(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            inAreaFlag = false;
            return;
        }
        if (grid[r][c] != 0) return;
        grid[r][c] = 2;
        dfsGrid(grid, r - 1, c);
        dfsGrid(grid, r + 1, c);
        dfsGrid(grid, r, c - 1);
        dfsGrid(grid, r, c + 1);
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
