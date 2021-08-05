//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 743 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(
                // 避免成环，只要头不要尾
                robRange(nums, 0, len - 1),
                // 避免成环，只要尾不要头
                robRange(nums, 1, len)
                // 两者都不要，但是选择空间没上述情况大，舍弃：robRange(nums, 1, len - 1)
        );
    }

    public int robRange(int[] nums, int start, int end) {
        int k_2Family = 0;
        int k_1Family = nums[start];
        for (int k = start + 1; k < end; k++) {
            int tmpRes = Math.max(
                    // 在k-2步抢劫 + k步抢
                    k_2Family + nums[k],
                    // 在k-1步抢，k-2步和k步不抢
                    k_1Family
            );
            k_2Family = k_1Family;
            k_1Family = tmpRes;
        }
        return k_1Family;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
