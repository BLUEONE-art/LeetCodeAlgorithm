//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 239 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean sign = (numerator > 0) ^ (denominator > 0);
        StringBuilder res = new StringBuilder();
        if (sign) {
            res.append("-");
        }
        long numerator_long = numerator;
        long denominator_long = denominator;
        numerator_long = Math.abs(numerator_long);
        denominator_long = Math.abs(denominator_long);

        long integer = numerator_long / denominator_long;
        res.append(integer);

        String dot = ".";
        long remainder = numerator_long % denominator_long;
        if (remainder == 0) {
            return res.toString();
        } else {
            res.append(dot);
        }

        // 处理多位小数+循环小数
        Map<Long, Integer> map = new HashMap<>();
        int idx = res.length() - 1;
        while (remainder > 0) {
            idx++;
            remainder *= 10;
            if (map.get(remainder) != null) {
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            } else {
                map.put(remainder, idx);
            }
            res.append(remainder / denominator_long);
            remainder = remainder % denominator_long;
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
