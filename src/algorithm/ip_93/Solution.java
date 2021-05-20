package algorithm.ip_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{55,38,53,81,61,93,97,32,43,78};
//        System.out.println(nextGreaterElement(2147483476));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int nextGreaterElement(int n) {
        int tmp = n, count = 0, res = 0;
        while (tmp != 0) {
            count++;
            tmp /= 10;
        }
        int[] nums = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            nums[i] = n % 10;
            n /= 10;
        }

        int i = count - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        if (i < 0) return -1;

        nextPermutation(nums);
        for (int j = 0; j < nums.length; j++) {
            res = res * 10 + nums[j];
            if (res > Integer.MAX_VALUE / 10 && nums[j + 1] > 7) return -1;
        }
        return res;
    }

    public static void nextPermutation(int[] nums) {
        int size = nums.length;
        if (nums == null || size == 0) return;
        // 从后往前找到第一个逆序对
        int i = size - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        // 此时找到 i 和 i + 1 两个索引对应的值从后往前看是逆序的
        // 想要找到下一个更大的排序，需要找到在 i + 1 ~ size - 1 范围内大于索引 i 对应值的最小值
        if (i >= 0) { // i < 0 表示从后向前看全是升序
            // 大于 nums[i] 的最小值对应的索引
            int j = binSearch(nums, i + 1, size - 1, nums[i]);
            // 交换 nums[i] 和 大于 nums[i] 的最小值
            swap(nums, i, j);
        }
        // 为了使得找到的数是大于数组字典序的最小值，让 nums[i] 后的数字排列为升序即可
        reverse(nums, i + 1, size - 1);
    }

    // nums[left, right] 逆序，查找其中 > target 的 最大下标
    public static int binSearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] > target){
                left = mid + 1; // 尝试再缩小区间
            }
            else{
                right = mid - 1;
            }
        }
        return right;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}

//static List<String> res = new ArrayList<>();
//    static int[] path = new int[4];
//    public static List<String> restoreIpAddresses(String s) {
//        helper(s.toCharArray(), 0, 0);
//        return res;
//    }
//
//    public static void helper(char[] chars, int idx, int resIdx) {
//        // 终止条件
//        if (resIdx == 4) { // 第四次回溯
//            if (idx == chars.length) { // 并且正确执行到最后一位
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < 3; i++) {
//                    sb.append(path[i]);
//                    sb.append('.');
//                }
//                sb.append(path[3]);
//                res.add(sb.toString());
//            }
//            return;
//        }
//        if (idx == chars.length) return; // resIdx != 4 && idx == chars.length，必不满足情况
//
//        if (chars[idx] == '0') { // 如果只有首位0，只需回溯一次
//            path[resIdx] = 0;
//            helper(chars, idx + 1, resIdx + 1);
//        }
//        int tmp = 0;
//        for (int i = idx; i < chars.length; i++) {
//            tmp = tmp * 10 + (chars[i] - '0');
//            if (tmp > 0 && tmp < 256) {
//                path[resIdx] = tmp;
//                helper(chars, i + 1, resIdx + 1);
//            } else break;
//        }
//    }


