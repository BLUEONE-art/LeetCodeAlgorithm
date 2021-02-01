//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法 
// 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路：对二维数组的第 1 列，也就是每个子数组的 end 进行升序排序
    // 遍历二维数组中的每一个数组，如果有数组的 start 索引大于等于前面数组的 end，则找到一个满足条件的数组
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 对每个子数组的 end 升序处理
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1]; // -1 表示升序
            }
        });
        // 即使二维数组中子数组全部重合，不重合数组个数就为 1
        int count = 1;
        // 得到排序后第一个子数组的末尾索引
        int x_end = intervals[0][1];
        // 遍历二维数组
        for (int[] interval : intervals) {
            // interval 就表示一个个的子数组
            int start = interval[0];
            if (start >= x_end) {
                count++;
                // 更新 x_end，再进行比较
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
