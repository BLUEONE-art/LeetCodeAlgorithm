package algorithm.ip_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    static List<String> res = new ArrayList<>();
    static int[] path = new int[4];
    public static List<String> restoreIpAddresses(String s) {
        helper(s.toCharArray(), 0, 0);
        return res;
    }

    public static void helper(char[] chars, int idx, int resIdx) {
        // 终止条件
        if (resIdx == 4) { // 第四次回溯
            if (idx == chars.length) { // 并且正确执行到最后一位
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(path[i]);
                    sb.append('.');
                }
                sb.append(path[3]);
                res.add(sb.toString());
            }
            return;
        }
        if (idx == chars.length) return; // resIdx != 4 && idx == chars.length，必不满足情况

        if (chars[idx] == '0') { // 如果只有首位0，只需回溯一次
            path[resIdx] = 0;
            helper(chars, idx + 1, resIdx + 1);
        }
        int tmp = 0;
        for (int i = idx; i < chars.length; i++) {
            tmp = tmp * 10 + (chars[i] - '0');
            if (tmp > 0 && tmp < 256) {
                path[resIdx] = tmp;
                helper(chars, i + 1, resIdx + 1);
            } else break;
        }
    }
}


