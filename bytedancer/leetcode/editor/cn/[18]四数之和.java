//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 907 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int l = 0; l < nums.length - 3; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            for (int k = l + 1; k < nums.length - 2; k++) {
                if (k > l + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        // 跳过重复, 可以先不看
                        while (i < j && nums[i + 1] == nums[i]) {
                            i++;
                        }
                        while (i < j && nums[j - 1] == nums[j]) {
                            j--;
                        }
                        // 逼近中间
                        i++;
                        j--;
                    } else if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
