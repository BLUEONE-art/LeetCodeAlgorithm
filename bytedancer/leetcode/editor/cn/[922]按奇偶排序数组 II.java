//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 数组 双指针 排序 
// 👍 213 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 原地
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int oddIdx = 1;
        for (int i = 0; i < len; i += 2) {
            // 偶数位上遇到奇数
            if ((nums[i] & 1) == 1) {
                // 奇数位上直到找到一个偶数跳出循环
                while ((nums[oddIdx] & 1) == 1) {
                    oddIdx += 2;
                }
                int tmp = nums[i];
                nums[i] = nums[oddIdx];
                nums[oddIdx] = tmp;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
