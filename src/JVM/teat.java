package JVM;

import java.util.HashMap;
import java.util.Stack;

public class teat {

    public static int canGet(int n, int k) {
        // 初始就有n包
        int count = n;
        int res = count;
        while ((count / k) != 0) {
            int newNoodle = count / k;
            res += newNoodle;
            count %= k;
            count += newNoodle;
        }
        return res;
    }

    public static int minCar() {
        return 1;
    }

//    public static int maxLen(int len, int[] nums) {
//        int[] dp = new int[len];
//        dp[0] = 0;
//        for (int i = 1; i < len; i++) {
//            if (nums[i - 1] != nums[i]) {
//                dp[i] = dp[i - 1] + 2;
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[len - 1];
//    }

//    public static int maxLen(int len, int[] nums) {
//        int max = 0;
//        int tmp = nums[0];
//        for (int i = 1; i < len; i++) {
//            int leftIdx = 0;
//            tmp += nums[i];
//            if (tmp == 1 && nums[i - 1] != 1) {
//                tmp = 0;
//                max = i - leftIdx + 1;
//            }
//        }
//        return max;
//    }

//    public static int maxLen(int len, int[] nums) {
//        if (len == 0 || len == 1) return 0;
//        int max = 0;
//        int leftIdx = 0;
//        int flag = 1;
//        for (int i = 1; i < len; i++) {
//            if (nums[i - 1] != nums[i] || ) {
//                flag -= 1;
//            } else if (nums[i - 1] == nums[i]) {
//                flag += 1;
//            }
//            if (flag == 0) {
//                flag = 1;
//                max = Math.max(max, i - leftIdx + 1);
//                leftIdx = i;
//            }
//        }
//        return max;
//    }

    public static int maxLen(int len, int[] nums) {
        if (len == 0 || len == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(nums[0]);
        for (int i = 1; i < len; i++) {
            if (!stack.isEmpty() && stack.peek() != nums[i]) {
                stack.pop();
                continue;
            }
            stack.push(nums[i]);
        }
        return len - stack.size();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        int count = 0;
        int i = 0;
        int j = 0;
        double res = 0.0;
        int[] mergeNums = new int[sum];
        while (count <= sum && i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                mergeNums[count] = nums1[i];
                i++;
            } else {
                mergeNums[count] = nums2[j];
                j++;
            }
            count++;
        }
        if (i == len1) {
            for (int k = j; k < len2; k++) {
                mergeNums[count] = nums2[k];
                count++;
            }
        } else {
            for (int l = i; l < len1; l++) {
                mergeNums[count] = nums1[l];
                count++;
            }
        }
        if (sum % 2 != 0) {
            res = (double) mergeNums[sum / 2];
        } else {
            res = (double) (mergeNums[sum / 2 - 1] + mergeNums[sum / 2]) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 5};
        int[] nums2 = new int[]{2};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
