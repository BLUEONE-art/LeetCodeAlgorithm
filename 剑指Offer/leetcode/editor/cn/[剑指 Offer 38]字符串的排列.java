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
// Related Topics 回溯算法 
// 👍 186 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 定义结果
    List<String> res = new LinkedList<>();
    char[] chars;
    public String[] permutation(String s) {
        // 将字符串转成字符数组
        chars = s.toCharArray();
//        // 存放每一个可行的结果
//        LinkedList<Character> track = new LinkedList<>();
        backtrack(0);
        return res.toArray(new String[res.size()]);
    }
    // 回溯算法，i 表示字符串 s 中的下标为 x 的字符
    public void backtrack(int x) {
        // 判断重复字符
        HashSet<Character> repeat = new HashSet<>();
        // 结束条件
        if (x == chars.length - 1) {
            res.add(charToString(chars));
            return;
        }
        // 选择列表
        for (int i = x; i < chars.length; i++) {
            // 重复元素-->剪枝
            if (repeat.contains(chars[i])) continue;
            repeat.add(chars[i]);
            // 做选择
            swap(i, x);
            // 递归下一次做选择
            backtrack(x + 1);
            // 撤销选择
            swap(i, x);
        }
    }
    // 交换字符数组中字符的位置
    public void swap(int i, int x) {
        char tmp = chars[i];
        chars[i] = chars[x];
        chars[x] = tmp;
    }
    // 字符数组转字符串
    public String charToString(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

//    // 定义结果
//    List<String> res = new LinkedList<>();
//    char[] chars;
//    public String[] permutation(String s) {
//        // 将字符串转成字符数组
//        chars = s.toCharArray();
//        // 存放每一个可行的结果
//        LinkedList<Character> track = new LinkedList<>();
//        backtrack(chars, track);
//        return res.toArray(new String[res.size()]);
//    }
//    // 回溯算法
//    public void backtrack(char[] chars, LinkedList<Character> track) {
//        // 结束条件
//        if (track.size() == chars.length) {
//            res.add(charListToStr(track));
//            return;
//        }
//        // 选择列表
//        for (int i = 0; i < chars.length; i++) {
//            if (track.contains(chars[i])) continue;
//            // 做选择
//            track.add(chars[i]);
//            // 递归下一次做选择
//            backtrack(chars, track);
//            // 撤销选择
//            track.removeLast();
//        }
//    }
//    // 字符链表转字符串
//    public String charListToStr(LinkedList<Character> track) {
//        StringBuilder sb = new StringBuilder();
//        for (Character character : track) {
//            sb.append(character);
//        }
//        return sb.toString();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
