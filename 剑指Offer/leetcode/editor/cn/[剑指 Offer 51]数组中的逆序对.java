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
// 👍 329 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    public int mergeSort(int left, int right) {
        // base case：当划分得只剩下一个元素时，没有逆序数
        if (left >= right) return 0;
        // 划分区间
        int m = (left + right) / 2;
        // 递归
        int res = mergeSort(left, m) + mergeSort(m + 1, right);
        // 后序遍历代码位置
        // 确定划分后两个数组分别的左指针是多少
        int subLeft1 = left;
        int subLeft2 = m + 1;
        // 只考虑递归函数的定义：mergeSort() 会帮我们排序好 nums 的 [left, m] 和 [m + 1, right] 部分，nums 此时是递归一次后排序了一次的结果
        // 复制一次递归了一次的结果用作两个数组比较的时候用
        for (int k = left; k <= right; k++) {
            tmp[k] = nums[k];
        }
        // 开始比较
        for (int k = left; k <= right; k++) {
            // 此时左边的数组全部遍历完，只能添加右边数组的元素
            if (subLeft1 == m + 1) {
                nums[k] = tmp[subLeft2++];
            }
            // 如果右边的数组全部遍历完，只能添加左边数组的元素，或者左边元素小于右边元素
            else if (subLeft2 == right + 1 || tmp[subLeft1] <= tmp[subLeft2]) {
                nums[k] = tmp[subLeft1++];
            }
            // 否则遇到逆序数
            else {
                nums[k] = tmp[subLeft2++];
                res += m - subLeft1 + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
