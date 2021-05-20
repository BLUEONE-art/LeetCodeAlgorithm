//返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。 
//
// 如果没有和至少为 K 的非空子数组，返回 -1 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1], K = 1
//输出：1
// 
//
// 示例 2： 
//
// 输入：A = [1,2], K = 4
//输出：-1
// 
//
// 示例 3： 
//
// 输入：A = [2,-1,2], K = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -10 ^ 5 <= A[i] <= 10 ^ 5 
// 1 <= K <= 10 ^ 9 
// 
// Related Topics 队列 二分查找 
// 👍 278 👎 0

//         int size = A.length;
//        int left = 0, right = 0;
//        int sum = 0; // 当前子序列和
//        int res = size + 1;
//        while (right < size) {
//            sum += A[right];
//            if (sum <= 0) { // 负值情况，双指针都移向右指针下一个位置
//                left = right + 1;
//                right = right + 1;
//                sum = 0;
//                continue;
//            }
//            int i = right;
//            while (A[i] < 0 && i >= 1) {
//                A[i - 1] += A[i]; // 上一个元素加上这个负数
//                A[i] = 0; // 负数变为0
//                i--;
//            }
//            if (sum >= K) { // 收缩窗口
//                while (left <= right && sum - A[left] >= K) {
//                    sum -= A[left];
//                    left++;
//                }
//                if (right - left + 1 < res) { // 更新结果
//                    res = right - left + 1;
//                    if (res == 1) { // 最短情况，直接返回
//                        return res;
//                    }
//                }
//            }
//            right++;
//        }
//        return res < size + 1 ? res : -1;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int size = A.length;
        int left = 0, right = 0; // 滑动窗口双指针
        int sum = 0; // 记录子序列和
        int res = size + 1;
        while (right < size) {
            sum += A[right];
            if (sum <= 0) { //子序列和此时必小于K，所以双指针都为right + 1
                left = right + 1;
                right = right + 1;
                sum = 0;
                continue;
            }
            int i = right;
            while (A[i] < 0 && i >= 1) {
                A[i - 1] += A[i];
                A[i] = 0;
                i--;
            }
            if (sum >= K) {
                while (left <= right && sum - A[left] >= K) {
                    sum -= A[left];
                    left++;
                }
                // 更新res
                res = Math.min(res, right - left + 1);
                if (res == 1) return res;
            }
            right++;
        }
        return res < size + 1 ? res : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
