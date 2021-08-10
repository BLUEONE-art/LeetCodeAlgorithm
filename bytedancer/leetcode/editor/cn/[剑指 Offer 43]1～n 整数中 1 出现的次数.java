//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 
// 👍 214 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        int digit = 1;
        int count = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                // 2304 -- 小于等于该数 && 不遗漏1出现次数 --> 范围：0010 ~ 2219，固定十位的1，转动其他几位从0~9，共有229-0+1=230
                count += high * digit;
            } else if (cur == 1) {
                // 2314 -- 小于等于该数 && 不遗漏1出现次数 --> 范围：0010 ~ 2314，固定十位的1，转动其他几位，共有230+5(0~5)=235
                count += high * digit + low + 1;
            } else {
                // 2324 -- 小于等于该数 && 不遗漏1出现次数 --> 范围：0010 ~ 2319，固定十位的1，转动其他几位，共有230+10(0~9)=240
                count += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
