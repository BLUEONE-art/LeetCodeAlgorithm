//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 992 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用字符串集合拼凑目标字符串，且可以使用多次和讲究顺序
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 以i结尾的字符串能否被wordDict组合而成
        // 完背 + 顺序 ==> tar顺序 + arr顺序
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            for (String word : wordDict) {
                int size = word.length();
                // 目标字符串比子字符串还小，必不可能组成
                if (i - size >= 0 && s.substring(i - size, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - size];
                }
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
