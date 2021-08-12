//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        // 找第一个上升的趋势
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        reverse(nums, i + 1, len - 1);
        // 防止没找到数组越界
        if (i >= 0) {
            // 找从i+1~len-1范围内，大于nums[i]的最小值，即右边界
            int j = binarySearch(nums, i + 1, len - 1, nums[i]);
            swap(nums, i, j);
        }
    }

    // 从left~right之间必然降序 -- 升序
    public int binarySearch(int[] nums, int left, int right, int tar) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= tar) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
