package algorithm.ip_93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(calculate("1 + (1 + 8)"));
    }

    public static int calculate(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int len = str.length;

        Stack<Integer> s_num = new Stack<>();
        Stack<Integer> s_sign = new Stack<>();

        int sign = 1; // 正负号或者运算符
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') continue;
            if (str[i] == '+' || str[i] == '-') sign = str[i] == '+' ? 1 : -1;
            else if (str[i] >= '0' && str[i] <= '9') {
                int num = str[i] - '0';
                while (i < len - 1 && str[i + 1] >= '0' && str[i + 1] <= '9') { // 可能有连续的数字
                    num = num * 10 + (str[++i] - '0');
                }
                ans += sign * num;
            }
            else if (str[i] == '(') {
                s_num.push(ans);
                s_sign.push(sign);
                ans = 0;
                sign = 1;
            }
            else ans = s_num.pop() + ans * s_sign.pop(); // 右括号更新结果
        }
        return ans;
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


