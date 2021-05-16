//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2404 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 用栈放一边括号对应的另一边括号，跟另一边括号一起弹出
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            }
            else if (c == '[') {
                st.push(']');
            }
            else if (c == '{') {
                st.push('}');
            }
            else if (st.empty() || c != st.pop()) {
                return false;
            }
        }
        if (st.empty()) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
