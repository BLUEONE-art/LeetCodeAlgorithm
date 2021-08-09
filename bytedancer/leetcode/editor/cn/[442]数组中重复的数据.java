//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。 
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组 哈希表 
// 👍 410 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int idealIdx = nums[i] - 1;
            if (nums[i] == i + 1 || nums[i] == nums[idealIdx]) {
                i++;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = tmp;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(nums[j]);
            }
        }
        return res;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (!set.add(num)) {
                res.add(num);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
