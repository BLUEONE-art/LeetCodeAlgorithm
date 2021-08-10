//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 
// 👍 899 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int i, int j) {
        // i行数，j列数
        if (j == 9) {
            return backtrack(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        // 当前位置有数字
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            // 剪枝：如果行、列、3*3小宫格内有重复元素，表示无效
            if (!isValid(board, i, j, c)) {
                continue;
            }
            // 一个个字符试
            board[i][j] = c;
            // 返回值为boolean含义是当前数字选择为c，如果一直递归能找到一个可行解，理解返回退出
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            // 否则回溯到原处尝试下一个数字
            board[i][j] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char curChar) {
        for (int i = 0; i < 9; i++) {
            // 一行元素重复了
            if (board[row][i] == curChar) {
                return false;
            }
            // 一列元素重复了
            if (board[i][col] == curChar) {
                return false;
            }
            // 3*3宫格内元素重复了
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == curChar) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
