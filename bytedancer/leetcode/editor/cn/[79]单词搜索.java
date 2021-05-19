//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],
//              ["S","F","C","S"],
//              ["A","D","E","E"]], word = "ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 903 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        int M = board.length, N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (helper(board, word.toCharArray(), i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, char[] word, int r, int c, int len) {
        // 终止条件
        if (!isArea(board, r, c)) return false;
        if (board[r][c] != word[len]) return false;
        if (len == word.length - 1) return true;

        board[r][c] = '\0'; // 只有board[r][c] = words[len] 才会递归
        res = helper(board, word, r - 1, c, len + 1) ||
              helper(board, word, r + 1, c, len + 1) ||
              helper(board, word, r, c - 1, len + 1) ||
              helper(board, word, r, c + 1, len + 1);
        board[r][c] = word[len];
        return res;
    }

    public boolean isArea(char[][] board, int r, int c) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[0].length - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
