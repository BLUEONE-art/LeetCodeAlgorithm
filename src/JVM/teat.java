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

    public static void main(String[] args) {
        int len = 6;
        int[] nums = new int[]{1, 0, 1, 1, 0, 0};
        int res = maxLen(len, nums);
        System.out.println(res);
    }
}
