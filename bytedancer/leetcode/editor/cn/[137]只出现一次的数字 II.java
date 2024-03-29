//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 数组 
// 👍 698 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int[] countBit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                // 记录num中每一位出现的个数，取二进制中每一位的方法
                if (((num >> i) & 1) == 1) {
                    countBit[i]++;
                }
            }
        }
        int res = 0;
        // 如果所有数都出现三次，那countBit中所有数都是3的倍数
        for (int i = 0; i < 32; i++) {
            if ((countBit[i] % 3 & 1) == 1) {
                res += (1 << i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
