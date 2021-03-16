//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1633 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 每一个可行的路径
        StringBuilder path = new StringBuilder();
        // 回溯框架
        backtrack(n, n, path, res);
        return res;
    }
    // left、right：表示左右括号的数量
    public void backtrack(int left, int right, StringBuilder path, List<String> res) {
        // 终止条件
        // ①*可用*的左括号一定比*可用*的右括号少的，因为 path 的子串中肯定是左括号比右括号多的
        if (left > right) return;
        // ②可用括号数小于0
        if (left < 0 || right < 0) return;
        // ③当两者恰好都为0
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        // 所有选择：其实就两个，放 ”（“ 或 ”）“
        path.append('(');
        backtrack(left - 1, right, path, res);
        // 撤销选择
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        backtrack(left, right - 1, path, res);
        // 撤销选择
        path.deleteCharAt(path.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
