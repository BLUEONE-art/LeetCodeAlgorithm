//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 573 👎 0

//     List<String> res = new ArrayList<>();
//    int[] path = new int[4]; // ip一截最多四个字符
//    public List<String> restoreIpAddresses(String s) {
//        helper(s.toCharArray(), 0, 0);
//        return res;
//    }
//
//    public void helper(char[] chars, int resIdx, int idx) {
//        // 终止条件
//        if (resIdx == 4) { // 找到一个可能的Ip
//            if (idx == chars.length) {
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
//        if (idx == chars.length) return;
//
//        // 如果首位元素为0，则只有这一位为0的时候合法，后面的无需递归
//        if (chars[idx] == '0') {
//            path[resIdx] = 0;
//            helper(chars, resIdx + 1, idx + 1);
//        }
//        int tmp = 0;
//        for (int i = idx; i < chars.length; i++) {
//            tmp = tmp * 10 + (chars[i] - '0');
//            if (tmp > 0 && tmp < 256) {
//                path[resIdx] = tmp;
//                helper(chars, resIdx + 1, i + 1);
//            } else break;
//        }
//    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    int[] path = new int[4];
    public List<String> restoreIpAddresses(String s) {
        helper(s.toCharArray(), 0, 0);
        return res;
    }

    public void helper(char[] chars, int idx, int resIdx) {
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
//leetcode submit region end(Prohibit modification and deletion)
