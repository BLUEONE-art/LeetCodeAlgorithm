//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 777 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        // 初始化没有皇后
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                chess[i][j] = '.';
            }
        }
        // 回溯算法计算所有可能性
        backtrack(res, chess, 0);
        return res;
    }

    // 回溯函数主体
    public void backtrack(List<List<String>> res, char[][] chess, int row) {
        // 终止条件：每一次试探后，如果有可行结果就记录
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        // 回溯框架，列举所有的情况
        for (int col = 0; col < chess[0].length; col++) {
            // 剪枝
            if (isValid(chess, row, col)) {
                chess[row][col] = 'Q';
                // 选择判断下一行
                backtrack(res, chess, row+1);
                // 撤销选择
                chess[row][col] = '.';
            }
        }
    }

    // 只有满足条件才能放皇后
    public boolean isValid(char[][] chess, int row, int col) {
        // 检测同一列上有没有重复的
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        // 检测该皇后左上边对角线上有没有其他皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // 检测该皇后右上边对角线上有没有其他皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // char[][] 类型 --> List<String>
    public List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
