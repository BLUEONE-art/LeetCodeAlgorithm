//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 567 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        int sign = 1;
        
        Stack<Integer> s_num = new Stack<>();
        Stack<Integer> s_sign = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') continue; // 空格
            if (str[i] == '+' || str[i] == '-') sign = str[i] == '+' ? 1 : -1; // 正负号
            else if (str[i] >= '0' && str[i] <= '9') { // 数字
                int num = str[i] - '0';
                while (i < len - 1 && str[i + 1] >= '0' && str[i] <= '9') { // 后一个仍是数字
                    num = num * 10 + (str[++i] - '0');
                }
                ans += sign * num;
            }
            else if (str[i] == '(') { // 暂存左括号前的结果和符号
                s_num.push(ans);
                s_sign.push(sign);
                ans = 0;
                sign = 1;
            }
            else { // 遇到右括号再加上前面暂存的结果
                ans = s_num.pop() + s_sign.pop() * ans;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
