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
// Related Topics 数组 回溯 
// 👍 972 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (char[] c : chess) {
            Arrays.fill(c, '.');
        }
        backtrack(chess, 0);
        return res;
    }

    public void backtrack(char[][] chess, int row) {
        if (row == chess.length) {
            res.add(arrayToList(chess));
            return;
        }
        for (int col = 0; col < chess[0].length; col++) {
            if (isValid(chess, row, col)) {
                chess[row][col] = 'Q';
                backtrack(chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chess, int row, int col) {
        // 同行没重复Q -- 按行推进，所以没必要再判断行
        // 同列没重复Q
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        // 当前坐标的左上角对角线没重复Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // 当前坐标的右对角线没重复Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> arrayToList(char[][] chess) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            res.add(new String(chess[i]));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
