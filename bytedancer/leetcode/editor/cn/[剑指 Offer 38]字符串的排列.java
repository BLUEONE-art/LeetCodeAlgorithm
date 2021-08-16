//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        backtrack(s.toCharArray(), 0, visited);
        return res.toArray(new String[res.size()]);
    }

    public void backtrack(char[] chars, int depth, boolean[] visited) {
        if (depth == chars.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.append(chars[i]);
            visited[i] = true;
            backtrack(chars, depth + 1, visited);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
