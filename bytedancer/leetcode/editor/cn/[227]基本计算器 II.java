//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 410 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int num = 0, ans = 0, len = s.length();
        char[] str = s.toCharArray();
        char sign = '+';

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(str[i])) {
                num = num * 10 + str[i] - '0';
            }
            if (!Character.isDigit(str[i]) && str[i] != ' ' || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                else if (sign == '-') {
                    stack.push(-num);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = str[i];
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
