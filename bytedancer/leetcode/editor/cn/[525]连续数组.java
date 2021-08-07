//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 442 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int curSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> curSumToCurIdx = new HashMap<>();
        // 索引从-1开始，免得两坐标相减还要加1
        curSumToCurIdx.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curSum -= 1;
            } else {
                curSum += 1;
            }
            if (curSum == 0 || curSumToCurIdx.containsKey(curSum)) {
                maxLen = Math.max(maxLen, (i - curSumToCurIdx.get(curSum)));
            } else {
                curSumToCurIdx.put(curSum, i);
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
