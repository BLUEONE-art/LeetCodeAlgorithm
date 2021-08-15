//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 数组 回溯 
// 👍 91 👎 0


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
