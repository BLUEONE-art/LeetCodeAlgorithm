package algorithm.ip_93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1]; // 前i个字符的解码数
        dp[0] = 1; // 前0个字符，就1种
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') { // 前导0排除
                dp[i] = dp[i - 1];
            }
            if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}

//     static List<String> res = new ArrayList<>();
//    static int[] path = new int[4];
//    public static List<String> restoreIpAddresses(String s) {
//        helper(s.toCharArray(),0, 0);
//        return res;
//    }
//
//    public static void helper(char[] str, int idx, int resIdx) {
//        // 终止条件
//        if (resIdx == 4) {
//            if (idx == str.length) {
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
//        if (idx == str.length) return; // resIdx == 4 && idx == str,length
//        // 回溯
//        if (str[idx] == '0') { // 只需回溯一次
//            path[resIdx] = 0;
//            helper(str, idx + 1, resIdx + 1);
//        }
//        int tmp = 0;
//        for (int i = idx; i < str.length; i++) {
//            tmp = tmp * 10 + (str[i] - '0');
//            if (tmp > 0 && tmp < 256) {
//                path[resIdx] = tmp;
//                helper(str, i + 1, resIdx + 1);
//            } else break;
//        }
//    }




