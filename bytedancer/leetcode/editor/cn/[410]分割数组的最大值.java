//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 贪心 数组 二分查找 动态规划 
// 👍 532 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 求最大的值使之分割数组的个数等于m
    public int splitArray(int[] nums, int m) {
        int maxNum = 0;
        int sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }
        // 如果分割的数值比left还小，到num=left时就不能分割，报错
        int left = maxNum;
        int right = sum;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int canSplitNum = canSplit(nums, mid);
            if (canSplitNum > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int canSplit(int[] nums, int splitNum) {
        int canSplitNum = 1;
        int curNum = 0;
        for (int num : nums) {
            if (curNum + num > splitNum) {
                curNum = 0;
                canSplitNum++;
            }
            curNum += num;
        }
        return canSplitNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
