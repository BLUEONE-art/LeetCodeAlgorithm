//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 802 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 回溯算法要遍历每一个可能的结果
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    // 设计递归函数：可以根据字符矩阵中左右边界的索引 board[i][j] 是否和 word[k] 对应
    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // base case：如果 i，j 超出索引边界，或者不等于 words[k] 返回 false
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != words[k]) return false;
        // 如果 words 全部匹配成功
        if (k == words.length - 1) return true;
        // 回溯算法的框架，先做选择再撤销选择
        board[i][j] = '\0';
        // 上下左右分别搜索
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i- 1, j, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
