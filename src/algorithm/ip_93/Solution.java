package algorithm.ip_93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findKthNumber(101,5));
    }

    public static int findKthNumber(int n, int k) {
        int cur = 1;
        k = k - 1;//扣除掉第一个0节点
        while(k>0){
            int num = getNode(n,cur,cur+1);
            if(num<=k){//第k个数不在以cur为根节点的树上
                cur+=1;//cur在字典序数组中从左往右移动
                k-=num;
            }else{//在子树中
                cur*=10;//cur在字典序数组中从上往下移动
                k-=1;//刨除根节点
            }
        }
        return cur;
    }
    public static int getNode(int n, long first, long last){
        int num = 0;
        while(first <= n){
            num += Math.min(n+1,last) - first;//比如n是195的情况195到100有96个数
            first *= 10;
            last *= 10;
        }
        return num;
    }
}

//     static List<String> res = new ArrayList<>();
//    static int[] path = new int[4];
//    public static List<String> restoreIpAddresses(String s) {
//        helper(s.toCharArray(),0, 0);
//        return res;
//    }
//
//    public static void helper(char[] str, int idx, int resIdx) {
//        // 终止条件
//        if (resIdx == 4) {
//            if (idx == str.length) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < 3; i++) {
//                    sb.append(path[i]);
//                    sb.append('.');
//                }
//                sb.append(path[3]);
//                res.add(sb.toString());
//            }
//            return;
//        }
//        if (idx == str.length) return; // resIdx == 4 && idx == str,length
//        // 回溯
//        if (str[idx] == '0') { // 只需回溯一次
//            path[resIdx] = 0;
//            helper(str, idx + 1, resIdx + 1);
//        }
//        int tmp = 0;
//        for (int i = idx; i < str.length; i++) {
//            tmp = tmp * 10 + (str[i] - '0');
//            if (tmp > 0 && tmp < 256) {
//                path[resIdx] = tmp;
//                helper(str, i + 1, resIdx + 1);
//            } else break;
//        }
//    }




