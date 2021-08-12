//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1439 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        Map<Character, String> digitToString = new HashMap<>();
        digitToString.put('2', "abc");
        digitToString.put('3', "def");
        digitToString.put('4', "ghi");
        digitToString.put('5', "jkl");
        digitToString.put('6', "mno");
        digitToString.put('7', "pqrs");
        digitToString.put('8', "tuv");
        digitToString.put('9', "wxyz");

        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, digitToString, 0);
        return res;
    }

    public void backtrack(String digit, Map<Character, String> digitToString, int depth) {
        // 终止条件
        if (depth == digit.length()) {
            res.add(path.toString());
            return;
        }
        char num = digit.charAt(depth);
        String s = digitToString.get(num);
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtrack(digit, digitToString, depth + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
