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
// 👍 901 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> prosumToIdx = new HashMap<>();
        prosumToIdx.put(0, 1); // 前缀和为0的情况有一次
        int prosum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prosum += nums[i];
            if (prosumToIdx.containsKey(prosum - k)) { // 前缀和-tar在hashmap中存在，说明有连续的数的和等于tar。
                // 比如nums=[1,2,6,4,-1,5],k=3，前缀和1+2=3,3-3=0,说明有连续的数的和等于k，
                // 同理有前缀和1+2+6=9，并且有前缀和1+2+6+4+(-1)=12，12-k=9,存在这个前缀，说明有连续的数之和等于3（k），不然前缀和9为什么能变成12呢？
                count += prosumToIdx.get(prosum - k);
            }
            prosumToIdx.put(prosum, prosumToIdx.getOrDefault(prosum, 0) + 1); // 添加前缀和
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
