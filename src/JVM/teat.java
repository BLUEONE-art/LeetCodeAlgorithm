package JVM;

import java.util.*;

public class teat {

    public static int canGet(int n, int k) {
        // 初始就有n包
        int count = n;
        int res = count;
        while ((count / k) != 0) {
            int newNoodle = count / k;
            res += newNoodle;
            count %= k;
            count += newNoodle;
        }
        return res;
    }

    public static int minCar() {
        return 1;
    }

//    public static int maxLen(int len, int[] nums) {
//        int[] dp = new int[len];
//        dp[0] = 0;
//        for (int i = 1; i < len; i++) {
//            if (nums[i - 1] != nums[i]) {
//                dp[i] = dp[i - 1] + 2;
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[len - 1];
//    }

//    public static int maxLen(int len, int[] nums) {
//        int max = 0;
//        int tmp = nums[0];
//        for (int i = 1; i < len; i++) {
//            int leftIdx = 0;
//            tmp += nums[i];
//            if (tmp == 1 && nums[i - 1] != 1) {
//                tmp = 0;
//                max = i - leftIdx + 1;
//            }
//        }
//        return max;
//    }

//    public static int maxLen(int len, int[] nums) {
//        if (len == 0 || len == 1) return 0;
//        int max = 0;
//        int leftIdx = 0;
//        int flag = 1;
//        for (int i = 1; i < len; i++) {
//            if (nums[i - 1] != nums[i] || ) {
//                flag -= 1;
//            } else if (nums[i - 1] == nums[i]) {
//                flag += 1;
//            }
//            if (flag == 0) {
//                flag = 1;
//                max = Math.max(max, i - leftIdx + 1);
//                leftIdx = i;
//            }
//        }
//        return max;
//    }

    public static int maxLen(int len, int[] nums) {
        if (len == 0 || len == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(nums[0]);
        for (int i = 1; i < len; i++) {
            if (!stack.isEmpty() && stack.peek() != nums[i]) {
                stack.pop();
                continue;
            }
            stack.push(nums[i]);
        }
        return len - stack.size();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        int count = 0;
        int i = 0;
        int j = 0;
        double res = 0.0;
        int[] mergeNums = new int[sum];
        while (count <= sum && i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                mergeNums[count] = nums1[i];
                i++;
            } else {
                mergeNums[count] = nums2[j];
                j++;
            }
            count++;
        }
        if (i == len1) {
            for (int k = j; k < len2; k++) {
                mergeNums[count] = nums2[k];
                count++;
            }
        } else {
            for (int l = i; l < len1; l++) {
                mergeNums[count] = nums1[l];
                count++;
            }
        }
        if (sum % 2 != 0) {
            res = (double) mergeNums[sum / 2];
        } else {
            res = (double) (mergeNums[sum / 2 - 1] + mergeNums[sum / 2]) / 2;
        }
        return res;
    }

    public static int[] haveCircularDependency(int n, int[][] prerequisites) {
        // 入度矩阵
        int[] inDegrees = new int[n];
        // 图的邻接矩阵
        List<List<Integer>> adjLists = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        // 一维变二维
        for (int i = 0; i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        // 计算邻接矩阵
        for (int i = 0; i < prerequisites.length; i++) {
            // 起始点
            int cur = prerequisites[i][0];
            // cur -指向-> next
            int next = prerequisites[i][1];
            // 被指向的点的入度+1
            inDegrees[next]++;
            // 邻接矩阵的表示方法：记录当前节点cur指向的节点
            adjLists.get(cur).add(next);
        }
        // 第一次取出入度矩阵中入度为0的节点的下标
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                ans.add(cur);
                List<Integer> adjList = adjLists.get(cur);
                for (int adj : adjList) {
                    // 因为指向adj的cur被取出，所有的被cur指向的节点的入度减1
                    inDegrees[adj]--;
                    if (inDegrees[adj] == 0) {
                        q.offer(adj);
                    }
                }
            }
        }
        int[] res;
        if (ans.size() == n) {
            res = ans.stream().mapToInt(Integer::valueOf).toArray();
        } else {
            res = new int[0];
        }
        return res;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i : arr) {
            q.offer(i);
            if (q.size() > arr.length - k) {
                res.add(q.poll());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

        String line = "a b  c    ";      // 1
        String str = "a b c      d";     // 2
        String [] tmp = line.split(" ");
        System.out.println(tmp.length+"------");
        for(int i=0;i<tmp.length;i++){
            System.out.println(i+"="+tmp[i]);
        }

        String [] items = line.split(" ",-1);
        System.out.println(items.length+"========");
        for(int i=0;i<items.length;i++){
            System.out.println(i+"="+items[i]);
        }
    }
}
