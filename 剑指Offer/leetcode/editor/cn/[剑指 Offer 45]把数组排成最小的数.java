//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        // 把 nums 中的数字转换成字符串
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // k 等于数组长度
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
    // 快速排序函数
    public void quickSort(String[] strs, int low, int high) {
        if (low < high) {
            int j = partition(strs, low, high);
            quickSort(strs, low, j - 1);
            quickSort(strs, j + 1, high);
//        if (j == k) return strs;
//        return j > k ? quickSort(strs, low, j - 1, k) : quickSort(strs, j + 1, high, k);
        }
    }
    public int partition(String[] strs, int low, int high) {
        // 最左边的字符串
        String leftmostStr = strs[low];
        int i = low, j = high + 1;
        while (true) {
            // 找到比 leftmostNum 大的数，因为 strs[i] + leftmostStr 与 leftmostStr + strs[i] 相比来说要小，所以 strs[i] < leftmostNum
            while (++i < high && (strs[i] + leftmostStr).compareTo(leftmostStr + strs[i]) < 0);
            // 找到比 leftmostNum 小的数
            while (--j > low && (strs[j] + leftmostStr).compareTo(leftmostStr + strs[j]) > 0);
            if (i >= j) break;
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        // 交换 low 和 j 的位置
        strs[low] = strs[j];
        strs[j] = leftmostStr;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
