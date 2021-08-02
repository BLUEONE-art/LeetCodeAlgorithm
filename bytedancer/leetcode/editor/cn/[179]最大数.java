//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 750 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, len - 1);
        // 降序排序，如果第一个为0，后面肯定小于0
        if (str[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : str) {
            sb.append(string);
        }
        return sb.toString();
    }

    public void quickSort(String[] str, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(str, low, high);
        quickSort(str, low, pivot - 1);
        quickSort(str, pivot + 1, high);
    }

    public int partition(String[] str, int low, int high) {
        String leftmostString = str[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (++i < high && (str[i] + leftmostString).compareTo(leftmostString + str[i]) > 0);
            while (--j > low && (str[j] + leftmostString).compareTo(leftmostString + str[j]) < 0);
            if (i >= j) {
                break;
            }
            String tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
        str[low] = str[j];
        str[j] = leftmostString;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
