//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 929 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        // 每个区间按照区间左端元素升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 前一个右端小于后一个左端
            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            }
            else { // 合并 res[idx][1] >= interval[0]
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        // array = new int[]{3, 10, 4, 0, 2};
        //int[] arrayCopy = Arrays.copyOf(array, 3);
        //out.println(Arrays.toString(arrayCopy)); //[3, 10, 4]
        //
        //arrayCopy = Arrays.copyOf(array, 7);
        //out.println(Arrays.toString(arrayCopy)); //[3, 10, 4, 0, 2, 0, 0], 多出的长度补0
        //
        //arrayCopy = Arrays.copyOfRange(array, 1, 4);
        //out.println(Arrays.toString(arrayCopy)); //[10, 4, 0]
        return Arrays.copyOf(res, idx + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
