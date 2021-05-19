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
// 👍 1791 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        helper(n, n); // 左右括号的数量均为 n
        return res;
    }

    public void helper(int left, int right) {
        // 终止条件
        if (left > right) return; // 正常从左往右数，左括号一定大于右括号，所可以用括号一定小于右边的
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) { // 一个可行解
            res.add(path.toString());
            return;
        }

        path.append('(');
        helper(left - 1, right);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        helper(left, right - 1);
        path.deleteCharAt(path.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
