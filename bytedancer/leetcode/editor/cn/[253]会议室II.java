// 有一个二维的会议时间的安排数组，判断至少需要多少个场地才能同时召开会议
// [[7, 10], [2, 4]] 返回true

class Solution {
    public int canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 将二维数组按第二列升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[1] < interval2[1]) {
                    // 维持原始顺序
                    return -1;
                } else if (interval1[1] > interval2[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int count = 1;
        int lastNumOfinterval = intervals[0][1];
        for (int[] interval : intervals) {
            if (lastNumOfinterval < interval[0]) {
                lastNumOfinterval = interval[1];
                count++;
            }
        }
        return count;
    }
}