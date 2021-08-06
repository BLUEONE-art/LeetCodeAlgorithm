//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。 
//
// 
//
// 进阶： 
//
// 
// 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题? 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,0,1]
//输出：2
//解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：2
//解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 3： 
//
// 
//输入：nums = [9,6,4,2,3,5,7,0,1]
//输出：8
//解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。 
//
// 示例 4： 
//
// 
//输入：nums = [0]
//输出：1
//解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// 0 <= nums[i] <= n 
// nums 中的所有数字都 独一无二 
// 
// Related Topics 位运算 数组 哈希表 数学 排序 
// 👍 432 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i <= nums.length; i++) {
            if (i > nums.length - 1 || nums[i] != i) {
                return i;
            }
        }
        return -1;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    public int partition(int[] nums, int left, int right) {
        int leftmostNum = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (++i < right && nums[i] < leftmostNum);
            while (--j > left && nums[j] > leftmostNum);
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[j];
        nums[j] = leftmostNum;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
