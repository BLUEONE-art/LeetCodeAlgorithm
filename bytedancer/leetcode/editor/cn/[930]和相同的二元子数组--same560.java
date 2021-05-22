//在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的非空子数组。 
//
// 
//
// 示例： 
//
// 输入：A = [1,0,1,0,1], S = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 
//
// 提示： 
//
// 
// A.length <= 30000 
// 0 <= S <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 哈希表 双指针 
// 👍 98 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> presumToIdx = new HashMap<>();
        presumToIdx.put(0,1);
        int presum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (presumToIdx.containsKey(presum - goal)) {
                count += presumToIdx.get(presum - goal);
            }
            presumToIdx.put(presum, presumToIdx.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
