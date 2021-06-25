package JVM;


import org.junit.Test;

import java.util.*;

public class Demo {
//    public static void main(String[] args) {
//        // 返回虚拟机试图使用的最大内存(字节)
//        long max = Runtime.getRuntime().maxMemory(); // byte --> 除以 1024 得KB --> 除以 1024 得 MB
//        // 返回 JVM 初始化的总内存(字节)
//        long total = Runtime.getRuntime().totalMemory();
//
//        System.out.println("max虚拟机试图使用的最大内存=" + max + "字节\t" +
//                "转换为MB=" + (max/(double)1024/1024) + "MB");
//
//        System.out.println("total虚拟机初始化的总内存=" + total + "字节\t" +
//                "转换为MB=" + (total/(double)1024/1024) + "MB");
//    }

    @Test
    public static void main(String[] args) {
        int operationLen = 8;
        char[] operations = new char[]{'-', '+', '-', '-', '+', '-', '-', '+'};
        List<Integer> path1 = new ArrayList<>();
        path1.add(1);
        path1.add(8);
        List<Integer> path2 = new ArrayList<>();
        path2.add(2);
        path2.add(8);
        List<Integer> path3 = new ArrayList<>();
        path3.add(1);
        path3.add(1);
        List<List<Integer>> invalidOperationRange = new ArrayList<>();
        invalidOperationRange.add(path1);
        invalidOperationRange.add(path2);
        invalidOperationRange.add(path3);
        System.out.println(countNumLists(operationLen, operations, invalidOperationRange));
    }

    public static List<Integer> countNumLists(int operationLen, char[] operations, List<List<Integer>> invalidOperationRange) {
        List<List<Integer>> resLists = new ArrayList<>();
        // 减去操作无效的操作区间
        for (List<Integer> integers : invalidOperationRange) {
            int invalidOperationLen = integers.get(1) -  integers.get(0) + 1;
            char[] operationRange = new char[operationLen - invalidOperationLen];
            System.arraycopy(operations, operationLen - operationRange.length, operationRange, 0, operationRange.length);
            // 计算不重复元素个数
            int x = 0; // 初始元素为0
            List<Integer> path = new ArrayList<>();
            path.add(x); // 初始什么都不操作的情况下
            for (char c : operationRange) {
                if (c == '+') {
                    x += 1;
                }
                else {
                    x -= 1;
                }
                path.add(x);
            }
            resLists.add(path);
        }
        // 统计不同元素个数
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (List<Integer> resList : resLists) {
            set.addAll(resList);
            res.add(set.size());
            set.clear();
        }
        return res;
    }

}
