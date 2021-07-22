// 有一个二维的会议时间的安排数组，判断一个人能否参加所有会议
// [[7, 10], [2, 4]] 返回true

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return false;
        }
        // 将二维数组按第二列升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[1] < interval2[1]) {
                    // 维持原始顺序
                    return 1;
                } else if (interval1[1] > interval2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int lastNumOfinterval = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] < lastNumOfinterval) {
                return false;
            }
        }
        return true;
    }
}