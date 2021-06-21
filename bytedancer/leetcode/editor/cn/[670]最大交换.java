//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学 
// 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int len = chars.length, maxNumIdx = chars.length - 1;
        int[] maxIdxArr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] > chars[maxNumIdx]) {
                maxNumIdx = i;
            }
            maxIdxArr[i] = maxNumIdx;
        }
        for (int i = 0; i < len - 1; i++) {
            if (chars[maxIdxArr[i]] != chars[i]) {
                swap(chars, i, maxIdxArr[i]);
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
