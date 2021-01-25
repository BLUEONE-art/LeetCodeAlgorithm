//给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。 
//
// 对它进行优化使其尽量少调用系统方法 Math.random() 。 
//
// 提示: 
//
// 
// 1 <= N <= 1000000000 
// 0 <= B.length < min(100000, N) 
// [0, N) 不包含 N，详细参见 interval notation 。 
// 
//
// 示例 1: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[1,[]],[],[],[]]
//输出: [null,0,0,0]
// 
//
// 示例 2: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[2,[]],[],[],[]]
//输出: [null,1,1,1]
// 
//
// 示例 3: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[3,[1]],[],[],[]]
//Output: [null,0,0,2]
// 
//
// 示例 4: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[4,[2]],[],[],[]]
//输出: [null,1,3,1]
// 
//
// 输入语法说明： 
//
// 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，
//也会输入一个 [] 空列表。 
// Related Topics 排序 哈希表 二分查找 Random 
// 👍 53 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 优化版本：尽可能少调用 random 方法 */
    int N;
    int size;
    int[] blacklist;
    HashMap<Integer, Integer> mapping = new HashMap<>();
    public Solution(int N, int[] blacklist) {
        this.N = N;
        this.blacklist = blacklist;
        // 需要定义一个边界，让 size 左边在黑名单的数字映射成 size 右边不在黑名单内的数字
        // 则数组分成了两边，size 左边都是不在黑名单内的，即使在，也被映射成了不在黑名单的数字
        // size 右边都是黑名单内的数字，不会在 size ~ N - 1 范围内取数字
        size = N - blacklist.length;
        // 给黑名单数初始化到 mapping 中
        for (int i : blacklist) {
            mapping.put(i, 666);
        }
        int last = N - 1;
        // 映射 blacklist 中的黑名单数
        for (int b : blacklist) {
            // 若 size 右边本身存在黑名单数，不需要重新映射
            if (b >= size) {
                continue;
            }
            // 当 last == N - 1 已经在 mapping 中了
            // 即在初始化 mapping 过程中，blacklist 中包括有 last
            // 要保证 size 右边的 last 一定是一个不在黑名单内的数
            while (mapping.containsKey(last)) {
                last--;
            }
            // 只有 b 比 size 小才需要重新映射
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        int randomNum = (int) (Math.random() * size);
        // 如果 randomNum 是在黑名单内
        if (mapping.containsKey(randomNum)) {
            return mapping.get(randomNum);
        }
        return randomNum;
    }

//    int N;
//    int[] blacklist;
//    public Solution(int N, int[] blacklist) {
//        this.N = N;
//        this.blacklist = blacklist;
//    }
//
//    public int pick() {
//        int randomNum = (int) (Math.random() * N);
//        while (Arrays.asList(blacklist).contains(randomNum)) {
//            randomNum = (int) (Math.random() * N);
//        }
//        return randomNum;
//    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)
