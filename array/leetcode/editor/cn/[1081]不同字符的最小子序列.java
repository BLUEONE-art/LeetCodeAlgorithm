//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 80 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* ①保证字串中没有重复字母 --> 通过 inStack[] 数组记录 s 中的字母是否在栈 stk 中
     *  ②要使得获得的字串中字典序最小 --> 通过比较入栈元素和栈顶元素的大小判断是否需要弹栈
     *  ③保证即使字典序大，但是只有唯一的一个字母，也不能进行弹栈操作 --> 维护一个 count[] 记录每个字母的次数*/
    public String smallestSubsequence(String s) {
        // 定义 stk，对 s 中的元素进行入、出栈的操作
        Stack<Character> stk = new Stack<>();
        // 定义一个数组记录每个字母出现的次数
        int[] count = new int[256]; // 字母的话，存 ASCII 码，0~255够了
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] inStark = new boolean[256];
        // 遍历 s 中所有字母进行 进、出栈 操作
        for (char c : s.toCharArray()) {
            // 遍历一个元素，该元素对应的次数减一
            count[c]--;

            // 若 c 已经在 inStack[] 中了，不需要再 进、出栈 了
            if (inStark[c]) continue;

            // 循环判断 stk 是否为空并且入栈元素和栈顶元素的字典序
            // 字典序由小到大，不满足的弹栈
            while (!stk.isEmpty() && stk.peek() > c) {
                // 如果此时 stk.peek() 的次数已经为 0 了，即使 stk.peek() > c，也不要 pop(stk.peek())
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 否则 pop 并更新 c 在 inStack 中的状态
                inStark[stk.pop()] = false;
            }
            stk.push(c);
            // 更新 c 在 inStack[] 中的状态，表示 c 在 inStack[] 中了
            inStark[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
