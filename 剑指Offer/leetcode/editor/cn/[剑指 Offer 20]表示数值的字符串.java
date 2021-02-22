//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        // 去除 s 前面的空格，再转换为字符数组
        char[] str = s.trim().toCharArray();
        // 依次对每个字符进行判断
        boolean isNum = false, isDot = false, ise_or_E = false;
        for (int i = 0; i < str.length; i++) {
            // 如果该字符是数组，返回 true
            if (str[i] >= '0' && str[i] <= '9') isNum = true;
            // 遇到小数点
            else if (str[i] == '.') {
                // '.' 可以出现在首位，但不能重复出现，并且不能出现 'e' or 'E'
                if (isDot || ise_or_E) return false;
                isDot = true;
            }
            // 遇到 'e' or 'E'
            else if (str[i] == 'e' || str[i] == 'E') {
                // 'e' or 'E' 前面必须有整数，并且前面不能有重复的 'e' or 'E'
                if (!isNum || ise_or_E) return false;
                ise_or_E = true;
                // 重置 isNum，防止出现 123e 或者 123e+ 的情况
                isNum = false;
            }
            // 遇到 '+' or '-'
            else if (str[i] == '+' || str[i] == '-') {
                // '+' or '-' 只能出现在最前面或者紧跟 'e' 后面
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
            } else return false; // 其他情况均是不合法字符
        }
        return isNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
