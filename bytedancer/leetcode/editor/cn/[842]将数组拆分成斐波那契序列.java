//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 字符串 回溯 
// 👍 233 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String num) {
        backtrack(num.toCharArray(), 0);
        return res;
    }

    public boolean backtrack(char[] digit, int idx) {
        // 如果截取完成，并且最少为3个数
        if (idx == digit.length && res.size() >= 3) {
            return true;
        }
        for (int i = idx; i < digit.length; i++) {
            // 两位以上的数字不以0开头
            if (digit[idx] == '0' && i > idx) {
                break;
            }
            long num = subDigit(digit, idx, i + 1);
//            if (num > Integer.MAX_VALUE) {
//                break;
//            }
            int size = res.size();
//            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
//                // 截取的数字大于两数之和，后面的数字肯定越来越大
//                break;
//            }
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int) num);
                if (backtrack(digit, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    public long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
