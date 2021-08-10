//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 783 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    // 回溯函数
    public boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        // 当 j 到达超过每一行的最后一个索引时，转为增加 i 开始穷举下一行
        if (j == n) {
            return backtrack(board, i + 1, 0);
        }
        // base case：当 i == m 的时候就说明穷举完了最后一行
        if (i == m) return true;
        // 如果该位置是预设的数字，就不必操心
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        // 根据框架写出穷举的过程
        for (char char_num = '1'; char_num <= '9'; char_num++) {
            // 剪枝
            if (!isValid(board, i, j, char_num)) {
                continue;
            }
            // 选择
            board[i][j] = char_num;
            // 填下一个空格，如果找到一个可行解，直接返回
            if (backtrack(board, i, j + 1)) return true;
            // 撤销
            board[i][j] = '.';
            //思考1：当 j 到达超过每一行的最后一个索引时，转为增加 i 开始穷举下一行，并且在穷举之前添加一个判断，跳过不满足条件的数字
            //思考2：递归函数的 base case
        }
        return false;
    }

    // 剪枝判断的函数，如果是 false，直接跳过
    public boolean isValid(char[][] board, int row, int col, char char_num) {
        for (int i = 0; i < 9; i++) {
            // 判断每一行是否有元素重复
            if (board[row][i] == char_num) return false;
            // 判断每一列是否有元素重复
            if (board[i][col] == char_num) return false;
            // 判断每个 3*3 的网格内的元素是否重复
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == char_num) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
