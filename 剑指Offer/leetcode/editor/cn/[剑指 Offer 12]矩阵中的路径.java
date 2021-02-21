//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 243 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 在 board 中从左到右，从上到下依次查找
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    // dfs()：帮我们递归找到索引 board[i][j] 是否与 words[k] 匹配
    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // base case
        // 超出索引边界以及不匹配的情况均返回 false
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != words[k]) return false;
        // 如果 k 运动到 words 最后一个字符，表示全部匹配
        if (k == words.length - 1) return true;
        // 定义空字符，代表此元素已访问过，防止之后搜索时重复访问。
        board[i][j] = '\0';
        // 递归：下 --> 上 --> 右 --> 左
        boolean res = dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1)
                || dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1);
        // 还原
        board[i][j] = words[k];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
