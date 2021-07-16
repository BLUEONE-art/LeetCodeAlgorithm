//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 459 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, tmp);
    }

    public int mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res = mergeSort(nums, left, mid, tmp) + mergeSort(nums, mid + 1, right, tmp);
        int subleft1 = left;
        int subleft2 = mid + 1;
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        for (int i = left; i <= right; i++) {
            if (subleft1 == mid + 1) {
                nums[i] = tmp[subleft2];
                subleft2++;
            }
            else if (subleft2 == right + 1 || tmp[subleft1] <= tmp[subleft2]) {
                nums[i] = tmp[subleft1];
                subleft1++;
            }
            else {
                nums[i] = tmp[subleft2];
                subleft2++;
                res += mid + 1 - subleft1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
