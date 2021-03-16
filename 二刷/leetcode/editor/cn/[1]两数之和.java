//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10528 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0; // 左侧最小索引
        int right = nums.length - 1; // 搜索空间：[left, right]
        int[] arr = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(arr);
        while (left <= right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                // 找到 arr[left] 和 arr[right] 在 nums 中的索引
                int a = findIndex(left, arr, nums);
                int b = findIndex(right, arr, nums);
                // 如果 10 = 5 + 5，两个数是同一个索引
                if (a == b) {
//                    b = a + 1;测试用例:[3,2,3]
                    nums[b] = arr[arr.length - 1] + 1;
                    b = findIndex(right, arr, nums);
                }
                return new int[]{a, b};
            }
            else if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public int findIndex(int afterIndex, int[] arr, int[] nums) {
        int orignalIndex = 0, i = 0;
        while (i < nums.length) {
            if (arr[afterIndex] == nums[i]) {
                orignalIndex = i;
                break;
            }
            i++;
        }
        return orignalIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
