//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 450 👎 0

//         int res = 0;
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    int count = 1;
//                    while (i + count < nums1.length && j + count < nums2.length && nums1[i + count] == nums2[j + count]) {
//                        count++;
//                    }
//                    res = Math.max(res, count);
//                }
////                else break;
//            }
//        }
//        return res;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j]：以长度为i，末尾项为nums1[i - 1]结尾的子数组和nums[j - 1]结尾的子数组的最长公共子数组长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
