package algorithm.bytedancebuchong7;
// 长度为n的数组，每个元素代表一个木头长度，木头可以任意截断
// 从这堆木头中截出至少K个长度为m的木头，已知K，求max(m)
// 输入
// n = 5, K = 5
// [4, 7, 2, 10, 5]
// 输出 :4
// 最多可以把它分成5段长度为4的木头

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 2, 10, 5};
        System.out.println(getMaxLen(nums, 2));
    }

    public static int getMaxLen(int[] nums, int k) {
        int left = 1; // 0 根绳子取不到
        int right = -1;
        int mid = 1;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            mid = (right + left + 1) / 2;
            if (check(nums, mid) < k) { // 凑不到k根，需要减小mid
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        return left;
    }

    public static int check(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            res += num / mid;
        }
        return res;
    }
}
