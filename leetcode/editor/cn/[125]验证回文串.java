//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 311 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 核心思想：判断是不是回文串，只需从两端的元素进行比较，只要有一个不同，则返回 false，否则返回 true。
    public boolean isPalindrome(String s) {
        // 先将字符串统一变成小写
        String str = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        // base case
        if (s == null || s.length() == 0) return true;

        // 注意循环条件
        while (left < right) {
            // 假如字符串中左边存在除了字母和数字以外的符号，让 left++;
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }

            // 假如字符串中右边存在除了字母和数字以外的符号，让 right--;
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            if (str.charAt(left) != str.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
