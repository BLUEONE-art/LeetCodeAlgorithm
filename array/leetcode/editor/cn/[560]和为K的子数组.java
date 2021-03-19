//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 816 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 连续数组的组合是否等于 k
    public int subarraySum(int[] nums, int k) {
        // 记录前缀和 和 该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // 前缀和为 0 出现 1 次
        preSum.put(0, 1);
        int sum0_i = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            // sum_i：表示 nums[0,...,i] 的前缀和，所以如果 preSum[i,...,j] = k = sum_j - sum_(i-1)，则找到一个连续数组 nums[i,...j] 符合要求
            // 稍微变化一下：如果 sum_(i-1) = sum_j - k，令 sum_(i-1) = sum_j，如果 preSum 里有，直接返回其频次
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
